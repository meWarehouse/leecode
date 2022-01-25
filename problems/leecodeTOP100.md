



























### 15. 三数之和
    https://leetcode-cn.com/problems/3sum/
    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    
    注意：答案中不可以包含重复的三元组。
    
     
    
    示例 1：
    
    输入：nums = [-1,0,1,2,-1,-4]
    输出：[[-1,-1,2],[-1,0,1]]
    示例 2：
    
    输入：nums = []
    输出：[]
    示例 3：
    
    输入：nums = [0]
    输出：[]
```java

 public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList();

        if (nums == null || nums.length == 0) return list;

        int len = nums.length;

        Arrays.sort(nums);
        int p = -1;

        for (int i = 0; i < len; i++) {

            if (p != -1 && nums[i] == nums[p]) continue;

            int l = i + 1, r = len - 1;

            while (l < r) {

                int t = nums[i] + nums[l] + nums[r];

                if (t == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    int v = nums[l];
                    while (l < r && v == nums[l]) l++;
                } else if (t < 0) {
                    l++;
                } else {
                    r--;
                }
            }
            p = i;

        }
        
        return list;
    }
```


### 23. 合并K个升序链表
    https://leetcode-cn.com/problems/merge-k-sorted-lists/

    给你一个链表数组，每个链表都已经按升序排列。
    
    请你将所有链表合并到一个升序链表中，返回合并后的链表。
    
     
    
    示例 1：
    输入：lists = [[1,4,5],[1,3,4],[2,6]]
    输出：[1,1,2,3,4,4,5,6]
    解释：链表数组如下：
    [
    1->4->5,
    1->3->4,
    2->6
    ]
    将它们合并到一个有序链表中得到。
    1->1->2->3->4->4->5->6
    
    示例 2：
    输入：lists = []
    输出：[]
    
    示例 3：
    输入：lists = [[]]
    输出：[2
```java
    class Node {
        int val;
        ListNode node;

        public Node(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode n : lists) {
            if (n != null) queue.add(new Node(n.val, n));
        }

        ListNode head = new ListNode();
        ListNode tail = head;

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            tail.next = node.node;
            tail = tail.next;

            if (node.node.next != null) {
                queue.offer(new Node(node.node.next.val, node.node.next));
            }
        }

        return head.next;

    }

```


### 46. 全排列
    https://leetcode-cn.com/problems/permutations/
    给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    
     
    
    示例 1：
    输入：nums = [1,2,3]
    输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    示例 2：
    输入：nums = [0,1]
    输出：[[0,1],[1,0]]

    示例 3：
    输入：nums = [1]
    输出：[[1]]
```java
    List<List<Integer>> res = new ArrayList();
    List<Integer> list = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) return res;

        for (int n : nums) list.add(n);

        dfs(0);

        return res;
    }

    public void dfs(int index) {

        if (index == list.size() - 1) {
            res.add(new ArrayList(list));
            return;
        }
        
        for (int i = index; i < list.size(); i++) {

            Collections.swap(list, index, i);

            dfs(index + 1);

            Collections.swap(list, index, i);

        }
    }

    //========================
        /**
         * 下一个排列
         *    1.从头到尾，找到第一个相邻的顺序对， i i+1 a[i]<a[i+1]
         *      - 如果不存在这样的顺序对。则这个串是递减的，这个串是最大的串，没有下一个排列，reverse 这个串
         *    2.从头到尾，找到下一个下标j 满足 i<j 且 a[i]<a[j], j 至少存在一个（i+1）
         *    3.交换 a[i],a[j]
         *    4.将 a[i+1] 到末尾的这段 reverse 一下
         *
         */
    List<List<Integer>> res = new ArrayList<>();
    
        public List<List<Integer>> permute(int[] nums) {
    
            if (nums == null || nums.length == 0) return res;
    
            Arrays.sort(nums);
    
            do {
                res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            } while (hasNext(nums));
    
            System.out.println(res.size());
    
            res.forEach(s -> s.forEach(t -> System.out.println(t)));
    
            return res;
    
        }
    
        public boolean hasNext(int[] nums) {
    
            int n = nums.length;
    
            int i = n - 2;
    
            while (i >= 0) {
                if (nums[i] < nums[i + 1]) break;
                i--;
            }
    
            if (i == -1) return false;
    
            int j = n - 1;
    
            while (nums[i] >= nums[j]) j--;
    
            swap(nums, i, j);
    
            reverse(nums, i + 1, n - 1);
    
            return true;
        }
    
        public void reverse(int[] arr, int s, int e) {
    
            while (s < e) {
                int t = arr[s];
                arr[s] = arr[e];
                arr[e] = t;
                s++;
                e--;
            }
    
        }
    
        public void swap(int[] arr, int i, int j) {
            if (i != j) {
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
            }
        }
```

### 31. 下一个排列
    https://leetcode-cn.com/problems/next-permutation/
    实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
    
    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    
    必须 原地 修改，只允许使用额外常数空间。
    
     
    
    示例 1：
    输入：nums = [1,2,3]
    输出：[1,3,2]

    示例 2：
    输入：nums = [3,2,1]
    输出：[1,2,3]

    示例 3：
    输入：nums = [1,1,5]
    输出：[1,5,1]

    示例 4：
    输入：nums = [1]
    输出：[1]
```java
public void nextPermutation(int[] nums) {

        if (nums == null || nums.length == 0) return;

        int n = nums.length;

        int i = n - 2;

        while (i >= 0) {
            if (nums[i + 1] > nums[i]) break;
            i--;
        }

        if (i == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        int j = n - 1;

        while (nums[i] >= nums[j]) j--;

        swap(nums, i, j);

        reverse(nums, i + 1, n - 1);
    }


    public void reverse(int[] arr, int s, int e) {
        while (s < e) {
            int t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;
            s++;
            e--;
        }
    }

    public void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
```













