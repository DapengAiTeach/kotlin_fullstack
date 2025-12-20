import java.awt.BorderLayout
import java.awt.Font
import java.awt.EventQueue
import javax.swing.*

/**
 * Kotlin Swing 日志输出窗口应用
 * 创建一个带有滚动条的文本区域，用于显示日志信息
 */
fun main() = EventQueue.invokeLater {
    // 创建日志输出窗口并进行配置
    JFrame("日志输出窗口").apply {
        // 设置窗口关闭操作：点击关闭按钮时退出应用程序
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        // 创建文本区域用于显示日志内容
        val textArea = JTextArea(8, 30).apply {
            // 设置字体，使用等宽字体便于查看日志
            font = Font(Font.MONOSPACED, Font.PLAIN, 12)
            // 设置为只读模式，防止用户意外修改日志内容
            isEditable = false
            // 设置行包装，使长文本自动换行
            lineWrap = true
            // 在单词边界换行
            wrapStyleWord = true
        }

        // 创建滚动面板包装文本区域，提供滚动功能
        val scroll = JScrollPane(textArea).apply {
            // 设置垂直滚动条始终显示
            verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
            // 设置水平滚动条按需显示
            horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        }

        // 将滚动面板添加到窗口中央区域
        add(scroll, BorderLayout.CENTER)

        // 自动调整窗口大小以适应其子组件
        pack()

        // 设置窗口相对于屏幕居中显示
        setLocationRelativeTo(null)

        // 设置窗口可见性为true，使其显示在屏幕上
        isVisible = true

        // 演示日志输出功能
        log(textArea, "应用程序启动成功")
        log(textArea, "窗口大小: $width x $height")
        log(textArea, "日志功能初始化完成")
    }
}

/**
 * 日志输出函数
 * 向指定的文本区域追加日志消息
 *
 * @param textArea 目标文本区域组件
 * @param msg 要输出的日志消息
 */
fun log(textArea: JTextArea, msg: String) {
    // 在文本区域末尾追加消息和换行符
    textArea.append("$msg\n")
    // 自动滚动到底部，确保最新消息可见
    textArea.caretPosition = textArea.document.length
}