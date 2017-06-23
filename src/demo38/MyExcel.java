package demo38;

import java.io.File;
import java.util.Date;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * @ClassName: MyExcel
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author win10
 * @date 2017年6月23日 下午2:03:34
 */

public class MyExcel {
    
    Workbook workbook;
    Sheet sheet;

    /**
     * @Description: 写入文件操作
     * @author win10
     */
    public void write() {
        try {
            //创建一个可写入的excel文件对象
            WritableWorkbook workbook = Workbook.createWorkbook(new File("/com.um.demo/src/demo38/myfile.xlsx"));
            //使用第一张工作表，将其命名为“午餐记录”
            WritableSheet sheet = workbook.createSheet("午餐记录", 0);
            //表头
            Label lable0 = new Label(0,0,"时间");
            sheet.addCell(lable0);
            
            Label lable1 = new Label(1,0,"姓名");
            sheet.addCell(lable1);
            
            Label lable2 = new Label(2,0,"午餐标准");
            sheet.addCell(lable2);
            
            Label lable3 = new Label(3,0,"实际费用");
            sheet.addCell(lable3);
            //格式化日期
            DateFormat df = new DateFormat("yyyy-dd-mm hh:mm:ss");
            WritableCellFormat wcfDF = new WritableCellFormat(df);
            DateTime labelDTF = new DateTime(0,1,new Date(),wcfDF);
            sheet.addCell(labelDTF);
            //普通字符
            Label labelCFC = new Label(1, 1, "riverwind");
            sheet.addCell(labelCFC);
            //格式化数字
            NumberFormat nf = new NumberFormat("#.##");
            WritableCellFormat wcfN = new WritableCellFormat(nf);
            Number labelNF = new Number(2, 1, 13.1215926, wcfN);
            sheet.addCell(labelNF);
            Number labelNNF = new Number(3,1,10.50001,wcfN);
            sheet.addCell(labelNNF);
            //关闭对象，释放资源
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /**
     * @Description: 读取Excel文件一行数据
     * @param row
     * @return 
     * @author win10
     */
    public String[] readLine(int row){
        try {
            int column = sheet.getColumns();
            String[] rest = new String[column];
            for (int i = 0; i < column; i++) {
                String sTemp = read(i,row);
                if(null!=sTemp){
                    rest[i] = sTemp;
                }
            }
            return rest;
        } catch (Exception e) {
            System.out.println("readLine err:"+e);
            workbook.close();
            return null;
        }
    }
    
    /**
     * @Description: 读取Excel的指定单元数据
     * @param col
     * @param row
     * @return 
     * @author win10
     */
    public String read(int col,int row){
        try {
            Cell c = sheet.getCell(col, row);
            String rest = c.getContents();
            return rest;
        } catch (Exception e) {
            System.out.println("read err:"+e);
            workbook.close();
            return null;
        }
    }
    
    /**
     * @Description: 主方法
     * @param args 
     * @author win10
     */
    public static void main(String[] args) {
        try {
            MyExcel me = new MyExcel();
            //生成一个可读取的Excel文件对象
            me.workbook = Workbook.getWorkbook(new File("/com.um.demo/src/demo38/myfile.xlsx"));
            //使用第一个工作表
            me.sheet = me.workbook.getSheet(0);
            //读取一行记录，并显示出来
            String[] ssTemp = me.readLine(1);
            for (int i = 0; i < ssTemp.length; i++) {
                System.out.println(ssTemp[i]);
            }
            me.write();
            me.workbook.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
