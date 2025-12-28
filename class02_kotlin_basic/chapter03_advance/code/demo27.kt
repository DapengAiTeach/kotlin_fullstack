/**
 * Kotlin + Swing 像素方块游戏示例
 *
 * 本示例演示如何使用Kotlin和Swing开发一个简单的交互式游戏
 * 游戏特性：
 * 1. 33x33行列的像素方块网格
 * 2. 每个方块随机初始化为黑色或白色
 * 3. 点击方块将其变为红色
 * 4. 最多同时显示5个红色方块（超过5个时移除最早的）
 * 5. 采用函数式编程思想，代码结构清晰专业
 *
 * 核心概念：
 * - 数据模型：使用不可变数据结构表示游戏状态
 * - 函数式操作：使用map、filter等函数式操作处理数据
 * - 事件处理：使用高阶函数处理鼠标点击事件
 * - UI更新：通过重绘机制实现游戏画面更新
 */

import javax.swing.*
import java.awt.*
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import kotlin.random.Random

/**
 * 像素方块的数据模型
 * 使用数据类表示单个方块的状态
 *
 * @param row 方块所在的行号（0-32）
 * @param col 方块所在的列号（0-32）
 * @param color 方块的颜色（BLACK、WHITE、RED）
 */
data class PixelBlock(
    val row: Int,
    val col: Int,
    val color: BlockColor
)

/**
 * 方块颜色枚举
 * 定义游戏中可能出现的三种颜色
 */
enum class BlockColor(val rgbColor: Color) {
    BLACK(Color.BLACK),      // 黑色方块
    WHITE(Color.WHITE),      // 白色方块
    RED(Color.RED)           // 红色方块（被点击的方块）
}

/**
 * 游戏状态数据模型
 * 使用不可变数据结构表示整个游戏的状态
 *
 * @param blocks 所有方块的集合，使用Set存储以便快速查找
 * @param redBlockPositions 当前红色方块的位置列表，按时间顺序存储
 */
data class GameState(
    val blocks: Set<PixelBlock>,
    val redBlockPositions: List<Pair<Int, Int>> = emptyList()
)

/**
 * 游戏配置常量
 * 集中管理所有游戏参数，便于调整和维护
 */
object GameConfig {
    const val GRID_SIZE = 33              // 网格大小（33x33）
    const val BLOCK_SIZE = 20             // 每个方块的像素大小
    const val MAX_RED_BLOCKS = 5          // 最多同时显示的红色方块数
    const val WINDOW_WIDTH = GRID_SIZE * BLOCK_SIZE + 20
    const val WINDOW_HEIGHT = GRID_SIZE * BLOCK_SIZE + 40
}

/**
 * 游戏逻辑处理类
 * 包含所有与游戏逻辑相关的函数式操作
 */
object GameLogic {
    /**
     * 初始化游戏状态
     * 创建33x33的方块网格，每个方块随机为黑色或白色
     *
     * @return 初始化后的游戏状态
     */
    fun initializeGame(): GameState {
        // 使用函数式方法生成所有方块
        val blocks = (0 until GameConfig.GRID_SIZE)
            .flatMap { row ->
                (0 until GameConfig.GRID_SIZE).map { col ->
                    // 随机选择黑色或白色
                    val color = if (Random.nextBoolean()) BlockColor.BLACK else BlockColor.WHITE
                    PixelBlock(row, col, color)
                }
            }
            .toSet()

        return GameState(blocks = blocks)
    }

    /**
     * 处理方块点击事件
     * 将点击的方块变为红色，并管理红色方块的数量限制
     *
     * @param state 当前游戏状态
     * @param row 点击的方块行号
     * @param col 点击的方块列号
     * @return 更新后的游戏状态
     */
    fun handleBlockClick(state: GameState, row: Int, col: Int): GameState {
        // 检查点击位置是否有效
        if (row !in 0 until GameConfig.GRID_SIZE || col !in 0 until GameConfig.GRID_SIZE) {
            return state
        }

        // 检查该位置是否已经是红色
        val isAlreadyRed = state.redBlockPositions.contains(Pair(row, col))
        if (isAlreadyRed) {
            return state
        }

        // 添加新的红色方块位置
        val newRedPositions = state.redBlockPositions + Pair(row, col)

        // 如果超过最大数量，移除最早的红色方块
        val limitedRedPositions = if (newRedPositions.size > GameConfig.MAX_RED_BLOCKS) {
            newRedPositions.drop(1)  // 移除第一个（最早的）
        } else {
            newRedPositions
        }

        // 更新方块颜色
        val updatedBlocks = updateBlockColors(state.blocks, limitedRedPositions)

        return GameState(
            blocks = updatedBlocks,
            redBlockPositions = limitedRedPositions
        )
    }

    /**
     * 更新方块颜色
     * 根据红色方块位置列表，更新所有方块的颜色
     *
     * @param blocks 原始方块集合
     * @param redPositions 红色方块的位置列表
     * @return 更新后的方块集合
     */
    private fun updateBlockColors(
        blocks: Set<PixelBlock>,
        redPositions: List<Pair<Int, Int>>
    ): Set<PixelBlock> {
        // 将红色位置转换为Set以便快速查找
        val redSet = redPositions.toSet()

        // 使用map函数转换每个方块的颜色
        return blocks
            .map { block ->
                if (redSet.contains(Pair(block.row, block.col))) {
                    block.copy(color = BlockColor.RED)
                } else {
                    // 恢复原始颜色（黑色或白色）
                    // 这里简化处理：红色方块变回黑色
                    if (block.color == BlockColor.RED) {
                        block.copy(color = BlockColor.BLACK)
                    } else {
                        block
                    }
                }
            }
            .toSet()
    }

