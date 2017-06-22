package demo33;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/** 
 * @ClassName: CopyBytes 
 * @Description: 读取和写入文件：使用字节流方式操作文件，读取和写入文件
 * @author win10 
 * @date 2017年6月22日 上午10:40:54  
 */

public class CopyBytes {
    /**
     * @Description: main方法 
     * @param args 
     * @author win10
     */
    public static void main(String[] args) {
        String sFile;
        String oFile;
        if(args.length<2){
            System.out.println("USE: Java CopyBytes source file | Object file");
            return;
        }else{
            sFile = args[0];
            oFile = args[1];
        }
        try {
            /*
             * sFile和oFile为文件的路径，可以是相对路径也可以是绝对路径
             */
            File inputFile = new File(sFile);//定义读取源文件
            File outputFile = new File(oFile);//定义拷贝目标文件
            //定义输入文件流
            FileInputStream in = new FileInputStream(inputFile);
            //将文件输入流构造到缓存
            BufferedInputStream bin = new BufferedInputStream(in);
            //定义输出文件流
            FileOutputStream out = new FileOutputStream(outputFile);
            //将输出文件流构造到缓存
            BufferedOutputStream bout = new BufferedOutputStream(out);
            int c;
            //循环读取文件和写入文件
            while((c=bin.read())!=-1){
                bout.write(c);
            }
            //关闭输入输出流，释放资源
            bin.close();
            bout.close();
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
