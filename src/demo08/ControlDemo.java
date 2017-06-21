package demo08;

/** 
 * @ClassName: ControlDemo 
 * @Description: 演示标识符对类的访问控制
 * @author win10 
 * @date 2017年6月21日 下午4:58:14  
 */

public class ControlDemo {
    
    
    public void method1(){
        System.out.println("这是一个公有的方法！任何类都可以访问。");
    }
    
    protected void method2(){
        System.out.println("这是一个受到保护的方法！只有子类可以访问。");
    }
    
    private void method3(){
        System.out.println("这是一个私有的方法！只有类本身才可以访问。");
    }
    
    public static void main(String[] args) {
        ControlDemo d = new ControlDemo();
        d.method1();
        d.method2();
        d.method3();

    }
}
