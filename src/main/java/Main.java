import com.at.bean.TreeNode;
import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.misc.LRUCache;

import javax.xml.ws.EndpointReference;
import java.util.*;
import java.util.stream.Collectors;

class Main {


    Map<Integer,Boolean> map = new HashMap();

    public boolean wordBreak(String s, List<String> wordDict) {

        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return true;

        return dfs(s,wordDict,0);


    }

    public boolean dfs(String s, List<String> wordDict,int index){

        if(index >= s.length()) return true;
        if(map.containsKey(index)) return map.get(index);


        for(int i = 0;i < wordDict.size();i++){
            String w = wordDict.get(i);
            if(index+w.length() > s.length()) continue;
            String ss = s.subtring(index,index+w.length());

            if(w.equals(ss)){
                map.put(index,dfs(s,wordDict,index+w.length()));
                if(map.get(index)) return true;
            }

        }

        return false;

    }


}

