import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.FlowLayout
import javax.swing.*

/**
 * Kotlin Swing 计算器应用程序
 * 提供图形界面进行基本四则运算
 */
class SwingCalculator : JFrame("Kotlin Swing 计算器") {
    // 🔧 控件定义 - 声明界面所需的各种Swing组件

    /** 第一个数字输入框 */
    private val num1Field = JTextField(8)

    /** 第二个数字输入框 */
    private val num2Field = JTextField(8)

    /** 运算符选择下拉框，包含四则运算符号 */
    private val opBox = JComboBox(arrayOf("+", "-", "*", "/"))

    /** 结果显示标签，用于显示计算结果 */
    private val resultLab = JLabel(
        "结果：",
        SwingConstants.CENTER,
    )

    /** 计算按钮，触发计算操作 */
    private val calcBtn = JButton("=")

    /** 清空按钮，重置所有输入和结果显示 */
    private val clearBtn = JButton("清空")

    /**
     * 初始化块 - 构造函数的一部分
     * 负责界面布局和事件绑定
     */
    init {
        // 🧩 输入面板 - 创建包含数字输入和运算符选择的面板
        val inputPanel = JPanel(FlowLayout()).apply {
            // 添加标签和对应的输入控件
            add(JLabel("数字 1：")); add(num1Field)
            add(JLabel("数字 2：")); add(num2Field)
            add(JLabel("运算：")); add(opBox)
        }

        // 🎯 按钮面板 - 创建包含操作按钮的面板
        val btnPanel = JPanel(FlowLayout()).apply {
            // 添加计算和清空按钮
            add(calcBtn); add(clearBtn)
        }

        // 🪟 主窗体 - 设置整体布局和组件分布
        layout = BorderLayout()
        // 将输入面板放置在北部区域
        add(inputPanel, BorderLayout.NORTH)
        // 将按钮面板放置在中部区域
        add(btnPanel, BorderLayout.CENTER)
        // 将结果标签放置在南部区域
        add(resultLab, BorderLayout.SOUTH)

        // ⚡ 事件绑定 - 为按钮添加点击事件处理器
        // 使用lambda表达式简化事件处理代码
        calcBtn.addActionListener { calculate() }
        clearBtn.addActionListener { clear() }

        // 🎨 窗体配置 - 设置窗口属性
        // 设置关闭操作为退出应用程序
        defaultCloseOperation = EXIT_ON_CLOSE
        // 设置窗口首选大小
        preferredSize = Dimension(420, 160)
        // 自动调整窗口大小以适应内容
        pack()
        // 设置窗口可见
        isVisible = true
        // 设置窗口居中显示
        setLocationRelativeTo(null)
    }

    /**
     * 计算逻辑 - 执行实际的数学运算
     * 从输入框获取数值，进行运算并将结果显示在标签上
     */
    private fun calculate() {
        // 尝试将输入文本转换为双精度浮点数，若失败则返回null
        val a = num1Field.text.toDoubleOrNull()
        val b = num2Field.text.toDoubleOrNull()

        // 验证输入是否为有效数字
        if (a == null || b == null) {
            // 输入无效时显示错误对话框
            JOptionPane.showMessageDialog(
                this, "请输入合法数字！",
                "错误",
                JOptionPane.ERROR_MESSAGE,
            )
            return
        }

        // 获取选中的运算符
        val op = opBox.selectedItem as String

        // 根据运算符执行对应计算
        val res: Double = when (op) {
            "+" -> a + b           // 加法运算
            "-" -> a - b           // 减法运算
            "*" -> a * b           // 乘法运算
            "/" -> if (b.isZero()) {  // 除法运算需要检查除零情况
                // 除数为零时显示错误对话框
                JOptionPane.showMessageDialog(
                    this,
                    "除数不能为零！",
                    "错误",
                    JOptionPane.ERROR_MESSAGE,
                )
                return
            } else a / b

            else -> return  // 未知运算符直接返回
        }
        // 更新结果标签显示计算结果
        resultLab.text = "结果：$res"
    }

    /**
     * 清空重置 - 重置所有输入框和结果显示
     */
    private fun clear() {
        // 清空两个数字输入框
        num1Field.text = ""
        num2Field.text = ""
        // 重置结果显示标签
        resultLab.text = "结果："
        // 重置运算符选择为第一项（加号）
        opBox.selectedIndex = 0
    }

    /**
     * 除零保护 - 检查双精度数是否接近零
     * 使用epsilon比较避免浮点数精度问题
     */
    private fun Double.isZero() = kotlin.math.abs(this) < 1e-10
}

/**
 * 程序入口点
 * 使用invokeLater确保GUI在事件调度线程中创建
 */
fun main() = SwingUtilities.invokeLater { SwingCalculator() }
