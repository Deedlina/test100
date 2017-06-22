package demo32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * @ClassName: StandardIO
 * @Description: 标准输入输出：接收标准的键盘输入，和输出到屏幕
 * @author win10
 * @date 2017年6月22日 上午10:22:41
 */

public class StandardIO {
    public static void main(String[] args) {
        Vector<String> vTemp = new Vector<>();
        boolean flag = true;
        while (flag) {
            System.out.println("input>>>");
            String sTemp = "";
            // 读取输入，System.in表示接收键盘输入流
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            try {
                // 读取一行输入
                sTemp = stdin.readLine();
            } catch (IOException e) {
                System.out.println("IO error!");
            }
            // 解析输入命令
            String sCMD = "";
            String sContext = "";
            int point = sTemp.indexOf(":");
            if (point == -1) {
                sCMD = sTemp.trim();
            } else {
                sCMD = sTemp.substring(0, point);
                sContext = sTemp.substring(point + 1);
            }
            // 添加数据
            if (sCMD.equalsIgnoreCase("in")) {
                if (sContext.equals("")) {
                    System.err.println("This command format is error!");
                } else {
                    vTemp.addElement(sContext);
                }
            } else if (sCMD.equalsIgnoreCase("out")) {
                // 查看结果
                for (int i = 0; i < vTemp.size(); i++) {
                    System.out.println(i + ":" + vTemp.elementAt(i));
                }
            } else if (sCMD.equalsIgnoreCase("quit")) {
                // 结束
                flag = false;
            } else {
                System.err.println("this command don't run!");
                System.out.print("use:   in:command");
                System.out.print("use:   out");
            }
        }
    }
}
