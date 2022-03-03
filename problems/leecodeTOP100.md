



### [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)
    给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
    
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    
    你可以按任意顺序返回答案。

    示例 1：
    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    
    示例 2：
    输入：nums = [3,2,4], target = 6
    输出：[1,2]
    
    示例 3：
    输入：nums = [3,3], target = 6
    输出：[0,1]
```java
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
```

### [2. 两数相加](https://leetcode-cn.com/problems/add-two-numbers/)
    给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
    
    请你将两个数相加，并以相同形式返回一个表示和的链表。
    
    你可以假设除了数字 0 之外，这两个数都不会以 0开头。

    示例 1：
    输入：l1 = [2,4,3], l2 = [5,6,4]
    输出：[7,0,8]
    解释：342 + 465 = 807.
    
    示例 2：
    输入：l1 = [0], l2 = [0]
    输出：[0]
    示例 3：
    
    输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    输出：[8,9,9,9,0,0,0,1]

```java
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode curr = head;

        int t = 0;

        while (l1 != null || l2 != null){

            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int val = t + v1 + v2;

            t = val / 10;

            curr.next = new ListNode(val % 10);
            curr = curr.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

        }

        if(t != 0) curr.next = new ListNode(t);

        return head.next;

    }
```

### [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)
    给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。

    示例1:
    输入: s = "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    
    示例 2:
    输入: s = "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    
    示例 3:
    输入: s = "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
    
    示例 4:
    输入: s = ""
    输出: 0
```java
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) return 0;

        int max = 0, index = -1, L = 0, len = s.length();

        Set<Character> set = new HashSet<>();

        while (++index < len) {

            char c = s.charAt(index);

            while (set.contains(c)) {
                max = Math.max(max, set.size());
                set.remove(s.charAt(L++));
            }

            set.add(c);

        }

        return max > set.size() ? max : set.size();

    }
```

### [4. 寻找两个正序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)
    给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
    
    算法的时间复杂度应该为 O(log (m+n)) 。

    示例 1：
    输入：nums1 = [1,3], nums2 = [2]
    输出：2.00000
    解释：合并数组 = [1,2,3] ，中位数 2
    
    示例 2：
    输入：nums1 = [1,2], nums2 = [3,4]
    输出：2.50000
    解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
    
    示例 3：
    输入：nums1 = [0,0], nums2 = [0,0]
    输出：0.00000
    
    示例 4：
    输入：nums1 = [], nums2 = [1]
    输出：1.00000
    

    示例 5：
    输入：nums1 = [2], nums2 = []
    输出：2.00000
```java
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int th1 = nums1.length;
        int th2 = nums2.length;

        int a = (th1 + th1 + 1) / 2, b = (th1 + th2 + 2) / 2;
        
        int v1 = findK(nums1, 0, nums2, 0, a);
        int v2 = findk(nums1, 0, nums2, 0, b);

        return (v1 + v2) / 2.0;

    }

    private int findK(int[] nums1, int s1, int[] nums2, int s2, int k) {

        if (s1 >= nums1.length) return nums2[s2 - 1 + k];
        if (s2 >= nums2.length) return nums1[s1 - 1 + k];

        if (k == 1) return Math.min(nums1[s1], nums2[s2]);


        int minVal_1 = s1 + k / 2 - 1 < nums1.length ? nums1[s1 + k / 2 - 1] : Integer.MAX_VALUE;
        int minVal_2 = s2 + k / 2 - 1 < nums2.length ? nums2[s2 + k / 2 - 1] : Integer.MAX_VALUE;

        if (minVal_1 < minVal_2) {
            return findK(nums1, s1 + k / 2, nums2, s2, k - k / 2);
        } else {
            return findK(nums1, s1, nums2, s2 + k / 2, k - k / 2);
        }

    }
```

### [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)
    给你一个字符串 s，找到 s 中最长的回文子串。
    
    示例 1：
    输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。
    
    示例 2：
    输入：s = "cbbd"
    输出："bb"
    
    示例 3：
    输入：s = "a"
    输出："a"
    
    示例 4：
    输入：s = "ac"
    输出："a"
```java
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) return "";

        int len = s.length();
        String res = s.substring(0, 1);
        boolean flag = false;

        if (len < 2) return res;

        for (int i = 0; i < len; ) {

            if (len - i <= res.length() / 2) break;

            int l = i, r = i;
            flag = false;
            while (r + 1 < len && s.charAt(i) == s.charAt(r + 1)) {
                r++;
                flag = true;
            }
            i = r + 1;
            while (l > 0 && r + 1 < len && s.charAt(l - 1) == s.charAt(r + 1)) {
                l--;
                r++;
                flag = true;
            }

            if (flag && res.length() < r - l + 1) {
                res = s.substring(l, r + 1);
            }

        }


        return res;
    }

```

### [6. Z 字形变换](https://leetcode-cn.com/problems/zigzag-conversion/)
    将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
    比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
    
    P   A   H   N
    A P L S I I G
    Y   I   R
    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
    
    请你实现这个将字符串进行指定行数变换的函数：
    string convert(string s, int numRows);
    
    示例 1：
    输入：s = "PAYPALISHIRING", numRows = 3
    输出："PAHNAPLSIIGYIR"
    
    示例 2：
    输入：s = "PAYPALISHIRING", numRows = 4
    输出："PINALSIGYAHRPI"
    解释：
    P     I    N
    A   L S  I G
    Y A   H R
    P     I
    
    示例 3：
    输入：s = "A", numRows = 1
    输出："A"
```java
    public String convert(String s, int numRows) {
        
        //https://leetcode-cn.com/problems/zigzag-conversion/solution/zzi-xing-bian-huan-by-jyd/

        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();


    }
```



### [9. 回文数](https://leetcode-cn.com/problems/palindrome-number/)
    给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
    

    示例 1：
    输入：x = 121
    输出：true
    
    示例2：
    输入：x = -121
    输出：false
    解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
    
    示例 3：
    输入：x = 10
    输出：false
    解释：从右向左读, 为 01 。因此它不是一个回文数。
    
    示例 4：
    输入：x = -101
    输出：false
```java
    public boolean isPalindrome(int x) {

        if(x < 0) return false;

        if(x < 10) return true;

        String str = String.valueOf(x);
        int len = str.length();

        int s = 0,e =len -1;

        while(s < e){
            if(str.charAt(s++) != str.charAt(e--)) return false;
        }

        return true;
    }
```

### [15. 三数之和](https://leetcode-cn.com/problems/3sum/)
    给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    
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

### [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)
    给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
        
    示例 1：
    输入：digits = "23"
    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
    
    示例 2：
    输入：digits = ""
    输出：[]
    
    示例 3：
    输入：digits = "2"
    输出：["a","b","c"]



```java
    final List<String> list = Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
    List<String> res = new ArrayList();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) return res;

        dfs(digits, 0, "");

        return res;

    }


    public void dfs(String digits, int index, String resStr) {

        if (index >= digits.length()) {
            if (resStr == null) return;
            res.add(resStr);
            return;
        }

        int j = digits.charAt(index) - '0' - 2;
        String s = list.get(j);


        for (int i = 0; i < s.length(); i++) {

            dfs(digits, index + 1, resStr + s.charAt(i));

        }

    }
```


