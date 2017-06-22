package demo34;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @ClassName: CopyChar
 * @Description: 文件的读取和写入（字符）:使用FileReader和FileWriter类，采用字符文件访问方式操作文件
 * @author win10
 * @date 2017年6月22日 下午2:49:59
 */

public class CopyChar {

    public static void main(String[] args) {
        String sFile;
        String oFile;
        if (args.length < 2) {
            System.out.println("USE: Java CopyBytes source file | Object file");
            return;
        } else {
            sFile = args[0];
            oFile = args[1];
        }
        try {
            File inputFile = new File(sFile);
            File outputFile = new File(oFile);
            // 定义输入文件流
            FileReader in = new FileReader(inputFile);
            // 讲文件输入流构造到缓存
            BufferedReader bin = new BufferedReader(in);
            // 将输出文件流构造到缓存
            FileWriter out = new FileWriter(outputFile);
            // 将输出文件流构造到缓存
            BufferedWriter bout = new BufferedWriter(out);
            int c;
            while ((c = bin.read()) != -1) {
                bout.write(c);
                bin.close();
                bout.close();
            }
        } catch (Exception e) {
            // 文件操作，捕获IO异常。
            System.err.println(e);
        }
    }

}
