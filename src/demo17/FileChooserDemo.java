package demo17;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @ClassName: FileChooserDemo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author win10
 * @date 2017年6月22日 上午9:57:00
 */

public class FileChooserDemo extends JPanel implements ActionListener {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = -1118500893533395941L;
    static private final String newline = "\n";
    JButton openButton, saveButton;
    JTextArea log;
    JFileChooser fc;

    public FileChooserDemo() {
        super(new BorderLayout());

        log = new JTextArea(15, 40);
        log.setMargin(new Insets(10, 10, 10, 10));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        // 创建一个文件过滤，使用当前目录
        fc = new JFileChooser(".");
        // 过滤条件在MyFilter类中定义
        fc.addChoosableFileFilter(new MyFilter());

        openButton = new JButton("打开文件", createImageIcon("images/Open16.gif"));
        openButton.addActionListener(this);

        saveButton = new JButton("保存文件", createImageIcon("images/Save16.gif"));
        saveButton.addActionListener(this);

        // 构建一个面板，添加“打开文件”和“保存文件”
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }

    /**
     * <br>
     * 方法说明：事件处理 <br>
     * 输入参数： <br>
     * 返回类型：
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // 当点击“打开文件”按钮
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(FileChooserDemo.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                // 在这里添加一些对文件的处理
                log.append("打开文件: " + file.getName() + newline);
            } else {
                log.append("打开文件被用户取消！" + newline);
            }

            // 点击“保存文件”按钮
        } else if (e.getSource() == saveButton) {
            int returnVal = fc.showSaveDialog(FileChooserDemo.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                // 在这里添加一些对文件的处理
                log.append("保存文件: " + file.getName() + newline);
            } else {
                log.append("保存文件被用户取消！" + newline);
            }
        }
    }

    /**
     * <br>
     * 方法说明：获取图像对象 <br>
     * 输入参数：String path 图片路径 <br>
     * 返回类型：ImageIcon 图片对象
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = FileChooserDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

        // 创建窗体
        JFrame frame = new JFrame("FileChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个面板
        JComponent newContentPane = new FileChooserDemo();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        // 显示窗体
        frame.pack();
        frame.setVisible(true);
    }

}
