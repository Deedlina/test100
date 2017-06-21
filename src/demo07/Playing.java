package demo07;

/** 
 * @ClassName: Playing 
 * @Description: 抽象类
 * @author win10 
 * @date 2017年6月21日 上午11:40:22  
 */

public abstract class Playing {
    public void display(Object oPara){
        System.out.println(oPara);
    }
    abstract void winRun();
}
