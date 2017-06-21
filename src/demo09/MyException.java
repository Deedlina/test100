package demo09;

/** 
 * @Title 捕获异常和实现自己的异常类
 * @ClassName: MyException 
 * @Description: 通过继承Exception类来实现自己的异常类。并使用try－catch来捕获这个异常。
 * @author win10 
 * @date 2017年6月21日 下午5:01:18  
 */

@SuppressWarnings("serial")
public class MyException extends Exception {
    
    private int i;
    
    /** 
     *   无参构造
     */
    public MyException() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     *   
     * @param msg
     */
    public MyException(String msg) {
        super(msg);
    }
    
    /**
     * @param msg
     * @param x
     */
    public MyException(String msg,int x) {
        super(msg);
        i = x;
    }
    
    public int val(){
        return i;
    }
    
}