### [23. 合并K个升序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)
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
        输出：[2]

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


### [46. 全排列](https://leetcode-cn.com/problems/permutations/)
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

### [31. 下一个排列](https://leetcode-cn.com/problems/next-permutation/)
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


### [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    如果数组中不存在目标值 target，返回[-1, -1]。
    
    进阶：
    你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
    
    示例 1：
    输入：nums = [5,7,7,8,8,10], target = 8
    输出：[3,4]
    
    示例2：
    输入：nums = [5,7,7,8,8,10], target = 6
    输出：[-1,-1]
    
    示例 3：
    输入：nums = [], target = 0
    输出：[-1,-1]

```java
    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length < 1) return new int[]{-1, -1};

        int leftIndex = binaryLeft(nums, target); // 第一次出现
        int rightIndex = binaryRight(nums, target); //最后一次出现


        return new int[]{leftIndex, rightIndex};


    }

    public int binaryRight(int[] nums, int target) {

        int left = 0, right = nums.length - 1, ans = -1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] <= target) { // ... 8,mid,8,8,8 -> target=8
                ans = mid;
                left = mid + 1;
            } else { // nums[mid] > target
                right = mid - 1;
            }
        }
        if (ans == -1 || nums[ans] != target) return -1;

        return ans;

    }

    public int binaryLeft(int[] nums, int target) {

        int left = 0, right = nums.length - 1, ans = -1;

        while (left <= right) {

            int mid = (left + right) >> 1;

            if (nums[mid] < target) {
                left = mid + 1;
            } else { // num[mid] >= target   ...8,mid,8,8,8 -> target=8
                ans = mid;
                right = mid - 1;
            }
        }

        if (ans == -1 || nums[ans] != target) return -1;

        return ans;

    }

```


### [39. 组合总和](https://leetcode-cn.com/problems/combination-sum/)
    给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
    
    candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
    
    对于给定的输入，保证和为target 的不同组合数少于 150 个。

    示例1：
    输入：candidates = [2,3,6,7], target = 7
    输出：[[2,2,3],[7]]
    解释：
    2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
    7 也是一个候选， 7 = 7 。
    仅有这两种组合。
    
    示例2：
    输入: candidates = [2,3,5], target = 8
    输出: [[2,2,2,2],[2,3,3],[3,5]]
    
    示例 3：
    输入: candidates = [2], target = 1
    输出: []

```java
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
```


### [48. 旋转图像](https://leetcode-cn.com/problems/rotate-image/)
    给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
    
    你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
    
    示例 1：
    输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    输出：[[7,4,1],[8,5,2],[9,6,3]]
    
    示例 2：
    输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
    输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]


```java
    public void rotate(int[][] matrix) {

        if (matrix == null || matrix.length == 0) return;

        int n = matrix.length;

        for (int x = 0; x < n / 2; x++) {
            for (int y = 0; y < (n + 1) / 2; y++) {

                int tmp = matrix[x][y];

                matrix[x][y] = matrix[n - 1 - y][x];
                matrix[n - 1 - y][x] = matrix[n - 1 - x][n - 1 - y];
                matrix[n - 1 - x][n - 1 - y] = matrix[y][n - 1 - x];
                matrix[y][n - 1 - x] = tmp;

            }
        }

    }
```

### [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)
    给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
    
    字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
    
    示例 1:
    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    
    示例 2:
    输入: strs = [""]
    输出: [[""]]
    
    示例 3:
    输入: strs = ["a"]
    输出: [["a"]]


```java
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();

        if (strs == null || strs.length == 0) return res;

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(str);
            map.put(key, orDefault);

        }

        return new ArrayList<>(map.values());

    }
```








### [53. 最大子数组和](https://leetcode-cn.com/problems/maximum-subarray/)
    给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    
    子数组 是数组中的一个连续部分。
    
    示例 1：
    输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    输出：6
    解释：连续子数组[4,-1,2,1] 的和最大，为6 。
    
    示例 2：
    输入：nums = [1]
    输出：1
    
    示例 3：
    输入：nums = [5,4,-1,7,8]
    输出：23
```java
    public int maxSubArray(int[] nums) {
        
        int sum = 0,res = Integer.MIN_VALUE,len = nums.length;

        for (int i = 0; i < len; i++) {
            
            sum = sum + nums[i];
            
            res = Math.max(res,sum);
            
            if(sum <= 0) sum = 0;
            
        }
        
        return res;
        
    }
```



### [55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)
    给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
    
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    
    判断你是否能够到达最后一个下标。
    
    示例1：
    输入：nums = [2,3,1,1,4]
    输出：true
    解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
    
    示例2：
    输入：nums = [3,2,1,0,4]
    输出：false
    解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

```java
    public boolean canJump(int[] nums) {

        int len = nums.length;
        int l = 0, r = 0;

        while (r < len - 1) {

        int upBound = l + nums[l];
        r = Math.max(upBound, r);

        if (l == r) break;

        l++;

        }

        return r >= len - 1;

        }
```

### [56. 合并区间](https://leetcode-cn.com/problems/merge-intervals/)
    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

    示例 1：
    输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    输出：[[1,6],[8,10],[15,18]]
    解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    
    示例2：
    
    输入：intervals = [[1,4],[4,5]]
    输出：[[1,5]]
    解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

```java
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) return new int[0][2];

        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));

        int L = intervals[0][0], R = intervals[0][1];

        List<int[]> res = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] > R) {
                res.add(new int[]{L, R});
                L = intervals[i][0];
                R = intervals[i][1];
            } else {
                R = Math.max(R, intervals[i][1]);
            }

        }

        res.add(new int[]{L, R});

        return res.toArray(new int[res.size()][]);

    }
```


### [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)
    一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
    
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    
    问总共有多少条不同的路径？
    
    示例 1：
    输入：m = 3, n = 7
    输出：28
    
    示例 2：
    输入：m = 3, n = 2
    输出：3
    解释：
    从左上角开始，总共有 3 条路径可以到达右下角。
    1. 向右 -> 向下 -> 向下
    2. 向下 -> 向下 -> 向右
    3. 向下 -> 向右 -> 向下 
       
    示例 3：
    输入：m = 7, n = 3
    输出：28
    
    示例 4：
    输入：m = 3, n = 3
    输出：6
```java
    public int uniquePaths(int m, int n) {

//        int[][] dp = new int[m][n];
//        dp[0][0] = 1;
//
//        for (int i = 1; i < m; i++) {
//            dp[i][0] = dp[i-1][0];
//        }
//
//        for (int i = 1; i < n; i++) {
//            dp[0][i] = dp[0][i-1];
//        }
//
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//
//                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//
//            }
//        }
//
//        return dp[m][n];


        int[] dp = new int[n];

        for (int i = 0; i < n; i++) dp[i] = 1;

        for (int i = 1; i < m; i++) {
            dp[0] = dp[0];
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];

    }
```

### [64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)
    给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    
    说明：每次只能向下或者向右移动一步。
    
    示例 1：
    输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
    输出：7
    解释：因为路径 1→3→1→1→1 的总和最小。
    
    示例 2：
    输入：grid = [[1,2,3],[4,5,6]]
    输出：12

