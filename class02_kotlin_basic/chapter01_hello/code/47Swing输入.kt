import java.awt.FlowLayout
import java.awt.EventQueue
import javax.swing.*

/**
 * Kotlin Swing计算器应用
 * 创建一个简单的GUI应用程序，用于计算用户输入数字的平方
 */
fun main() = EventQueue.invokeLater {
    // 创建主窗口并进行配置
    JFrame("平方计算器").apply {
        // 设置窗口关闭操作：点击关闭按钮时退出应用程序
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        // 创建面板用于组织组件
        JPanel().apply {
            // 设置布局管理器为FlowLayout，组件从左到右排列
            layout = FlowLayout(FlowLayout.CENTER, 10, 10)

            // 添加提示标签
            add(JLabel("请输入数字:"))

            // 创建文本输入框，参数10表示列宽
            val input = JTextField(10).apply {
                // 设置输入框获得焦点
                requestFocusInWindow()
            }
            add(input)

            // 创建确认按钮
            val ok = JButton("计算平方").apply {
                // 为按钮添加点击事件监听器
                addActionListener {
                    // 获取输入框文本并尝试转换为整数
                    val n = input.text.toIntOrNull()
                    if (n != null) {
                        // 如果转换成功，显示平方结果
                        JOptionPane.showMessageDialog(
                            this@apply,
                            "平方=${n * n}",
                            "计算结果",
                            JOptionPane.INFORMATION_MESSAGE
                        )
                        // 清空输入框并重新获得焦点
                        input.text = ""
                        input.requestFocusInWindow()
                    } else {
                        // 如果转换失败，显示错误提示
                        JOptionPane.showMessageDialog(
                            this@apply,
                            "请输入有效的整数！",
                            "输入错误",
                            JOptionPane.ERROR_MESSAGE
                        )
                        // 选中错误输入以便用户修改
                        input.selectAll()
                        input.requestFocusInWindow()
                    }
                }
            }
            add(ok)

            // 添加回车键监听，使按下回车也能触发计算
            input.addActionListener(ok.actionListeners.first())
        }.also { panel ->
            // 将配置好的面板添加到窗口中
            add(panel)
        }

        // 自动调整窗口大小以适应其子组件
        pack()

        // 设置窗口相对于屏幕居中显示
        setLocationRelativeTo(null)

        // 设置窗口可见性为true，使其显示在屏幕上
        isVisible = true
    }
}