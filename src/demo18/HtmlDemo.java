package demo18;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * @ClassName: HtmlDemo
 * @Description: 在swing中使用html语言
 * @Description: 这里演示使用html语言在swing面板上构造显示信息
 * @author win10
 * @date 2017年6月22日 上午10:00:45
 */

public class HtmlDemo extends JPanel implements ActionListener {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 9142158832120792414L;
    JLabel theLabel;
    JTextArea htmlTextArea;

    /**
     * <br>
     * 方法说明：构造器，描述窗体中的成员 <br>
     * 输入参数： <br>
     * 返回类型：
     */
    public HtmlDemo() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        String initialText = "<html>\n" + "颜色和字体测试:\n" + "<ul>\n" + "<li><font color=red>red</font>\n"
                + "<li><font color=blue>blue</font>\n" + "<li><font color=green>green</font>\n"
                + "<li><font size=-2>small</font>\n" + "<li><font size=+2>large</font>\n" + "<li><i>italic</i>\n"
                + "<li><b>bold</b>\n" + "</ul>\n";
        // 定义一个文本框
        htmlTextArea = new JTextArea(10, 20);
        htmlTextArea.setText(initialText);
        JScrollPane scrollPane = new JScrollPane(htmlTextArea);
        // 定义按钮
        JButton changeTheLabel = new JButton("改变显示");
        changeTheLabel.setMnemonic(KeyEvent.VK_C);
        changeTheLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        changeTheLabel.addActionListener(this);
        // 定义标签
        theLabel = new JLabel(initialText) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }

            @Override
            public Dimension getMinimumSize() {
                return new Dimension(200, 200);
            }

            @Override
            public Dimension getMaximumSize() {
                return new Dimension(200, 200);
            }
        };
        // 设置标签的对齐方式
        theLabel.setVerticalAlignment(SwingConstants.CENTER);
        theLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // 构造一个带边框的左边的编辑面板
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        leftPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("编辑HTML，点击按钮显示结果。"),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        leftPanel.add(scrollPane);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        leftPanel.add(changeTheLabel);
        // 构造一个带边框的右边显示的面板
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        rightPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("这里使用标签显示HTML结果"),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        rightPanel.add(theLabel);

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(leftPanel);
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(rightPanel);
    }

    /**
     * <br>
     * 方法说明：事件监听，当用户点击按钮触发 <br>
     * 输入参数： <br>
     * 返回类型：
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        theLabel.setText(htmlTextArea.getText());
    }

    /**
     * <br>
     * 方法说明：主方法 <br>
     * 输入参数： <br>
     * 返回类型：
     */
    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(true);

        // 创建窗体
        JFrame frame = new JFrame("HtmlDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建面板
        JComponent newContentPane = new HtmlDemo();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        // 显示窗体
        frame.pack();
        frame.setVisible(true);
    }

}
