package demo09;

/**
 * @ClassName: DemoException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author win10
 * @date 2017年6月21日 下午5:07:07
 */

public class DemoException {

    /**
     * @Description: 使用MyException类中默认的构造器
     * @throws MyException
     * @author win10
     */
    public static void a() throws MyException {
        System.out.println("Throwing MyException from a()");
        throw new MyException();
    }

    /**
     * @Description: 使用MyException类中带信息的构造器
     * @throws MyException
     * @author win10
     */
    public static void b() throws MyException {
        System.out.println("Throwing MyException from b()");
        throw new MyException("Originated in b()");
    }

    /**
     * @Description: 使用了MyException中有编码的构造器
     * @throws MyException
     * @author win10
     */
    public static void c() throws MyException {
        System.out.println("Throwing MyException from c()");
        throw new MyException("Originated in c()", 38);
    }

    public static void main(String[] args) {
        try {
            a();
        } catch (MyException e) {
            e.getMessage();
        }
        try {
            b();
        } catch (MyException e) {
            e.toString();
        }
        try {
            c();
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println("error code: " + e.val());
        }
    }

}
