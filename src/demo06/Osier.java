package demo06;

/**
 * @ClassName: Osier
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author win10
 * @date 2017年6月21日 上午11:23:40
 */

public class Osier extends Tree{
    /**
     * <br>
     * 方法说明：过载树的树叶 <br>
     * 输入参数： <br>
     * 返回类型：
     */
    @Override
    public void leaf() {
        super.leaf();
        String sShape = "长形";
        super.print("形状：" + sShape);
    }

    /**
     * <br>
     * 方法说明：扩展树的花 <br>
     * 输入参数： <br>
     * 返回类型：
     */
    public void flower() {
        print("哈哈，柳树没有花！！");
    }

    /**
     * <br>
     * 方法说明：主方法 <br>
     * 输入参数： <br>
     * 返回类型：
     */
    public static void main(String[] args) {
        Osier o = new Osier();
        o.print("柳树树根：");
        o.root();
        o.print("柳树树干：");
        o.bolo();
        o.print("柳树树枝：");
        o.branch();
        o.print("柳树树叶：");
        o.leaf();
        o.print("柳树花：");
        o.flower();
    }
}