```java
    public int minPathSum(int[][] grid) {

//        int m = grid.length, n = grid[0].length;
//
//        for (int i = 1; i < m; i++) {
//            grid[i][0] = grid[i][0] + grid[i - 1][0];
//        }
//
//        for (int i = 1; i < n; i++) {
//            grid[0][i] = grid[0][i] + grid[0][i - 1];
//        }
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
//            }
//        }
//
//        return grid[m - 1][n - 1];

        int m = grid.length, n = grid[0].length;

        int[] dp = new int[n];

        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = grid[0][i] + dp[i - 1];
        }

        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }

        return dp[n - 1];

    }


```



### [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
    假设你正在爬楼梯。需要 n阶你才能到达楼顶。
    
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    
    示例 1：
    输入：n = 2
    输出：2
    解释：有两种方法可以爬到楼顶。
    1. 1 阶 + 1 阶
    2. 2 阶 
       
    示例 2：
    输入：n = 3
    输出：3
    解释：有三种方法可以爬到楼顶。
    1. 1 阶 + 1 阶 + 1 阶
    2. 1 阶 + 2 阶
    3. 2 阶 + 1 阶
```java
    public int climbStairs(int n) {

        if (n <= 3) return n;

//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 2;
//
//        for (int i = 3; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//
//        return dp[n]

        int pre = 2, preP = 1;

        for (int i = 3; i <= n; i++) {
            pre = pre + preP;
            preP = pre - preP;
        }

        return pre;

    }
```


### [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/)
    给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
    
    你可以对一个单词进行如下三种操作：
    
    插入一个字符
    删除一个字符
    替换一个字符

    示例1：
    输入：word1 = "horse", word2 = "ros"
    输出：3
    解释：
    horse -> rorse (将 'h' 替换为 'r')
    rorse -> rose (删除 'r')
    rose -> ros (删除 'e')
    
    示例2：
    输入：word1 = "intention", word2 = "execution"
    输出：5
    解释：
    intention -> inention (删除 't')
    inention -> enention (将 'i' 替换为 'e')
    enention -> exention (将 'n' 替换为 'x')
    exention -> exection (将 'n' 替换为 'c')
    exection -> execution (插入 'u')
```java
    public int minDistance(String word1, String word2) {

        if (word1 == null && word2 == null) return 0;
        if (word1 == null && word2 != null) return word2.length();
        if (word1 != null && word2 == null) return word1.length();


        int m = word1.length(), n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int i = 0; i <= n; i++) dp[0][i] = i;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }

            }
        }
        
        return dp[m][n];

    }
```


### [75. 颜色分类](https://leetcode-cn.com/problems/sort-colors/)
    给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    
    我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
    
    必须在不使用库的sort函数的情况下解决这个问题。


    示例 1：
    输入：nums = [2,0,2,1,1,0]
    输出：[0,0,1,1,2,2]
    
    示例 2：
    输入：nums = [2,0,1]
    输出：[0,1,2]

```java
    public void sortColors(int[] nums) {

        if (nums == null || nums.length == 0) return;

        int len = nums.length;
        int L = 0, R = len - 1, i = 0;

        while (i <= R) {

            if (nums[i] == 2) {
                while (R < i && nums[R] == 2) R--;

                if (R == i) break;

                swap(nums, i, R);
                R--;

            } else if (nums[i] == 0) {

                swap(nums, L, i);
                L++;
                i++;

            } else if (nums[i] == 1) {
                i++;
            }
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

### 76. [最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)
    https://leetcode-cn.com/problems/minimum-window-substring/
    给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    
    注意：
    对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
    如果 s 中存在这样的子串，我们保证它是唯一的答案。
    
    示例 1：
    输入：s = "ADOBECODEBANC", t = "ABC"
    输出："BANC"
    
    示例 2：
    输入：s = "a", t = "a"
    输出："a"
    
    示例 3:
    输入: s = "a", t = "aa"
    输出: ""
    解释: t 中两个字符 'a' 均应包含在 s 的子串中，
    因此没有符合条件的子字符串，返回空字符串。
```java
    public String minWindow(String s, String t) {

        if (s == null || s.length() == 0) return "";
        if (t == null || t.length() == 0) return "";

        int sLen = s.length(), tLen = t.length();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int ctn = tLen;

        int I = 0, J = sLen + 1, L = 0, R = 0;

        while (R < sLen) {

            char c = s.charAt(R);

            if (map.getOrDefault(c, 0) > 0) ctn--;
            map.put(c, map.getOrDefault(c, 0) - 1);


            if (ctn == 0) {

                while (L <= R && map.get(s.charAt(L)) != 0) {
                    map.put(s.charAt(L), map.get(s.charAt(L)) + 1);
                    L++;
                }

                if (J - I > R - L) {
                    J = R;
                    I = L;
                }

                map.put(s.charAt(L), map.get(s.charAt(L)) + 1);
                L++;
                ctn++;

            }

            R++;

        }

        return J - I > sLen ? "" : s.substring(I, J + 1);

    }
```


### 78. [子集](https://leetcode-cn.com/problems/subsets/)
    https://leetcode-cn.com/problems/subsets/
    给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
    
    解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
    
    示例 1：
    输入：nums = [1,2,3]
    输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    
    示例 2：
    输入：nums = [0]
    输出：[[],[0]]
```java
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length == 0) return res;

        dfs(nums, 0);

        return res;
    }


    public void dfs(int[] arr, int index) {

        if (index >= arr.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        dfs(arr, index + 1);

        list.add(arr[index]);
        dfs(arr, index + 1);

        list.remove(list.size() - 1);
    }
```

### 79. [单词搜索](https://leetcode-cn.com/problems/word-search/)
     给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
    
    示例 1：
    输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    输出：true
    
    示例 2：
    输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    输出：true
    
    示例 3：
    输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
    输出：false
```java
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int index) {

        if (!inArea(board, x, y) || board[x][y] == '-' || board[x][y] != word.charAt(index)) return false;

        if (index == word.length() - 1) return true;

        char tmp = board[x][y];
        board[x][y] = '-';

        boolean flag = dfs(board,x+1,y,word,index+1)
                || dfs(board, x-1, y, word, index+1)
                || dfs(board, x, y+1, word, index+1)
                || dfs(board, x, y-1, word, index+1);

        board[x][y] = tmp;

        return flag;
    }

    public boolean inArea(char[][] chars, int x, int y) {
        return x >= 0 && x < chars.length && y >= 0 && y < chars[0].length;
    }


```


### [84. 柱状图中最大的矩形xxx](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)
```java
    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0) return 0;

        int len = heights.length;
        if (len == 1) return heights[0];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {

            int r = i + 1;
            while (r < len && heights[i] <= heights[r]) r++;

            int l = i - 1;
            while (l >= 0 && heights[i] <= heights[l]) l--;


            max = Math.max((r - l - 1) * heights[i], max);

        }

        return max;

    }
```

### [98. 验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)
    给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
    
    有效 二叉搜索树定义如下：
    
    节点的左子树只包含 小于 当前节点的数。
    节点的右子树只包含 大于 当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。
    
    示例 1：
    输入：root = [2,1,3]
    输出：true
    
    示例 2：
    输入：root = [5,1,4,null,null,3,6]
    输出：false
    解释：根节点的值是 5 ，但是右子节点的值是 4 。

```java
    public boolean isValidBST(TreeNode root) {

        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }

    public boolean dfs(TreeNode root,long lower,long upper){

        if(root == null) return true;

        if(root.val <= lower || root.val >= upper) return false;

        return dfs(root.left,lower,root.val) && dfs(root.right,root.val,upper);

    }
