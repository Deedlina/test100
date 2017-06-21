package demo02;

/** 
 * @Title<p>Java语言流程演示</p>
 * @Description<p>演示Java中几种常用的流程控制操作</p>
 * @ClassName: FlowDemo 
 * @author win10 
 * @date 2017年6月20日 上午8:48:49  
 */

public class FlowDemo {
    public static void test(String[] args) {
        int iPara1,iPara2,iEnd;
        if(args.length!=3){
            System.out.println("USE :java flowDome parameter1 parameter2 circle");
            System.out.println("parameter1 : 比较条件1，数字类型");
            System.out.println("parameter2 : 比较条件2，数字类型");
            System.out.println("circle ：循环次数");
            System.out.println("ego:java flowDome 1 2 5");
            return;
        } else {
            iPara1 = Integer.parseInt(args[0]);
            iPara2 = Integer.parseInt(args[1]);
            iEnd = Integer.parseInt(args[2]);
        }
        if(iPara2>iPara1){
            System.out.println("if 条件满足！");
            System.out.println("第2个数比第1个数大！");
        }else{
            System.out.println("if 条件不满足！");
            System.out.println("第2个数比第1个数小！");
        }
        //for循环
        for(int i=0;i<iEnd;i++){
            System.out.println("这是for第"+i+"次循环");
        }
        //while循环
        int i = 0;
        while(i<iEnd){
            System.out.println("这是while第"+i+"次循环");
            i++;
        }
        //do循环
        int j = 0;
        do{
            System.out.println("这是do第"+j+"次循环");
            j++;
        }while(j<iEnd);
    }
    
    public static void main(String[] args){
        String[] arges = {"5","3","7"};
        test(arges);
    }
}
