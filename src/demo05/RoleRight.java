package demo05;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @ClassName: RoleRight
 * @Title: 哈希表操作
 * @Description: 这是一个权限认证的例子，使用了哈希表作为数据的存储
 * @author win10
 * @date 2017年6月20日 下午4:02:28
 */

public class RoleRight {

    private static Hashtable<String, Object> rightList = new Hashtable<>();

    /**
     * @Description: 方法说明：初始化数据
     * @author win10
     */
    public void init() {
        String[] accRoleList = { "admin", "satrap", "manager", "user", "guest" };
        String[] rightCodeList = { "10001", "10011", "10021", "20001", "24011" };
        for (int i = 0; i < accRoleList.length; i++) {
            rightList.put(accRoleList[i], rightCodeList[i]);
        }
    }

    /**
     * @Description: 方法说明：获取角色权限代码
     * @param String
     *            accRole 角色名称
     * @return String 权限代码
     * @author win10
     */
    public String getRight(String accRole) {
        if (rightList.containsKey(accRole)) {
            return (String) rightList.get(accRole);
        } else {
            return null;
        }
    }

    /**
     * @Description: 添加角色和代码信息
     * @param accRole
     *            角色名称
     * @param rightCode
     *            角色权限代码
     * @author win10
     */
    public void insert(String accRole, String rightCode) {
        rightList.put(accRole, rightCode);
    }

    /**
     * @Description: 删除角色权限
     * @param accRole
     *            角色名称
     * @author win10
     */
    public void delete(String accRole) {
        if (rightList.containsKey(accRole)) {
            rightList.remove(accRole);
        }
    }

    /**
     * @Description: 修改角色权限代码
     * @param accRole
     *            角色名称
     * @param rightCode
     *            角色权限代码
     * @author win10
     */
    public void update(String accRole, String rightCode) {
        this.insert(accRole, rightCode);
    }

    /**
     * @Description: 打印哈希表中角色和代码对应表
     * @author win10
     */
    public void print() {
        Enumeration<String> RLKey = rightList.keys();
        while (RLKey.hasMoreElements()) {
            String accRole = RLKey.nextElement().toString();
            print(accRole + "=" + this.getRight(accRole));
        }
    }

    /**
     * @Description: 打印信息（过载）
     * @param oPara
     *            打印的信息内容
     * @author win10
     */
    public void print(Object oPara) {
        System.out.println(oPara);
    }

    /**
     * @Description: 主方法，
     * @param args
     * @author win10
     */
    public static void main(String[] args) {
        RoleRight RR = new RoleRight();
        RR.init();
        RR.print();
        RR.print("___________________________");
        RR.insert("presider", "10110");
        RR.print();
        RR.print("___________________________");
        RR.update("presider", "10100");
        RR.print();
        RR.print("___________________________");
        RR.delete("presider");
        RR.print();
    }

}