```

### [101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)
    给你一个二叉树的根节点 root ， 检查它是否轴对称。
    
    示例 1：
    输入：root = [1,2,2,3,4,4,3]
    输出：true
    
    示例 2：
    输入：root = [1,2,2,null,3,null,3]
    输出：false

```java
    public boolean isSymmetric(TreeNode root) {

        if(root == null ) return true;

        return dfs(root.left,root.right);
    }

    public boolean dfs(TreeNode L,TreeNode R){

        if(L == null && R == null) return true;

        if(L == null || R == null || L.val != R.val) return false;

        return dfs(L.left,R.right) && dfs(L.right,R.left);

    }
```

### [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)
    给定一个二叉树，找出其最大深度。
    
    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    
    说明:叶子节点是指没有子节点的节点。
    
    示例：
    给定二叉树 [3,9,20,null,null,15,7]，
    
    3
    / \
    9  20
    /  \
    15   7
    返回它的最大深度3 。
```java
   public int maxDepth(TreeNode root) {

        return dfs(root);
    }

    public int dfs(TreeNode root){

        if(root == null) return 0;

        int leftDeep = dfs(root.left);
        int rightDeep = dfs(root.right);

        return Math.max(leftDeep,rightDeep) + 1;

    }

```

### [105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
    给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
    
    示例 1:
    输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    输出: [3,9,20,null,null,15,7]
    
    示例 2:
    输入: preorder = [-1], inorder = [-1]
    输出: [-1]
```java
    Map<Integer,Integer> map = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || inorder == null) return null;

        if(preorder.length != inorder.length) return null;


        for(int i = 0;i < inorder.length;i++) map.put(inorder[i],i);

        return dfs(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }

    public TreeNode dfs(int[] preorder,int pL,int pR,int[] inorder,int iL,int iR){

        if(pL > pR || iL > iR) return null;

        int rootVal = preorder[pL];
        TreeNode root = new TreeNode(rootVal);

        int pivot = map.get(rootVal);

        root.left = dfs(preorder,pL+1,pivot-iL+pL,inorder,iL,pivot-1);
        root.right = dfs(preorder,pivot-iL+pL+1,pR,inorder,pivot+1,iR);


        return root;

    }
```

### [106. 从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
    给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
    
    示例 1:
    输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    输出：[3,9,20,null,null,15,7]
    
    示例 2:
    输入：inorder = [-1], postorder = [-1]
    输出：[-1]
```java
    Map<Integer,Integer> map = new HashMap();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder == null || postorder == null) return null;
        if(inorder.length != postorder.length) return null;

        for(int i = 0;i < inorder.length;i++) map.put(inorder[i],i);

        return dfs(inorder,0,inorder.length-1,postorder,0,postorder.length-1);

    }

    public TreeNode dfs(int[] inorder,int oL,int oR,int[] postorder,int pL,int pR){

        if(pL > pR || oL > oR) return null;

        int rootVal = postorder[pR];
        TreeNode root = new TreeNode(rootVal);

        int pivot = map.get(rootVal);

        root.left = dfs(inorder,oL,pivot-1,postorder,pL,pL+pivot-oL-1);
        root.right = dfs(inorder,pivot+1,oR,postorder,pR-oR+pivot,pR-1);


        return root;
    }

```

### [114. 二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/)
    给你二叉树的根结点 root ，请你将它展开为一个单链表：
    
    展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
    展开后的单链表应该与二叉树 先序遍历 顺序相同。
    
    示例 1：
    输入：root = [1,2,5,3,4,null,6]
    输出：[1,null,2,null,3,null,4,null,5,null,6]
    
    示例 2：
    输入：root = []
    输出：[]
    
    示例 3：
    输入：root = [0]
    输出：[0]
```java
    TreeNode curr;

    public void flatten(TreeNode root) {

        TreeNode head = new TreeNode(-1);
        curr = head;
        dfs(root);
    }

    public void dfs(TreeNode root){

        if(root == null) return;

        // curr = root;
        curr.left = null;
        curr.right = root;

        curr = root;

        TreeNode left = root.left;
        TreeNode right = root.right;

        dfs(left);
        dfs(right);

    }
```

### [121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)
    给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
    
    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    
    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
    
    示例 1：
    输入：[7,1,5,3,6,4]
    输出：5
    解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
    
    示例 2：
    输入：prices = [7,6,4,3,1]
    输出：0
    解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
```java
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0) return 0;

        int len = prices.length;
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        
        for(int i = 0;i < len;i++){

            if(min > prices[i]) min = prices[i];

            if(prices[i] - min > maxProfit) maxProfit = prices[i] - min;

        }

        return maxProfit;


    }
```

### [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)
    给定一个数组 prices ，其中prices[i] 表示股票第 i 天的价格。
    
    在每一天，你可能会决定购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
    返回 你能获得的 最大 利润。
    
    示例 1:
    输入: prices = [7,1,5,3,6,4]
    输出: 7
    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
    
    示例 2:
    输入: prices = [1,2,3,4,5]
    输出: 4
    解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
       
    示例3:
    输入: prices = [7,6,4,3,1]
    输出: 0
    解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
```java
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0) return 0;

        int len = prices.length;

        int maxProfit = 0;

        for(int i = 1;i < len;i++){

            if(prices[i] - prices[i-1] > 0){
                maxProfit+=prices[i]-prices[i-1];
            }

        }

        return maxProfit;

    }
```

### [123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)
    给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    
    设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
    
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    
    示例1:
    输入：prices = [3,3,5,0,0,3,1,4]
    输出：6
    解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
    随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
    
    示例 2：
    输入：prices = [1,2,3,4,5]
    输出：4
    解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
    因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
    
    示例 3：
    输入：prices = [7,6,4,3,1]
    输出：0
    解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
    
    示例 4：
    输入：prices = [1]
    输出：0
```java
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0) return 0;

        int len = prices.length;

        int[][][] dp = new int[len+1][3][2];

        dp[1][1][0] = 0;
        dp[1][1][1] = -prices[0];
        dp[1][2][0] = 0;
        dp[1][2][1] = -prices[0];


        for(int i = 2;i <= len;i++){

            dp[i][2][0] = Math.max(dp[i-1][2][0],dp[i-1][2][1] + prices[i-1]);
            dp[i][2][1] = Math.max(dp[i-1][2][1],dp[i-1][1][0] - prices[i-1]);
            dp[i][1][0] = Math.max(dp[i-1][1][0],dp[i-1][1][1] + prices[i-1]);
            dp[i][1][1] = Math.max(dp[i-1][1][1],dp[i-1][0][0] - prices[i-1]);

        }
        

        return dp[len][2][0];

    }
```

### [309. 最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)
    给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
    
    设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
    
    卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

    示例 1:
    
    输入: prices = [1,2,3,0,2]
    输出: 3
    解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
    示例 2:
    
    输入: prices = [1]
    输出: 0
```java
    public int maxProfit(int[] prices) {

        int len = prices.length;

        if(len == 1) return 0;

        int[][] dp = new int[len+1][2];

        dp[1][0] = 0;
        dp[1][1] = -prices[0];

        for(int i = 2;i <= len;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0] - prices[i-1]);
        }

        return dp[len][0];

    }
