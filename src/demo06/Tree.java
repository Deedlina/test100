package demo06;

/** 
 * @ClassName: Tree 
 * @Description: 继承类，柳树就是树
 * @author win10 
 * @date 2017年6月21日 上午11:18:40  
 */

public class Tree {
    
    public void root(){
        String sSite = "土壤中";
        String sFunction = "吸收养分";
        print("位置:"+sSite);
        print("功能:"+sFunction);
    }
    
    public void bolo(){
        String sSite = "地面";
        String sFunction = "传递养分";
        print("位置:"+sSite);
        print("功能:"+sFunction);
    }
    
    public void branch(){
        String sSite = "树干上";
        String sFunction = "传递养分";
        print("位置:"+sSite);
        print("功能:"+sFunction);
    }
    
    public void leaf(){
        String sSite = "树梢";
        String sFunction = "光合作用";
        String sColor = "绿色";
        print("位置:"+sSite);
        print("功能:"+sFunction);
        print("颜色:"+sColor);
    }
    
    public void print(Object oPara)
    {
      System.out.println(oPara);
    }
    
    public static void  main(String[] arges)
    {
      Tree t = new Tree();
      t.print("=----描述一棵树----=");
      t.print("=-=-=树根=-=-=");
      t.root();
      t.print("=-=-=树干=-=-=");
      t.bolo();
      t.print("=-=-=树枝=-=-=");
      t.branch();
      t.print("=-=-=树叶=-=-=");
      t.leaf();
    }
}
