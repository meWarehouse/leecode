



### 1. 两数之和
    https://leetcode-cn.com/problems/two-sum/
    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    
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

### 2. 两数相加
    https://leetcode-cn.com/problems/add-two-numbers/
    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    
    请你将两个数相加，并以相同形式返回一个表示和的链表。
    
    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    
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

### 3. 无重复字符的最长子串
    https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
    给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    
     
    
    示例 1:
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
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    
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

### 4. 寻找两个正序数组的中位数
    https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
    给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
    
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

### 5. 最长回文子串
    https://leetcode-cn.com/problems/longest-palindromic-substring/
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

### 6. Z 字形变换
    https://leetcode-cn.com/problems/zigzag-conversion/
    将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
    比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
    
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



### 9. 回文数
    https://leetcode-cn.com/problems/palindrome-number/
    给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
    
    回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。


​     
    示例 1：
    输入：x = 121
    输出：true
    
    示例 2：
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









### 15. 三数之和
    https://leetcode-cn.com/problems/3sum/
    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    
    注意：答案中不可以包含重复的三元组。


​     
​    
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

### 17. 电话号码的字母组合
     https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
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


### 23. 合并K个升序链表
    https://leetcode-cn.com/problems/merge-k-sorted-lists/
    
    给你一个链表数组，每个链表都已经按升序排列。
    
    请你将所有链表合并到一个升序链表中，返回合并后的链表。


​     
​    
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


​     
​    
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


​     
​    
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

















### 34. 在排序数组中查找元素的第一个和最后一个位置
    https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    如果数组中不存在目标值 target，返回 [-1, -1]。
    
    进阶：
    你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

    示例 1：
    输入：nums = [5,7,7,8,8,10], target = 8
    输出：[3,4]

    示例 2：
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


### 39. 组合总和
    https://leetcode-cn.com/problems/combination-sum/
    给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
    
    candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
    
    对于给定的输入，保证和为 target 的不同组合数少于 150 个。
    
     
    
    示例 1：
    输入：candidates = [2,3,6,7], target = 7
    输出：[[2,2,3],[7]]
    解释：
    2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
    7 也是一个候选， 7 = 7 。
    仅有这两种组合。

    示例 2：
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




### 53. 最大子数组和
    https://leetcode-cn.com/problems/maximum-subarray/
    给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    
    子数组 是数组中的一个连续部分。
    
    示例 1：
    输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    输出：6
    解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
    
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



### 55. 跳跃游戏
    https://leetcode-cn.com/problems/jump-game/
    给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
    
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    
    判断你是否能够到达最后一个下标。
    
    示例 1：
    输入：nums = [2,3,1,1,4]
    输出：true
    解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
    
    示例 2：
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

### 56. 合并区间
    https://leetcode-cn.com/problems/merge-intervals/
    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
    
     
    
    示例 1：
    输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    输出：[[1,6],[8,10],[15,18]]
    解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    
    示例 2：
    
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


### 62. 不同路径
    https://leetcode-cn.com/problems/unique-paths/
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    
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

### 64. 最小路径和
    https://leetcode-cn.com/problems/minimum-path-sum/
    给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    
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















































### 48. 旋转图像
    https://leetcode-cn.com/problems/rotate-image/
    给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
    
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

### 49. 字母异位词分组
    https://leetcode-cn.com/problems/group-anagrams/
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
