```

### [124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)
    路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
    
    路径和 是路径中各节点值的总和。
    
    给你一个二叉树的根节点 root ，返回其 最大路径和 。
    
    示例 1：
    输入：root = [1,2,3]
    输出：6
    解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
    
    示例 2：
    输入：root = [-10,9,20,null,null,15,7]
    输出：42
    解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
```java
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);

        return res;
    }

    public int dfs(TreeNode root) {

        if (root == null) return 0;

        int L = dfs(root.left);
        if (L < 0) L = 0;

        int R = dfs(root.right);
        if (R < 0) R = 0;

        res = Math.max(res, root.val + L + R);

        return root.val + Math.max(L, R);

    }

```



### [128. 最长连续序列](https://leetcode-cn.com/problems/longest-consecutive-sequence/)
    给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    
    请你设计并实现时间复杂度为O(n) 的算法解决此问题。
    
    示例 1：
    输入：nums = [100,4,200,1,3,2]
    输出：4
    解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
    
    示例 2：
    输入：nums = [0,3,7,2,5,8,4,6,0,1]
    输出：9
```java
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int n : nums) set.add(n);
        int res = 0;
        for (Integer x : set) {
            if (!set.contains(x - 1)) {
                int y = x;
                while (set.contains(y + 1)) y++;
                res = Math.max(res, y - x + 1);
            }
        }

        return res;

    }
```


### [136. 只出现一次的数字](https://leetcode-cn.com/problems/single-number/)
    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    
    说明：
    
    你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    示例 1:
    输入: [2,2,1]
    输出: 1
    
    示例2:
    输入: [4,1,2,1,2]
    输出: 4
```java
    public int singleNumber(int[] nums) {

        int res = nums[0];

        if(nums.length == 1) return res;

        for(int i = 1;i < nums.length;i++){
            res = res ^ nums[i];
        }

        return res;

    }
```

### [137. 只出现一次的数字 II](https://leetcode-cn.com/problems/single-number-ii/)
    给你一个整数数组nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
    
    示例 1：
    输入：nums = [2,2,3,2]
    输出：3
    
    示例 2：
    输入：nums = [0,1,0,1,0,1,99]
    输出：99

```java
    public int singleNumber(int[] nums) {

        int res = 0;

        for(int i = 0;i < 32;i++){

            int oneCount = 0;

            for(int j = 0;j < nums.length;j++){
                
                if(((nums[j] >>> i) & 1 )== 1) oneCount+=1;
                // oneCount+= (nums[j] >>> i) & 1;
            }

            if(oneCount % 3 == 1) res = res | 1 << i;

        }

        return res;

    }
```

### [139. 单词拆分](https://leetcode-cn.com/problems/word-break/)
    给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
    
    注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
    
    示例 1：
    输入: s = "leetcode", wordDict = ["leet", "code"]
    输出: true
    解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
    
    示例 2：
    输入: s = "applepenapple", wordDict = ["apple", "pen"]
    输出: true
    解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
    注意，你可以重复使用字典中的单词。
    
    示例 3：
    输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
    输出: false
```java
    Map<Integer, Boolean> map = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    public boolean dfs(String s, List<String> wordDict, int index) {

        if (index >= s.length()) return true;
        if (map.containsKey(index)) return map.get(index);

        for (String w : wordDict) {
            if (w.length() + index > s.length()) continue;
            String ss = s.substring(index, index + w.length());
            if (w.equals(ss)) {
                map.put(index, dfs(s, wordDict, index + w.length()));
                if (map.get(index)) return true;
            }
        }

        return false;

    }

```

### [146. LRU 缓存](https://leetcode-cn.com/problems/lru-cache/)
    请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
    实现 LRUCache 类：
    LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
    int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
    函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。


    
    示例：
    
    输入
    ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
    输出
    [null, null, null, 1, null, -1, null, -1, 3, 4]
    
    解释
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // 缓存是 {1=1}
    lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
    lRUCache.get(1);    // 返回 1
    lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
    lRUCache.get(2);    // 返回 -1 (未找到)
    lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
    lRUCache.get(1);    // 返回 -1 (未找到)
    lRUCache.get(3);    // 返回 3
    lRUCache.get(4);    // 返回 4

```java
     class LRUCache {

        class Node {
            int key, val;
            Node pre, next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        int c;
        Node head, tail;
        Map<Integer, Node> map;

        public LRUCache(int capacity) {
            if (capacity < 0) throw new RuntimeException();
            this.c = capacity;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.pre = head;
            map = new HashMap<>();
        }

        public int get(int key) {

            if (!map.containsKey(key)) return -1;

            Node node = map.get(key);

            //remove
            remove(node);
            //add
            add(node);

            return node.val;

        }

        public void put(int key, int value) {
            Node node = new Node(key, value);

            if (!map.containsKey(key)) {
                //add new node
                if (map.size() == c) remove(tail.pre);
                add(node);
                return;
            }

            //update node
            remove(map.get(key));
            add(node);

        }

        public void remove(Node node) {

            map.remove(node.key);

            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.next = null;
            node.pre = null;

            //help gc


        }

        public void add(Node node) {

            map.put(node.key, node);

            head.next.pre = node;
            node.next = head.next;
            head.next = node;
            node.pre = head;

        }

    }
```

### [152. 乘积最大子数组](https://leetcode-cn.com/problems/maximum-product-subarray/)

    给你一个整数数组 nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
    示例 1:
    
    输入: [2,3,-2,4]
    输出: 6
    解释:子数组 [2,3] 有最大乘积 6。
    示例 2:
    
    输入: [-2,0,-1]
    输出: 0
    解释:结果不能为 2, 因为 [-2,-1] 不是子数组。

```java
    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        if (len == 1) return nums[0];

        int max = Integer.MIN_VALUE, imax = 1, imin = 1;

        for (int i = 0; i < len; i++) {

            if (nums[i] < 0) {
                imax = imax ^ imin;
                imin = imax ^ imin;
                imax = imax ^ imin;
            }

            imax = Math.max(nums[i], nums[i] * imax);
            imin = Math.min(nums[i], nums[i] * imin);

            max = Math.max(max, imax);

        }

        return max;

    }
