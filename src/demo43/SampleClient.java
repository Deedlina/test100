package demo43;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * <p>Title: 简单服务器客户端</p>
 * <p>Description: 本程序是一个简单的客户端，用来和服务器连接</p>
 * <p>Filename: SampleClient.java</p>
 * @version 1.0
 */
public class SampleClient {
    public static void main(String[] args) {
        try {
            //获取一个IP，null表示本机
            InetAddress inetAddress = InetAddress.getByName(null);
            //打开8888端口，与服务器建立连接
            Socket sk = new Socket(inetAddress,8888);
            //缓存输入
            BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            //缓存输出
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sk.getOutputStream())),true);
            //向服务器发送信息
            out.println("你好！");
            //接收服务器信息
            System.out.println(in.readLine());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
