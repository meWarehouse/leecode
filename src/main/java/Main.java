import com.at.bean.TreeNode;
import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.misc.LRUCache;

import javax.xml.ws.EndpointReference;
import java.util.*;
import java.util.stream.Collectors;

class Main {


    public static void main(String[] args) {

        int state = 0;

        state|=1;
//        System.out.println(state|1);
        System.out.println(state|2);
        System.out.println(state|2);
        System.out.println(state|2);
        System.out.println(state|100);

    }

    public int findKthLargest(int[] nums, int k) {

        int len = nums.length;

        PriorityQueue<Integer> queue = new PriorityQueue(k, ((o1, o2) -> (int) o1 - (int) o2));

        for (int n : nums) {

            if (queue.size() < k) {
                queue.add(n);
            } else {
                if (n > queue.peek()) {
                    queue.poll();
                    queue.add(n);
                }
            }

        }

        return queue.peek();

    }


}