```

### [155. 最小栈](https://leetcode-cn.com/problems/min-stack/)
    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
    
    push(x) —— 将元素 x 推入栈中。
    pop()—— 删除栈顶的元素。
    top()—— 获取栈顶元素。
    getMin() —— 检索栈中的最小元素。
    示例:
    
    输入：
    ["MinStack","push","push","push","getMin","pop","top","getMin"]
    [[],[-2],[0],[-3],[],[],[],[]]
    
    输出：
    [null,null,null,null,-3,null,0,-2]
    
    解释：
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> 返回 -3.
    minStack.pop();
    minStack.top();      --> 返回 0.
    minStack.getMin();   --> 返回 -2.


```java
class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
            return;
        }

        int minVal = minStack.peek() > val ? val : minStack.peek();
        minStack.push(minVal);
    }

    public void pop() {
        if (stack.isEmpty()) return;

        stack.pop();
        minStack.pop();

    }

    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    public int getMin() {

        if (minStack.isEmpty()) return -1;

        return minStack.peek();

    }
}
```

### [160. 相交链表](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)
    给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
    
    图示两个链表在节点 c1 开始相交：
    
    题目数据 保证 整个链式结构中不存在环。
    
    注意，函数返回结果后，链表必须 保持其原始结构 。
    
    自定义评测：
    
    评测系统 的输入如下（你设计的程序 不适用 此输入）：
    
    intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
    listA - 第一个链表
    listB - 第二个链表
    skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
    skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
    评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
    
    示例 1：
    输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
    输出：Intersected at '8'
    解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
    从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
    在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
    
    示例2：
    输入：intersectVal= 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
    输出：Intersected at '2'
    解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
    从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
    在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
    
    示例3
    输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
    输出：null
    解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
    由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
    这两个链表不相交，因此返回 null 。


```java
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
```

### [169. 多数元素](https://leetcode-cn.com/problems/majority-element/)
    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
    
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    
    示例1：
    输入：[3,2,3]
    输出：3
    
    示例2：
    输入：[2,2,1,1,1,2,2]
    输出：2
```java
    public int majorityElement(int[] nums) {

        int v = 0,c = 0;

        for(int n : nums){

            if(c == 0) {
                v = n;
                c = 1;
            }else{
                if(n == v){
                    c++;
                }else{
                    c--;
                }
            }
        }

        return v;

    }
```

### [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)

    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    
    给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
    
    示例 1：
    输入：[1,2,3,1]
    输出：4
    解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
    偷窃到的最高金额 = 1 + 3 = 4 。
    
    示例 2：
    输入：[2,7,9,3,1]
    输出：12
    解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
    偷窃到的最高金额 = 2 + 9 + 1 = 12 。
```java
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int len = nums.length;
        if(len == 1) return nums[0];


        // int dp[][] = new int[2][len];

        // dp[0][0] = 0;
        // dp[1][0] = nums[0];

        // for(int i = 1;i < len;i++){

        //     dp[0][i] = Math.max(dp[0][i-1],dp[1][i-1]);
        //     dp[1][i] = dp[0][i-1] + nums[i];

        // }

        // return Math.max(dp[0][len-1],dp[1][len-1]);

        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i = 2;i < len;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }

        return dp[len-1];

    }
```

### [337. 打家劫舍 III](https://leetcode-cn.com/problems/house-robber-iii/)
    小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
    
    除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
    
    给定二叉树的root。返回在不触动警报的情况下，小偷能够盗取的最高金额。

    示例 1:
    输入: root = [3,2,3,null,3,null,1]
    输出: 7
    解释:小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
    
    示例 2:
    输入: root = [3,4,5,1,3,null,1]
    输出: 9
    解释:小偷一晚能够盗取的最高金额 4 + 5 = 9
```java

    public int rob(TreeNode root) {

        int[] ans = dfs(root);

        return Math.max(ans[0],ans[1]);

    }

    public int[] dfs(TreeNode root){

        if(root == null) return new int[]{0,0};

        int[] L = dfs(root.left);
        int[] R = dfs(root.right);

        
        int[] res = new int[2];

        //不偷root
        res[0] = Math.max(L[0],L[1]) + Math.max(R[0],R[1]);

        //偷root
        res[1] = root.val + L[0] + R[0];

        return res;


    }
```




### [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)

    给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
    
    岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
    
    此外，你可以假设该网格的四条边均被水包围。
    
    示例 1：
    输入：grid = [
    ["1","1","1","1","0"],
    ["1","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
    ]
    输出：1
    
    示例 2：
    输入：grid = [
    ["1","1","0","0","0"],
    ["1","1","0","0","0"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
    ]
    输出：3
```java
    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0) return 0;

        int res = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0; j < grid[i].length;j++){

                if(grid[i][j] == '1') {
                    dfs(grid,i,j);
                    res+=1;
                }

            }
        }

        return res;

    }

    public void dfs(char[][] grid,int x,int y){

        if(!inArea(grid,x,y) || grid[x][y] == '0') return;

        grid[x][y] = '0';

        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);

    }

    public boolean inArea(char[][] grid,int x,int y){
        return x >=0 && x < grid.length && y >=0 && y < grid[x].length;
    }

```

### [463. 岛屿的周长](https://leetcode-cn.com/problems/island-perimeter/)

    给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
    
    网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
    
    岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
    
    示例 1：
    输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
    输出：16
    解释：它的周长是上面图片中的 16 个黄色的边
    
    示例 2：
    输入：grid = [[1]]
    输出：4
    
    示例 3：
    输入：grid = [[1,0]]
    输出：4
```java
   public int islandPerimeter(int[][] grid) {

        if(grid == null ) return 0;

        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[i].length;j++){

                if(grid[i][j] == 1) return dfs(grid,i,j);

            }
        }

        return 0;

    }

    public int dfs(int[][] grid,int x,int y){
        
        if(!inArea(grid,x,y) || grid[x][y] == 0) return 1;

        if(grid[x][y] == -1) return 0;

        grid[x][y] = -1;

        return  dfs(grid,x+1,y) + dfs(grid,x-1,y) + dfs(grid,x,y+1) + dfs(grid,x,y-1);


    }

    public boolean inArea(int[][] grid,int x,int y){
        return x >=0 && x < grid.length && y >=0 && y < grid[x].length;
    }

```




### [695. 岛屿的最大面积](https://leetcode-cn.com/problems/max-area-of-island/)

    给你一个大小为 m x n 的二进制矩阵 grid 。
    
    岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
    
    岛屿的面积是岛上值为 1 的单元格的数目。
    
    计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
    
    示例 1：
    输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
    输出：6
    解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
    
    示例 2：
    输入：grid = [[0,0,0,0,0,0,0,0]]
    输出：0

```java
      public int maxAreaOfIsland(int[][] grid) {

        if(grid == null ) return 0;

        int max = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[i].length;j++){

                if(grid[i][j] == 1){
                     max = Math.max(dfs(grid,i,j),max);
                }

            }
        }

        return max;

    }

    public int dfs(int[][] grid,int x,int y){
        
        if(!inArea(grid,x,y) || grid[x][y] == 0) return 0;

        grid[x][y] = 0;

        return  1 + dfs(grid,x+1,y) + dfs(grid,x-1,y) + dfs(grid,x,y+1) + dfs(grid,x,y-1);


    }

    public boolean inArea(int[][] grid,int x,int y){
        return x >=0 && x < grid.length && y >=0 && y < grid[x].length;
    }

```

### [208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)

    Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
    
    请你实现 Trie 类：
    
    Trie() 初始化前缀树对象。
    void insert(String word) 向前缀树中插入字符串 word 。
    boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
    boolean startsWith(String prefix) 如果之前已经插入的字符串word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
    示例：
    
    输入
    ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
    [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
    输出
    [null, null, true, false, true, null, true]
    
    解释
    Trie trie = new Trie();
    trie.insert("apple");
    trie.search("apple");   // 返回 True
    trie.search("app");     // 返回 False
    trie.startsWith("app"); // 返回 True
    trie.insert("app");
    trie.search("app");     // 返回 True

```java
class Trie {

