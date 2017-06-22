package demo36;

import java.io.File;

/**
 * @ClassName: DirOperator
 * @Description: 目录操作：演示列目录下的文件，和移动一个目录
 * @author win10
 * @date 2017年6月22日 下午4:50:13
 */

public class DirOperator {

    /**
     * @Description: 实现目录列表
     * @param pathName
     * @return
     * @author win10
     */
    public String[] DirList(String pathName) {
        try {
            File path = null;
            String[] fileList;
            // 如果没有指定目录，则列出当前目录
            if (pathName.equals("")) {
                path = new File(".");
            } else {
                path = new File(pathName);
            }
            // 获取目录文件列表
            if (path.isDirectory()) {
                fileList = path.list();
            } else {
                return null;
            }
            return fileList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * @Description: 移动一个目录
     * @param sou
     *            源目录
     * @param obj
     *            新目录
     * @return
     * @author win10
     */
    public boolean DirMove(String sou, String obj) {
        try {
            // 检查源文件是否存在
            boolean sexists = (new File(sou)).isDirectory();
            if (!sexists) {
                return false;
            }
            // 目标不存在，建立一个目录
            boolean oexists = (new File(obj)).isDirectory();
            if (!oexists) {
                new File(obj).mkdirs();
            }
            File file = new File(sou);
            File dir = new File(obj);
            // 移动目录
            boolean flag = file.renameTo(new File(dir, file.getName()));
            if (!flag) {
                System.out.println("copy error!");
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static void main(String[] args) {
        DirOperator d = new DirOperator();
        if (args.length == 0) {
            return;
        } else {
            String cmd = args[0];
            if (cmd.equals("list")) {
                if (args.length != 2)
                    return;
                String[] sTemp = d.DirList(args[1]);
                for (int i = 0; i < sTemp.length; i++)
                    System.out.println(sTemp[i]);
            } else if (cmd.equals("move")) {
                if (args.length != 3)
                    return;
                d.DirMove(args[1], args[2]);
            }

        }
    }

}
