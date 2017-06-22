package demo17;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/** 
 * @ClassName: MyFilter 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author win10 
 * @date 2017年6月22日 上午9:51:23  
 */

public class MyFilter extends FileFilter {
    
    private String files;

    @Override
    public boolean accept(File f) {
        if(f.isDirectory()){
            return true;
        }
        String extension = getExtension(f);
        if(extension!=null){
            if(extension.equals("Java")){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }


    @Override
    public String getDescription() {
        return "Java";
    }
    
    public static String getExtension(File f){
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf(".");
        if(i>0&&i<s.length()-1){
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

}
