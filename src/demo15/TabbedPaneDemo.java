package demo15;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/** 
 * @ClassName: TabbedPaneDemo 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author win10 
 * @date 2017年6月22日 上午9:45:24  
 */

public class TabbedPaneDemo extends JPanel {
    public TabbedPaneDemo() {
        super(new GridLayout(1, 1));

        ImageIcon icon = createImageIcon("images/middle.gif");
        JTabbedPane tabbedPane = new JTabbedPane();

        Component panel1 = makeTextPanel("#第一个卡片#");
        tabbedPane.addTab("One", icon, panel1,
                          "第一个卡片提示信息！");
        tabbedPane.setSelectedIndex(0);

        Component panel2 = makeTextPanel("##第二个卡片##");
        tabbedPane.addTab("Two", icon, panel2,
                          "第二个卡片提示信息！");

        Component panel3 = makeTextPanel("###第三个卡片###");
        tabbedPane.addTab("Three", icon, panel3,
                          "第三个卡片提示信息！");

        Component panel4 = makeTextPanel("####第四个卡片####");
        tabbedPane.addTab("Four", icon, panel4,
                          "第四个卡片提示信息！");

        //将选项卡添加到panl中
        add(tabbedPane);
    }
/**
 *<br>方法说明：添加信息到选项卡中
 *<br>输入参数：String text 显示的信息内容
 *<br>返回类型：Component 成员对象
 */
    protected Component makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
/**
 *<br>方法说明：获得图片
 *<br>输入参数：String path 图片的路径
 *<br>返回类型：ImageIcon 图片对象
 */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = TabbedPaneDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static void main(String[] args) {
        //使用Swing窗体描述
        JFrame.setDefaultLookAndFeelDecorated(true);

        //创建窗体
        JFrame frame = new JFrame("TabbedPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TabbedPaneDemo(),
                                 BorderLayout.CENTER);

        //显示窗体
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
