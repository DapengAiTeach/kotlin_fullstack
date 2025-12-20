import java.awt.EventQueue
import javax.swing.*

/**
 * Kotlin Swing GUI应用程序入口点
 * 使用简洁的函数式编程风格创建并显示一个简单的窗口
 */
fun main() = EventQueue.invokeLater {
    // 创建JFrame窗口实例并使用apply进行链式配置
    JFrame("Kotlin Swing").apply {
        // 设置窗口关闭操作：点击关闭按钮时退出应用程序
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE

        // 向窗口添加一个标签组件显示文本内容
        add(JLabel("Hello, Swing!"))

        // 自动调整窗口大小以适应其子组件
        pack()

        // 设置窗口相对于屏幕居中显示
        setLocationRelativeTo(null)

        // 设置窗口可见性为true，使其显示在屏幕上
        isVisible = true
    }
}
