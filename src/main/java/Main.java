import com.at.bean.TreeNode;
import com.at.lc.ListNode;
import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.misc.LRUCache;

import javax.xml.ws.EndpointReference;
import java.util.*;
import java.util.stream.Collectors;

class Main {


    public static void main(String[] args) {

        ListNode listNode = new ListNode(1, new ListNode(2,new ListNode(3,new ListNode(4))));

        new Main().isPalindrome(listNode);

    }

    public boolean isPalindrome(ListNode head) {

        int len = 0;

        ListNode p = head;

        while (p == null) {
            len += 1;
            p = p.next;
        }

        int half = len / 2;

        p = null;
        ListNode q = head;

        for (int i = 0; i < half; i++) {

            ListNode t = q.next;

            q.next = p;

            p = q;
            q = t;

        }

        if ((len & 1) == 1) q = q.next;

        while (q != null && p != null) {
            if (p.val != q.val) return false;
            p = p.next;
            q = q.next;
        }

        return true;

    }
}