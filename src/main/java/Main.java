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

        new HashMap<>().containsKey(

        )

        queue.add(3);
        queue.add(0);
        queue.add(50);
        queue.add(-1);
        queue.add(9);

        System.out.println(queue.poll());

        new Main().combinationSum(new int[]{2, 3, 6, 7}, 7);


    }

    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) return new int[]{};

        Map<Integer, Integer> map = new HashMap();

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int t = target - nums[i];
            if (map.containsKey(t)) {
                return new int[]{map.get(t), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};

    }


    List<List<Integer>> res = new ArrayList();
    List<Integer> list = new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) return res;

        dfs(candidates, target, 0, 0);

        return res;

    }


    public void dfs(int[] arr, int target, int curr, int sum) {

        if (curr == arr.length || sum == target) {
            if (sum == target) res.add(new ArrayList(list));
            return;
        }

        dfs(arr, target, curr + 1, sum);

        if (arr[curr] + sum <= target) {
            list.add(arr[curr]);
            dfs(arr, target, curr, sum + arr[curr]);
            list.remove(list.size() - 1);
        }

    }


}
