package demo42;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p>Title: 获取本机名称和IP地址</p>
 * <p>Description: 使用InetAddress来获取本机名称和IP地址信息</p>
 * <p>Filename: NetInfo.java</p>
 * @version 1.0
 */
public class NetInfo {

    public static void main(String[] args) {
        new NetInfo().say();
    }

    public void say(){
        try {
            InetAddress i = InetAddress.getLocalHost();
            System.out.println(i);
            System.out.println(i.getHostName());
            System.out.println(i.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
