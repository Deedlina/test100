package demo10;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @ClassName: MyFrame
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author win10
 * @date 2017年6月22日 上午9:09:02
 */

public class MyFrame extends JFrame{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = -310013546937607423L;

    /**
     * 方法说明：构造器，通过传递参数来完成窗体的绘制。<br>
     * 
     * @param sTitle
     *            窗体标题
     * @param iWidth
     *            窗体的宽度
     * @param iHeight
     *            窗体的高度
     */
    public MyFrame(String sTitle, int iWidth, int iHeight) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();// 获取屏幕尺寸
        ImageIcon ii = new ImageIcon("images/middle.gif");
        setTitle(sTitle);// 设置窗体标题
        setIconImage(ii.getImage());// 设置窗体的图标
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置但关闭窗体时退出程序
        setSize(iWidth, iHeight);// 设置窗体大小
        int w = getSize().width;// 获取窗体宽度
        int h = getSize().height;// 获取窗体高度
        System.out.println("窗体宽：" + w + " 窗体高：" + h);
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        setLocation(x, y);// 将窗体移到屏幕中间
        setVisible(true);// 显示窗体
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);// 使用最新的SWING外观
        MyFrame mF = new MyFrame("main Frame Demo", 400, 300);
    }
}