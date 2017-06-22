package demo13;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * <p>Title: ComboBox下拉域演示</p>
 * <p>Description: 通过选择或这输入一种日期格式来格式化今天的日期</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Filename: ComboBoxDemo.java</p>
 * @author 杜江
 * @version 1.0
 */

public class ComboBoxDemo extends JPanel implements ActionListener {
    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 4733795664230797093L;
    static JFrame frame;
    JLabel result;
    String currentPattern;

    /**
     * <br>
     * 方法说明：构造器。初始化窗体构件 <br>
     * 输入参数： <br>
     * 返回类型：
     */
    public ComboBoxDemo() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        String[] patternExamples = { "dd MMMMM yyyy", "dd.MM.yy", "MM/dd/yy", "yyyy.MM.dd G 'at' hh:mm:ss z",
                "EEE, MMM d, ''yy", "h:mm a", "H:mm:ss:SSS", "K:mm a,z", "yyyy.MMMMM.dd GGG hh:mm aaa" };

        currentPattern = patternExamples[0];

        // 设置一个规范的用户界面
        JLabel patternLabel1 = new JLabel("输入一个字符格式或者");
        JLabel patternLabel2 = new JLabel("从下拉列表中选择一种：");

        JComboBox patternList = new JComboBox(patternExamples);
        patternList.setEditable(true);// 标注这里ComboBox可进行编辑
        patternList.addActionListener(this);

        // 创建一个显示结果用户界面
        JLabel resultLabel = new JLabel("当前 日期/时间", JLabel.LEADING);// 相当于LEFT
        result = new JLabel(" ");
        result.setForeground(Color.black);
        result.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        // 布置构件
        JPanel patternPanel = new JPanel();
        patternPanel.setLayout(new BoxLayout(patternPanel, BoxLayout.PAGE_AXIS));
        patternPanel.add(patternLabel1);
        patternPanel.add(patternLabel2);
        patternList.setAlignmentX(Component.LEFT_ALIGNMENT);
        patternPanel.add(patternList);

        JPanel resultPanel = new JPanel(new GridLayout(0, 1));
        resultPanel.add(resultLabel);
        resultPanel.add(result);

        patternPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        resultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(patternPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(resultPanel);

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        reformat();
    }

    /**
     * <br>
     * 方法说明：事件处理 <br>
     * 输入参数： <br>
     * 返回类型：
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String newSelection = (String) cb.getSelectedItem();
        currentPattern = newSelection;
        reformat();
    }

    /**
     * <br>
     * 方法说明：格式和显示今天的日期 <br>
     * 输入参数： <br>
     * 返回类型：
     */
    public void reformat() {
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(currentPattern);
        try {
            String dateString = formatter.format(today);
            result.setForeground(Color.black);
            result.setText(dateString);
        } catch (IllegalArgumentException iae) {
            result.setForeground(Color.red);
            result.setText("Error: " + iae.getMessage());
        }
    }

    /**
     * <br>
     * 方法说明：主方法 <br>
     * 输入参数： <br>
     * 返回类型：
     */
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);

        // 创建一个窗体
        frame = new JFrame("ComboBoxDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个面版容器
        JComponent newContentPane = new ComboBoxDemo();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        // 显示窗体
        frame.pack();
        frame.setVisible(true);
    }
}