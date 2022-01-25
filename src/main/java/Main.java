import com.at.bean.ListNode;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @create 2022/1/17 8:54
 */
public class Main {

    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        String[] s = new String[8];

        List<String> list = Arrays.asList(s);

        Integer i[] = new Integer[3];
        List<Integer> integers = Arrays.asList(i);

        int[] a = new int[3];
        List<int[]> ints = Arrays.asList(a);


        queue.add(3);
        queue.add(0);
        queue.add(50);
        queue.add(-1);
        queue.add(9);

        System.out.println(queue.poll());

        new Main().nextPermutation(new int[]{1, 5, 1});

        Arrays.stream(args).filter(t -> t.equals(1)).collect(Collectors.toMap(t -> t, t -> t));


    }




}
