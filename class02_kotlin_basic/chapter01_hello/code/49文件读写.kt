import java.awt.BorderLayout
import java.awt.FlowLayout
import java.awt.Font
import java.awt.Dimension
import java.awt.EventQueue
import java.io.File
import javax.swing.*

/**
 * Kotlin Swing 文件读写应用
 * 创建一个简单的GUI应用程序，用于演示文件的读写操作
 */
fun main() = EventQueue.invokeLater {
    // 创建主窗口并进行配置
    JFrame("文件读写工具").apply {
        // 设置窗口关闭操作：点击关闭按钮时退出应用程序
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        // 声明组件变量，使其在整个作用域内可用
        lateinit var filePathField: JTextField
        lateinit var textArea: JTextArea

        // 创建顶部面板用于放置文件路径输入和浏览按钮
        JPanel().apply {
            layout = FlowLayout(FlowLayout.LEFT, 5, 5)
            border = BorderFactory.createTitledBorder("文件路径")

            // 文件路径输入框
            filePathField = JTextField("data.txt", 20).apply {
                toolTipText = "输入文件路径"
            }
            add(filePathField)

            // 浏览按钮
            val browseButton = JButton("浏览...").apply {
                addActionListener {
                    // 创建文件选择对话框
                    JFileChooser().apply {
                        fileSelectionMode = JFileChooser.FILES_ONLY
                        selectedFile = File(filePathField.text)

                        // 显示打开文件对话框
                        if (showOpenDialog(this@apply) == JFileChooser.APPROVE_OPTION) {
                            filePathField.text = selectedFile.absolutePath
                        }
                    }
                }
            }
            add(browseButton)
        }.also { topPanel ->
            add(topPanel, BorderLayout.NORTH)
        }

        // 创建中部面板用于放置文本编辑区域
        JPanel().apply {
            layout = BorderLayout()
            border = BorderFactory.createTitledBorder("文件内容")

            // 创建文本区域用于编辑文件内容
            textArea = JTextArea().apply {
                // 设置字体，使用等宽字体便于查看和编辑代码或文本文件
                font = Font(Font.MONOSPACED, Font.PLAIN, 14)
                // 设置行包装，使长文本自动换行
                lineWrap = true
                // 在单词边界换行
                wrapStyleWord = true
            }

            // 创建滚动面板包装文本区域，提供滚动功能
            val scrollPane = JScrollPane(textArea).apply {
                verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
                horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
                // 设置首选大小，使文本区域能够更好地显示多行内容
                preferredSize = Dimension(780, 450)
            }
            add(scrollPane, BorderLayout.CENTER)
        }.also { centerPanel ->
            add(centerPanel, BorderLayout.CENTER)
        }

        // 创建底部面板用于放置操作按钮
        JPanel().apply {
            layout = FlowLayout(FlowLayout.CENTER, 10, 5)

            // 读取文件按钮
            val loadButton = JButton("读取文件").apply {
                addActionListener {
                    val filePath = filePathField.text.trim()
                    if (filePath.isNotEmpty()) {
                        try {
                            val file = File(filePath)
                            if (file.exists()) {
                                textArea.text = file.readText()
                                showMessage("文件读取成功: ${file.name}", JOptionPane.INFORMATION_MESSAGE)
                            } else {
                                showMessage("文件不存在: $filePath", JOptionPane.WARNING_MESSAGE)
                            }
                        } catch (e: Exception) {
                            showMessage("读取文件失败: ${e.message}", JOptionPane.ERROR_MESSAGE)
                        }
                    } else {
                        showMessage("请输入文件路径", JOptionPane.WARNING_MESSAGE)
                    }
                }
            }
            add(loadButton)

            // 保存文件按钮
            val saveButton = JButton("保存文件").apply {
                addActionListener {
                    val filePath = filePathField.text.trim()
                    if (filePath.isNotEmpty()) {
                        try {
                            val file = File(filePath)
                            file.writeText(textArea.text)
                            showMessage("文件保存成功: ${file.name}", JOptionPane.INFORMATION_MESSAGE)
                        } catch (e: Exception) {
                            showMessage("保存文件失败: ${e.message}", JOptionPane.ERROR_MESSAGE)
                        }
                    } else {
                        showMessage("请输入文件路径", JOptionPane.WARNING_MESSAGE)
                    }
                }
            }
            add(saveButton)

            // 新建文件按钮
            val newButton = JButton("新建文件").apply {
                addActionListener {
                    textArea.text = ""
                    filePathField.text = ""
                    filePathField.requestFocusInWindow()
                    showMessage("已清空，可以开始编辑新文件", JOptionPane.INFORMATION_MESSAGE)
                }
            }
            add(newButton)
        }.also { bottomPanel ->
            add(bottomPanel, BorderLayout.SOUTH)
        }

        // 设置窗口大小为800x600
        preferredSize = Dimension(800, 600)

        // 自动调整窗口大小以适应其子组件
        pack()

        // 设置最小窗口大小
        minimumSize = Dimension(600, 400)

        // 设置窗口相对于屏幕居中显示
        setLocationRelativeTo(null)

        // 设置窗口可见性为true，使其显示在屏幕上
        isVisible = true
    }
}

/**
 * 显示消息对话框
 *
 * @param message 要显示的消息
 * @param messageType 消息类型 (JOptionPane.INFORMATION_MESSAGE, JOptionPane.ERROR_MESSAGE等)
 */
fun showMessage(message: String, messageType: Int) {
    JOptionPane.showMessageDialog(null, message, "提示", messageType)
}