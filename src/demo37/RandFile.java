package demo37;

import java.io.RandomAccessFile;

/**
 * @ClassName: RandFile
 * @Description: 读取随机文件：演示使用RandomAccessFile类读取文件
 * @author win10
 * @date 2017年6月23日 上午10:19:37
 */

public class RandFile {

    public static void main(String[] args) {
        String sFile;
        if (args.length < 1) {
            System.out.println("USE:Java RandFile fileName");
            return;
        } else {
            sFile = args[0];
        }
        // 接收IOException异常
        try {
            // 构造随机访问文件，使用可读写方式
            RandomAccessFile rf = new RandomAccessFile(sFile, "rw");
            for (int i = 0; i < 10; i++) {
                rf.writeDouble(i * 1.414);
            }
            rf.close();
            // 构造一个随机访问文件，使用只读方式
            rf = new RandomAccessFile(sFile, "rw");
            rf.seek(5 * 8);
            rf.writeDouble(47.0001);
            rf.close();
            // 构造一个随机访问文件，使用只读方式
            rf = new RandomAccessFile(sFile, "r");
            for (int i = 0; i < 10; i++) {
                System.out.println("Value" + i + ":" + rf.readDouble());
            }
            rf.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