    class Node{
        Node node[];
        boolean flag;
        public Node(){
            node = new Node[26];
            flag = false;
        }     
    }

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){

            int id = c - 'a';
            if(curr.node[id] == null) curr.node[id] = new Node();

            curr = curr.node[id];
        }
        curr.flag = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){
            int id = c - 'a';
            if(curr.node[id] == null) return false;
            curr = curr.node[id];
        }

        return curr.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char c : prefix.toCharArray()){
            int id = c - 'a';
            if(curr.node[id] == null) return false;
            curr = curr.node[id];
        }

        return true;
    }
}

```

### [209. 长度最小的子数组](https://leetcode-cn.com/problems/minimum-size-subarray-sum/)
    给定一个含有n个正整数的数组和一个正整数 target 。
    
    找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
    
    示例 1：
    输入：target = 7, nums = [2,3,1,2,4,3]
    输出：2
    解释：子数组[4,3]是该条件下的长度最小的子数组。
    
    示例 2：
    输入：target = 4, nums = [1,4,4]
    输出：1
    
    示例 3：
    输入：target = 11, nums = [1,1,1,1,1,1,1,1]
    输出：0

````java
    public int minSubArrayLen(int target, int[] nums) {

        if(nums == null || nums.length == 0 ) return 0;

        int len = nums.length;

        int min = len + 1;

        int L = 0,R = -1,sum = 0;

        while(++R < len){

            sum+=nums[R];

            while(sum >= target){
                min = Math.min(min,R - L + 1);
                sum-=nums[L++];
            }
        }

        return min > len ? 0 : min;

    }
````

### [215. 数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)
    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    
    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    
    示例 1:
    输入: [3,2,1,5,6,4] 和 k = 2
    输出: 5
    
    示例2:
    输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
    输出: 4

```java
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
```

### [221. 最大正方形](https://leetcode-cn.com/problems/maximal-square/)
    在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
    
    示例 1：
    输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    输出：4
    
    示例 2：
    输入：matrix = [["0","1"],["1","0"]]
    输出：1
    
    示例 3：
    输入：matrix = [["0"]]
    输出：0
```java
   public int maximalSquare(char[][] matrix) {

        if(matrix == null || matrix.length == 0) return 0;

        int m = matrix.length,n = matrix[0].length;
        int max = 0;
        
        int dp[][] = new int[m+1][n+1];

        for(int i = 1;i <= m;i++){

            for(int j = 1;j <= n;j++){

                if(matrix[i-1][j-1] == '0') continue;

                dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));

                max = Math.max(max,dp[i][j]);
            }
        }

        return max * max;
        
    }
```

### [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/submissions/)

```java
    public TreeNode invertTree(TreeNode root) {

        if(root == null) return root;

        TreeNode L = root.left;
        root.left = root.right;
        root.right = L;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }
```

### [234. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)
    给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
    
    示例 1：
    输入：head = [1,2,2,1]
    输出：true
    
    示例 2：
    输入：head = [1,2]
    输出：false
```java
   public boolean isPalindrome(ListNode head) {

        int len = 0;

        ListNode p = head;

        while(p != null){
            len+=1;
            p = p.next;
        }

        int half = len / 2;

        p = null;
        ListNode q = head;

        for(int i = 0;i < half;i++){

            ListNode t = q.next;

            q.next = p;

            p = q;
            q = t;

        }

        if((len & 1) == 1) q = q.next;

        while(q != null){
            if(p.val != q.val) return false;
            p = p.next;
            q = q.next;
        } 

        return true;

    }
```

### [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    
    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    
    示例 1：
    输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    输出：3
    解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
    
    示例 2：
    输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    输出：5
    解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
    
    示例 3：
    输入：root = [1,2], p = 1, q = 2
    输出：1


```java
    Map<TreeNode, TreeNode> map = new HashMap();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        process(root);
        map.put(root, root);

        TreeNode curr = p;
        Set<TreeNode> set = new HashSet();

        while (curr != map.get(curr)) {
            set.add(curr);
            curr = map.get(curr);
        }
        set.add(curr);

        curr = q;

        while (!set.contains(curr)) curr = map.get(curr);

        return curr;
        
    }

    public void process(TreeNode root) {

        if (root == null) return;

        map.put(root.left, root);
        map.put(root.right, root);

        process(root.left);
        process(root.right);

    }
```

### [238. 除自身以外数组的乘积](https://leetcode-cn.com/problems/product-of-array-except-self/)
    给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
    
    题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
    
    请不要使用除法，且在O(n) 时间复杂度内完成此题。
    
    示例 1:
    输入: nums = [1,2,3,4]
    输出: [24,12,8,6]
    
    示例 2:
    输入: nums = [-1,1,0,-3,3]
    输出: [0,0,9,0,0]
```java
    public int[] productExceptSelf(int[] nums) {

        if(nums == null || nums.length == 0) return null;

        int len = nums.length;

        int p[] = new int[len];

        int t = 1;
        for(int i = 0; i < len;i++){
            p[i] = t;
            t*=nums[i];
        }

        t = 1;
        for(int i = len - 1;i >=0 ;i--){

            p[i] = p[i] * t;
            t*=nums[i];
        }

        return p;

    }
```

### [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)
    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    
    请注意，必须在不复制数组的情况下原地对数组进行操作。
    
    示例 1:
    输入: nums = [0,1,0,3,12]
    输出: [1,3,12,0,0]
    
    示例 2:
    输入: nums = [0]
    输出: [0]
```java
    public void moveZeroes(int[] nums) {

        if(nums == null || nums.length == 0) return;

        int len = nums.length;
        if(len < 2) return;

        int L = 0,R = 0;

        while(R < len){
            if(nums[R] != 0){
                nums[L++] = nums[R];
            }
            R++;
        }

        while(L < len) nums[L++] = 0;

    }
