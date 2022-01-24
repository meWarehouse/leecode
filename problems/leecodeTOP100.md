



























15. 三数之和
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


23. 合并K个升序链表
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






















