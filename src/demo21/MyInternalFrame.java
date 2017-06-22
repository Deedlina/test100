package demo21;

import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

/**
 * @ClassName: MyInternalFrame
 * @Description: 内部窗体：生成一个内部窗体，提供InternalFrameDemo类使用
 * @author win10
 * @date 2017年6月22日 上午10:12:36
 */

public class MyInternalFrame extends JInternalFrame  {
    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = -3666605168130018854L;
    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;

    public MyInternalFrame() {
        super("文档 #" + (++openFrameCount), true, // 可变尺寸
                true, // 有关闭按钮
                true, // 有最大化按钮
                true);// 最小化按钮

        // 给内部窗体添加一个文本域
        JTextArea j = new JTextArea(5, 20);
        getContentPane().add(j);
        // 设置内部窗体的大小
        setSize(300, 300);

        // 设置内部窗体的显示位置
        setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
    }
}
