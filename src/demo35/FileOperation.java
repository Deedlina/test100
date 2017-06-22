package demo35;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: FileOperation
 * @Description: 文件操作：演示文件的删除和获取文件的信息
 * @author win10
 * @date 2017年6月22日 下午3:38:59
 */

public class FileOperation {

    /**
     * @Description: 删除文件
     * @param fileName
     *            要删除的文件名
     * @return
     * @author win10
     */
    public boolean deleteFile(String fileName) {
        try {
            boolean flag = (new File(fileName)).delete();
            if (!flag) {
                System.out.println("delete file error");
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * @Description: 获取文件信息
     * @param fileName
     *            文件名
     * @return String[] 文件信息数组
     * @author win10
     */
    public String[] getFileInfo(String fileName) {
        try {
            File file = new File(fileName);
            // 获取文件修改日期（返回的是句）
            long modifiedTime = file.lastModified();
            // 获取文件长度（单位：Bite）
            long fileSize = file.length();
            // 测试文件是否可读
            boolean cr = file.canRead();
            // 测试文件是否可写
            boolean cw = file.canWrite();
            // 测试文件是否隐藏
            boolean ih = file.isHidden();

            String[] sTemp = new String[6];
            sTemp[0] = String.valueOf(fileSize);
            sTemp[1] = getDateString(modifiedTime);
            sTemp[2] = String.valueOf(cr);
            sTemp[3] = String.valueOf(cw);
            sTemp[4] = String.valueOf(ih);
            sTemp[5] = String.valueOf(file.getCanonicalPath());
            return sTemp;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * @Description: 将毫秒数字转换为日期
     * @param mill
     *            毫秒数
     * @return String 字符 格式为：yyyy-mm-dd hh:mm
     * @author win10
     */
    public static String getDateString(long mill) {
        if (mill < 0)
            return "";

        Date date = new Date(mill);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        int year = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH);
        int day = rightNow.get(Calendar.DAY_OF_MONTH);
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        int min = rightNow.get(Calendar.MINUTE);

        return year + "-" + (month < 10 ? "0" + month : "" + month) + "-" + (day < 10 ? "0" + day : "" + day)
                + (hour < 10 ? "0" + hour : "" + hour) + ":" + (min < 10 ? "0" + min : "" + min);
    }

    public static void main(String[] args) {
        try {
            FileOperation fo = new FileOperation();
            if(args.length==0){
                return;
            }else{
                String cmd = args[0];
                if(cmd.equals("del")){
                    boolean bdel = fo.deleteFile(args[1]);
                    System.out.println(bdel);
                }else if(cmd.equals("info")){
                    String[] sTemp = fo.getFileInfo(args[1]);
                    for (int i = 0; i < sTemp.length; i++) {
                        System.out.println(sTemp[i]);
                    }
                }
            }
        } catch (Exception e) {
            return;
        }
    }
}
