import com.at.bean.TreeNode;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.xml.ws.EndpointReference;
import java.util.*;

class Main {
    public static void main(String[] args) {

//        LRUCache lruCache = new LRUCache(2);
//
//        lruCache.put(1,1);
//        lruCache.put(2,2);
//
//        System.out.println(lruCache.get(1));
//
//        lruCache.put(3,3);
//
//        System.out.println(lruCache.get(2));
//
//        lruCache.put(4,4);
//
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));


        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        System.out.println(lruCache.get(2));

    }




}
