package demo16;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @ClassName: CustomDialog
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author win10
 * @date 2017年6月22日 上午9:46:40
 */

class CustomDialog extends JDialog implements ActionListener, PropertyChangeListener {
    private String typedText = null;
    private JTextField textField;
    private DialogDemo dd;

    private String magicWord;
    private JOptionPane optionPane;

    private String btnString1 = "确定";
    private String btnString2 = "取消";

    /**
     * <br>
     * 方法说明：返回文本输入字符 <br>
     * 输入参数： <br>
     * 返回类型：
     */
    public String getValidatedText() {
        return typedText;
    }

    /**
     * <br>
     * 方法说明：创建一个结果对话框 <br>
     * 输入参数： <br>
     * 返回类型：
     */
    public CustomDialog(Frame aFrame, String aWord, DialogDemo parent) {
        super(aFrame, true);
        dd = parent;

        magicWord = aWord.toUpperCase();
        setTitle("测试");

        textField = new JTextField(10);

        // 定义显示信息
        String msgString1 = "李先生： jeck是你的英文名字吗？";
        String msgString2 = "(这个答案是： \"" + magicWord + "\"。)";
        Object[] array = { msgString1, msgString2, textField };

        Object[] options = { btnString1, btnString2 };

        // 创建对话框
        optionPane = new JOptionPane(array, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, null, options,
                options[0]);

        // 显示对话框
        setContentPane(optionPane);

        // 设置当关闭窗体动作模式
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {

                optionPane.setValue(new Integer(JOptionPane.CLOSED_OPTION));
            }
        });

        // 使的文本输入域得到焦点
        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent ce) {
                textField.requestFocusInWindow();
            }
        });

        // 给文本域添加监听事件
        textField.addActionListener(this);

        // 监听输入改变
        optionPane.addPropertyChangeListener(this);
    }

    /** 文本域监听处理 */
    public void actionPerformed(ActionEvent e) {
        optionPane.setValue(btnString1);
    }

    /** 监听输入的改变 */
    public void propertyChange(PropertyChangeEvent e) {
        String prop = e.getPropertyName();

        if (isVisible() && (e.getSource() == optionPane)
                && (JOptionPane.VALUE_PROPERTY.equals(prop) || JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))) {
            Object value = optionPane.getValue();

            if (value == JOptionPane.UNINITIALIZED_VALUE) {
                return;
            }

            optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);

            if (btnString1.equals(value)) {
                typedText = textField.getText();
                String ucText = typedText.toUpperCase();
                if (magicWord.equals(ucText)) {
                    // 如果输入有效，则清楚文本域并隐藏对话框
                    clearAndHide();
                } else {
                    // 文本输入无效
                    textField.selectAll();
                    JOptionPane.showMessageDialog(CustomDialog.this,
                            "对不起, \"" + typedText + "\" " + "是无效的输入。\n" + "请重新输入" + magicWord + ".", "再试一次",
                            JOptionPane.ERROR_MESSAGE);
                    typedText = null;
                    textField.requestFocusInWindow();
                }
            } else { // 用户关闭了对话框或点击了“cancel”
                dd.setLabel("好吧！ " + "我们不能影响你的决定输入" + magicWord + "。");
                typedText = null;
                clearAndHide();
            }
        }
    }

    /**
     * <br>
     * 方法说明：清楚文本域并隐藏痘翱蝌 <br>
     * 输入参数： <br>
     * 返回类型：
     */
    public void clearAndHide() {
        textField.setText(null);
        setVisible(false);
    }
}
