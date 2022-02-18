import com.at.bean.TreeNode;
import com.at.lc.ListNode;
import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.misc.LRUCache;

import javax.xml.ws.EndpointReference;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) {

        char[] b = new char[]{'1','2','3','4'};

        System.out.println(String.valueOf(b,0,2));

        System.out.println(Character.isDigit('0'));

        Codec codec = new Codec();

        TreeNode deserialize = codec.deserialize("11,2,#,#,3,4,#,#,5,#,#");

        System.out.println(deserialize);

    }



}


