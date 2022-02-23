import com.sun.javafx.robot.FXRobotImage;
import com.sun.org.apache.bcel.internal.generic.LUSHR;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) {

        final Main main = new Main();

        main.restoreIpAddresses("0000");

    }

    List<String> res = new ArrayList();

    public List<String> restoreIpAddresses(String s) {

        if(s == null || s.length() == 0) return res;

        dfs(s,0,"",0);

        return res;
    }

    public void dfs(String s,int index,String ans,int dot){

      if(dot == 3 && s.length() - index > 3) return;

      if(index >= s.length()){
          res.add(ans);
          return;
      }






    }

    public boolean isValid(String s,int index ,int count){
        if(index + count >= s.length()) return false;

        if(s.charAt(index) == '0') return false;
        String tmp = "";
        for(int i = index;i < count + index;i++){
            tmp+=s.charAt(i);
        }
        return Integer.parseInt(tmp) > 255 ? false : true;
    }
}