```

### [287. 寻找重复数](https://leetcode-cn.com/problems/find-the-duplicate-number/)
    给定一个包含n + 1 个整数的数组nums ，其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。
    
    假设 nums 只有 一个重复的整数 ，返回这个重复的数 。
    
    你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
    
    示例 1：
    输入：nums = [1,3,4,2,2]
    输出：2
    
    示例 2：
    输入：nums = [3,1,3,4,2]
    输出：3
    
```java
    public int findDuplicate(int[] nums) {

        int len = nums.length;

        int R = len - 1, L = 0, ans = -1;

        while (R >= L) {

            int mid = L + ((R - L) >> 1);
            int cnt = 0;

            for (int x : nums) {
                if (x <= mid) cnt++;
            }

            if (cnt > mid) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

```

### [297. 二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/submissions/)
    序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
    
    请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
    
    提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
    
    示例 1：
    输入：root = [1,2,3,null,null,4,5]
    输出：[1,2,3,null,null,4,5]

```java

public class Codec {

    int N = 20000;
    char[] buf = new char[N];
    int length;
    int curr;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        length = 0;

        dfs(root);

        buf[length] = 0;

        return String.valueOf(buf,0,length);

    }


    public void dfs(TreeNode root){

        if(length != 0) buf[length++] = ',';
        if(root == null){
            buf[length++] = '#';
            return;
        }

        String val = String.valueOf(root.val);
        for(char c : val.toCharArray()) buf[length++] = c;

        dfs(root.left);
        dfs(root.right);


    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int curr = 0;
        return gen(data);
    }


    public TreeNode gen(String data){

        if(curr >= data.length()) return null;

        if(data.charAt(curr) == '#'){
            curr+=2; // "#,?"
            return null;
        }

        int flag = 1,val = 0;

        if(data.charAt(curr) == '-') {
            flag = -1;
            curr++;
        }

        while (curr < data.length() && Character.isDigit(data.charAt(curr))){
            val = val * 10 + data.charAt(curr) - '0';
            curr++;
        }


        TreeNode root = new TreeNode(flag * val);

        curr++; //"?,"

        root.left = gen(data);
        root.right = gen(data);

        return root;

    }
    
}
```

### [300. 最长递增子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)
    
    给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    
    子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
    
    示例 1：
    输入：nums = [10,9,2,5,3,7,101,18]
    输出：4
    解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
    
    示例 2：
    输入：nums = [0,1,0,3,2,3]
    输出：4
    
    示例 3：
    输入：nums = [7,7,7,7,7,7,7]
    输出：1
```java
    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int ans = 1;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
    
    ======================================

    int[] f;

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        f = new int[len + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        int res = 0;

        for (int i = 0; i < len; i++) {

            int k = bs(nums[i]);
            f[k + 1] = nums[i];
            res = Math.max(res, k + 2);

        }

        return res;

    }

    public int bs(int x) {

        int L = 0, R = f.length - 1;
        int ans = -1;

        while (L <= R) {

            int mid = (L + R) >> 1;
            if (f[mid] < x) {
                ans = mid;
                L = mid + 1;
            } else R = mid - 1;

        }

        return ans;

    }
```

### [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)
    给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
    
    有效字符串需满足：
    
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。

    示例 1： 
    输入：s = "()"
    输出：true

    示例2
    输入：s = "()[]{}"
    输出：true

    示例3：
    输入：s = "(]"
    输出：false

    示例4：
    输入：s = "([)]"
    输出：false

    示例5：
    输入：s = "{[]}"
    输出：true
```java
public boolean isValid(String s) {

        Map<Character,Character> map = new HashMap<>(3);
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack();

        for (char c : s.toCharArray()) {

            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (map.get(c) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();

    }
```

### [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
    数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

    示例 1：
    输入：n = 3
    输出：["((()))","(()())","(())()","()(())","()()()"]
    
    示例 2：
    输入：n = 1
    输出：["()"]
```java
    List<String> res = new ArrayList();

    public List<String> generateParenthesis(int n) {
        dfs(n,n,"");
        return res;
    }

    public void dfs(int L,int R,String ans){

        if(L == 0 && R == 0 && ans != ""){
            res.add(new String(ans));
            return;
        }

        if(L > R) return;

        if(L > 0) dfs(L-1,R,ans+"(");
        if(R > 0) dfs(L,R-1,ans+")");

    }

```

### [301. 删除无效的括号](https://leetcode-cn.com/problems/remove-invalid-parentheses/)
    给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
    
    返回所有可能的结果。答案可以按 任意顺序 返回。
    
    示例 1：
    
    输入：s = "()())()"
    输出：["(())()","()()()"]
    示例 2：
    
    输入：s = "(a)())()"
    输出：["(a())()","(a)()()"]
    示例 3：
    
    输入：s = ")("
    输出：[""]
```java

    List<String> res = new ArrayList<>();
    List<int[]> data = new ArrayList<>();
    int maxLen;

    public List<String> removeInvalidParentheses(String s) {

        int len = s.length();

        int countS = 0, r = 0;
        int cnt = 0;
        for (int i = 0; i < len; i++) {

            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) cnt++;
            else {
                data.add(new int[]{s.charAt(i - 1), cnt});
                cnt = 1;
            }

            if (s.charAt(i) == '(') countS += 1;
            else if (s.charAt(i) == ')') {
                if (countS == 0) r += 1;
                else countS -= 1;
            }

        }

        data.add(new int[]{s.charAt(len - 1), cnt});

        //删除无法元素后剩余的最大长度
        maxLen = len - (countS + r);

        List<int[]> ans = new ArrayList<>();
        dfs(0, 0, 0, ans);

        return res;
    }

    //index 当前遍历到了那段字符串
    private void dfs(int index, int sum, int currLen, List<int[]> ans) {

        if (index == data.size()) {
            if (sum == 0 && currLen == maxLen) {
                res.add(gen(ans));
            }
            return;
        }

        int[] currData = data.get(index);

        //不是 (  )
        if (currData[0] != '(' && currData[0] != ')') {
            if (currLen + currData[1] > maxLen) return;

            ans.add(new int[]{currData[0], currData[1]});

            dfs(index + 1, sum, currLen + currData[1], ans);

            ans.remove(ans.size() - 1);

            return;

        }


        ans.add(new int[]{currData[0], currData[1]});

        for (int i = 0; i <= currData[1]; i++) {
            if (currData[0] == '(') {

                if (currLen + i <= maxLen) {
                    ans.get(index)[1] = i;
                    dfs(index + 1, sum + i, currLen + i, ans);
                }

            } else if (currData[0] == ')') {
                if (sum >= i && currLen + i <= maxLen) {
                    ans.get(index)[1] = i;
                    dfs(index + 1, sum - i, currLen + i, ans);
                }
            }
        }


        ans.remove(ans.size() - 1);

    }

    private String gen(List<int[]> ans) {
        StringBuffer r = new StringBuffer();

        for (int[] ints : ans) {
            for (int i = 0; i < ints[1]; i++) {
                r.append((char) ints[0]);
            }
        }

        return r.toString();
    }

```

### [312. 戳气球](https://leetcode-cn.com/problems/burst-balloons/)
    有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组nums中。
    现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。这里的 i - 1 和 i + 1 代表和i相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
    求所能获得硬币的最大数量。

    示例 1：
    输入：nums = [3,1,5,8]
    输出：167
    解释：
    nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
    coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

    示例 2： 
    输入：nums = [1,5]
    输出：10
```java
    int[][] dp = new int[505][505];

    public int maxCoins(int[] nums) {

        int len = nums.length;

        int[] p = new int[len + 2];
        p[0] = p[len + 1] = 1;
        for (int i = 1; i <= len; i++) p[i] = nums[i - 1];


        for (int i = 1; i <= len; i++) dp[i][i] = p[i - 1] * p[i] * p[i + 1];

        for (int n = 2; n <= len; n++) {

            for (int i = 1; n + i - 1 <= len; i++) {

                int j = n + i - 1;

                for (int k = i; k <= j; k++) {

                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + p[k] * p[i - 1] * p[j + 1]);

                }

            }

        }

        return dp[1][len];

    }

```

### [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)
    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    
    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
    
    你可以认为每种硬币的数量是无限的。
    
    
    示例1：
    输入：coins = [1, 2, 5], amount = 11
    输出：3
    解释：11 = 5 + 5 + 1
    
    示例 2：
    输入：coins = [2], amount = 3
    输出：-1
    
    示例 3：
    输入：coins = [1], amount = 0
    输出：0
```java
    public int coinChange(int[] coins, int amount) {

        int len = coins.length;

        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;

        for(int i = 1;i <= amount;i++){

            for(int j = 0;j < len;j++){

                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]] + 1);
                }
            }
        }
        
        return  dp[amount] > amount ? -1 : dp[amount];
        
    }
```