    /**
     * 获取指定位置的方块
     * 使用函数式方法查找方块
     *
     * @param blocks 方块集合
     * @param row 行号
     * @param col 列号
     * @return 找到的方块，如果不存在则返回null
     */
    fun getBlockAt(blocks: Set<PixelBlock>, row: Int, col: Int): PixelBlock? {
        return blocks.find { it.row == row && it.col == col }
    }
}

/**
 * 游戏UI面板
 * 继承JPanel，负责游戏画面的绘制和事件处理
 */
class GamePanel : JPanel() {
    // 游戏状态，使用var以便更新
    private var gameState = GameLogic.initializeGame()

    init {
        // 设置面板背景色
        background = Color.LIGHT_GRAY

        // 添加鼠标点击事件监听器
        addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent) {
                handleMouseClick(e)
            }
        })
    }

    /**
     * 处理鼠标点击事件
     * 将屏幕坐标转换为方块坐标，并更新游戏状态
     *
     * @param event 鼠标事件
     */
    private fun handleMouseClick(event: MouseEvent) {
        // 计算点击位置对应的方块坐标
        val col = event.x / GameConfig.BLOCK_SIZE
        val row = event.y / GameConfig.BLOCK_SIZE

        // 更新游戏状态
        gameState = GameLogic.handleBlockClick(gameState, row, col)

        // 重绘面板
        repaint()
    }

    /**
     * 绘制游戏画面
     * 遍历所有方块并绘制
     *
     * @param g 图形上下文
     */
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val g2d = g as Graphics2D

        // 启用抗锯齿以获得更好的图形质量
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)

        // 遍历所有方块并绘制
        gameState.blocks.forEach { block ->
            drawBlock(g2d, block)
        }

        // 绘制网格线（可选，用于清晰显示方块边界）
        drawGrid(g2d)
    }

    /**
     * 绘制单个方块
     * 根据方块颜色填充矩形
     *
     * @param g 图形上下文
     * @param block 要绘制的方块
     */
    private fun drawBlock(g: Graphics2D, block: PixelBlock) {
        // 计算方块的屏幕坐标
        val x = block.col * GameConfig.BLOCK_SIZE
        val y = block.row * GameConfig.BLOCK_SIZE

        // 设置填充颜色
        g.color = block.color.rgbColor

        // 绘制填充矩形
        g.fillRect(x, y, GameConfig.BLOCK_SIZE, GameConfig.BLOCK_SIZE)

        // 绘制边框（黑色）
        g.color = Color.BLACK
        g.stroke = BasicStroke(1f)
        g.drawRect(x, y, GameConfig.BLOCK_SIZE, GameConfig.BLOCK_SIZE)
    }

    /**
     * 绘制网格线
     * 用浅灰色线条显示方块边界
     *
     * @param g 图形上下文
     */
    private fun drawGrid(g: Graphics2D) {
        g.color = Color.LIGHT_GRAY
        g.stroke = BasicStroke(0.5f)

        // 绘制竖线
        for (col in 0..GameConfig.GRID_SIZE) {
            val x = col * GameConfig.BLOCK_SIZE
            g.drawLine(x, 0, x, GameConfig.GRID_SIZE * GameConfig.BLOCK_SIZE)
        }

        // 绘制横线
        for (row in 0..GameConfig.GRID_SIZE) {
            val y = row * GameConfig.BLOCK_SIZE
            g.drawLine(0, y, GameConfig.GRID_SIZE * GameConfig.BLOCK_SIZE, y)
        }
    }

    /**
     * 获取推荐的面板大小
     *
     * @return 面板的推荐尺寸
     */
    override fun getPreferredSize(): Dimension {
        return Dimension(
            GameConfig.GRID_SIZE * GameConfig.BLOCK_SIZE,
            GameConfig.GRID_SIZE * GameConfig.BLOCK_SIZE
        )
    }
}

/**
 * 游戏主窗口
 * 创建并配置游戏窗口
 */
class GameWindow {
    /**
     * 初始化并显示游戏窗口
     */
    fun show() {
        // 创建主窗口
        val frame = JFrame("像素方块游戏 - Kotlin + Swing").apply {
            // 设置窗口关闭时退出程序
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE

            // 创建游戏面板
            val gamePanel = GamePanel()

            // 添加面板到窗口
            add(gamePanel)

            // 设置窗口大小
            setSize(GameConfig.WINDOW_WIDTH, GameConfig.WINDOW_HEIGHT)

            // 设置窗口位置为屏幕中心
            setLocationRelativeTo(null)

            // 禁止调整窗口大小
            isResizable = false

            // 显示窗口
            isVisible = true
        }
    }
}

/**
 * 游戏启动函数
 * 程序入口点
 */
fun main() {
    // 在事件分发线程中创建和显示游戏窗口
    // 这是Swing应用的标准做法
    SwingUtilities.invokeLater {
        GameWindow().show()
    }
}

/**
 * 使用说明：
 *
 * 1. 游戏界面：
 *    - 显示33x33的像素方块网格
 *    - 黑色和白色方块随机分布
 *
 * 2. 游戏操作：
 *    - 点击任何方块，该方块变为红色
 *    - 最多同时显示5个红色方块
 *    - 当红色方块超过5个时，最早的红色方块会变回黑色
 *
 * 3. 代码特点：
 *    - 采用函数式编程思想：使用map、filter等高阶函数
 *    - 数据不可变：使用data class和val定义不可变数据
 *    - 结构清晰：逻辑分离，每个类和函数职责单一
 *    - 详细注解：每个重要部分都有中文注释说明
 *
 * 4. 扩展建议：
 *    - 添加游戏计分系统
 *    - 添加难度等级
 *    - 添加音效和动画
 *    - 添加游戏暂停/继续功能
 *    - 添加排行榜
 */
