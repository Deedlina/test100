package demo41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>Title: 运行系统命令</p>
 * <p>Description:运行一个系统的命令，演示使用Runtime类。</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Filename: CmdExec.java</p>
 * @version 1.0
 */
public class CmdExec {

    public CmdExec(String cmdLine){
        try {
            String line;
            //运行系统命令
            Process process = Runtime.getRuntime().exec(cmdLine);
            //使用缓存输入流获取屏幕输出
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            //读取屏幕输出
            while ((line=input.readLine())!=null){
                System.out.println("***Java print*** : "+line);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CmdExec("myprog.bat");
    }

}
