import javax.swing.*
import java.awt.*
import javax.swing.border.EmptyBorder

/**
 * Swing GUI面板配置示例
 * 演示使用apply函数配置JPanel组件并显示界面
 */
fun main() {
    // 确保在事件调度线程中创建和显示GUI
    SwingUtilities.invokeLater {
        // 创建JFrame窗口并使用apply函数进行配置
        val frame = JFrame("Kotlin Swing 示例").apply {
            // 设置默认关闭操作
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            // 设置窗口大小
            setSize(300, 200)
            // 设置窗口居中显示
            setLocationRelativeTo(null)
        }

        // 创建JPanel实例并使用apply函数进行配置
        val panel = JPanel().apply {
            // 设置布局管理器为FlowLayout
            layout = FlowLayout()
            // 设置背景颜色为白色
            background = Color.WHITE
            // 设置空白边框，参数为(top, left, bottom, right)间距
            border = EmptyBorder(10, 10, 10, 10)
            // 添加标签组件
            add(JLabel("Hello, Kotlin Swing!"))
            // 可以继续添加更多配置...
        }

        // 将配置好的面板添加到框架中
        frame.add(panel)

        // 设置窗口可见
        frame.isVisible = true

        // panel已配置完成，可直接使用
        println("面板配置完成，背景色: ${panel.background}")
        println("边框类型: ${panel.border?.javaClass?.simpleName}")
        println("子组件数量: ${panel.componentCount}")
    }
}
