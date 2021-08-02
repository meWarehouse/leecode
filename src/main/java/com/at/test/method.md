



## 二叉树



树形DP

向左要信息 向右要信息



```
class Node{
    public int value;
    public Node left;
    public Node right;
}
```

### 中序遍历

```java
public void inOrderRecur(Node head){

    if(head == null) return;

    inOrderRecur(head.left);

    System.out.println(head.value);

    inOrderRecur(head.right);

}

public void inOrderUnRecur(Node head){

    if(head != null){

        Stack<Node> stack = new Stack<>();

        while (!stack.isEmpty() || head != null){

            if(head != null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }
    }
}
```





### 搜索二叉树

中序遍历有序

```java
public boolean isBST(Node head){

    if(head == null) return false;

    boolean isLeftBST = isBST(head.left);
    if(!isLeftBST) return false;

    if(head.value <= preVal){
        return false;
    }else {
        preVal = head.value;
    }

    return isBST(head.right);


}

public boolean isUnBST(Node head){

    if(head != null){

        Stack<Node> stack = new Stack<>();

        if(!stack.isEmpty() || head != null){

            if(head != null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();


                if(head.value <= preVal){
                    return false;
                }else {
                    preVal = head.value;
                }

                System.out.println(head.value);

                head = head.right;

            }
        }
    }

    return true;

}


//递归
public int preVal = Integer.MIN_VALUE;

class ReturnData{
    public boolean isBST;
    public int max;
    public int min;

    public ReturnData(boolean isBST, int max, int min) {
        this.isBST = isBST;
        this.max = max;
        this.min = min;
    }
}

public ReturnData process(Node head){

    if(head == null) return null;

    ReturnData leftData = process(head.left);
    ReturnData rightData = process(head.right);


    int max = head.value;
    int min = head.value;

    if(leftData != null){
        min = Math.min(leftData.min,min);
        max = Math.max(leftData.max,max);
    }
    if(rightData != null){
        min = Math.min(leftData.min,min);
        max = Math.max(leftData.max,max);
    }

    boolean isBST = true;
    if(leftData != null && (!leftData.isBST || leftData.max >= head.value)){
        isBST = false;
    }
    if(rightData != null && (!rightData.isBST || rightData.min <= head.value)){
        isBST = false;
    }


    return new ReturnData(isBST,max,min);

}


```



### 完全二叉树

```java
public boolean isCBT(Node head) {

    /*
            1.有右无左 false
            2.在1成立的情况下 遇到左右节点不双全的时 以后的所有节点都是叶子节点

         */

    if (head == null) return true;

    ArrayList<Node> queue = new ArrayList<>();
    queue.add(head);

    Node left = null;
    Node right = null;
    boolean flag = false;

    while (queue.isEmpty()) {

        left = head.left;
        right = head.right;

        if (
            (left == null && right != null) // 有右无左
            || (flag && (left != null || right != null)) //flag 为 true 时 左右节点必须为空
        ) return false;

        if(left != null) queue.add(left);
        if(right != null) queue.add(right);

        if(left == null || right == null) flag = true; //左右节点不双全


    }

    return true;
}

```



### 平衡二叉树

```JAVA
public boolean isBalance(Node head){

    /*
            平衡二叉树 ： 左节点平衡 右节点平衡 左右高度差 < 2
                左 <-> 左
                对于左子树来说 需要判断其是否平衡和高度
                右同理

         */
    return process(head).isBalance;

}

class ReturnType{
    public boolean isBalance;
    public int height;

    public ReturnType(boolean isBalance, int height) {
        this.isBalance = isBalance;
        this.height = height;
    }
}

public ReturnType process(Node head){

    if(head == null) return new ReturnType(true,0);

    ReturnType leftProcess = process(head.left);
    ReturnType rightProcess = process(head.right);

    int height = Math.max(leftProcess.height,rightProcess.height) + 1;
    boolean isBalance = leftProcess.isBalance 
        && rightProcess.isBalance 
        && Math.abs(leftProcess.height - rightProcess.height) < 2;


    return new ReturnType(isBalance,height);

}
```





### 满二叉树

```java
public boolean isFullTree(Node head) {
    /*
            2^高度 - 1 = 二叉树的节点个数
         */
    ReturnData data = process(head);
    return data.nodes == (1 << data.height - 1);
}

class ReturnData {
    public int height; //高度
    public int nodes; // 个数

    public ReturnData(int height, int nodes) {
        this.height = height;
        this.nodes = nodes;
    }
}

public ReturnData process(Node head) {

    if (head == null) return new ReturnData(0, 0);

    ReturnData leftData = process(head.left);
    ReturnData rightData = process(head.right);

    int height = Math.max(leftData.height, rightData.height) + 1;
    int nodes = leftData.nodes + rightData.nodes + 1;

    return new ReturnData(height, nodes);

}
```



### 公共祖先

```
  HashMap<Node, Node> conn = new HashMap<>();

    public Node lca(Node head,Node o1,Node o2){

        conn.put(head,head);
        //找到所有节点的父节点
        process(head);

        //存储 o1 节点的所有父节点
        HashSet<Node> setConn = new HashSet<>();
        Node curr = o1;
        while (curr != conn.get(curr)){
            setConn.add(curr);
            curr = conn.get(curr);
        }
        setConn.add(head);

        curr = o2;
        while (!setConn.contains(curr)){
            curr = conn.get(curr);
        }

        return curr;



    }
    
    public void process(Node head){

        if(head == null) return;

        conn.put(head.left,head);
        conn.put(head.right,head);

        process(head.left);
        process(head.right);

    }

    public Node lca(Node head,Node o1,Node o2){

        if(head == null || head == o1 || head == o2) return head;

        Node left = lca(head.left, o1, o2);
        Node rigth = lca(head.right, o1, o2);

        if(left != null && rigth != null){
            return head;
        }

        return left != null ? left : rigth;

    }

```



后继节点

```java
class Node {
    public int value;
    public Node left;
    public Node right;
    public Node parent;
}


public Node getSuccessorNode(Node node){

    /*
            后继节点
                中序遍历中节点的下一个节点 最后一个节点为 null
         */
    if(node == null) return null;

    if(node.right != null){
        //后继为 右子树的最后一个 左节点  或第一个右节点
        return getLeftMost(node);
    }else {

        Node parent = node.parent;
        if(parent != null && parent.left != null){
            node = parent;
            parent = node.parent;
        }

        return parent;

    }



}

public Node getLeftMost(Node node){

    if(node == null) return null;

    while (node.left != null){
        node = node.left;
    }
    return node;

}


```



## 图

### 结构模板

```java
class Graph{

    public HashMap<Integer, Node> nodes;  // HashMap<点的编号, 点对象>  ex:
    public HashSet<Edge> edges;
    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}

class Node{

    public int value;
    public int in; //点的入度
    public int out; //出度
    public ArrayList<Node> nexts; //当前节点发散出去的边直接连接的节点
    public ArrayList<Edge> edges; //当前点发散出去的边
    public Node(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

}
class Edge{

    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}

```



### 接口

```java
public Graph createGraph(Integer[][] matrix){

        Graph graph = new Graph();

        for (int i = 0; i < matrix.length; i++) {

            // matrix[0][0] => from
            // matrix[0][1] => to
            // matrix[0][2] => weight
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];

            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }

            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);

            Edge newEdge = new Edge(weight, fromNode, toNode);

            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;

            fromNode.edges.add(newEdge);

            graph.edges.add(newEdge);


        }

        return graph;

    }
```



### 深度优先 DFS

```java
/*
        深度优先 =》 栈
     */
public void DFS(Node node){

    if(node == null) return;

    Stack<Node> stack = new Stack<>();
    HashSet<Node> set = new HashSet<>();

    stack.add(node);
    set.add(node);
    System.out.println(node);

    while (!stack.isEmpty()){

        Node curr = stack.pop();
        for (Node elem : curr.nexts) {
            if(!set.contains(elem)){

                //重新压入 curr
                stack.push(curr);

                stack.push(elem);
                set.add(elem);
                System.out.println(node.value);

                // 只处理当前的 相邻节点的 一个元素
                break;

            }
        }
    }
}
```



### 广度优先 BFS

```java
/*
        宽度优先 =》 队列
     */
public void BFS(Node node){

    // 从 node 节点开始宽度优先遍历

    if(node == null) return;

    LinkedList<Node> queue = new LinkedList<>();
    HashSet<Node> set = new HashSet<>(); //去重 保存已处理过的元素

    queue.add(node);
    set.add(node);
    while (!queue.isEmpty()){

        Node curr = queue.poll();

        //处理逻辑
        System.out.println(curr);

        for (Node elem : curr.nexts) {
            if (!set.contains(elem)) {
                queue.add(elem);
                set.add(elem);
            }
        }
    }
}
```



### 拓扑排序

```java
//拓扑排序
public List<Node> sortedTopology(Graph graph){

    // key：某一个节点
    // value：剩余的入度
    HashMap<Node, Integer> inMap = new HashMap<>();

    // 入度为 0 的节点队列
    Queue<Node> zeroInQueue = new LinkedList<>();

    for (Node node : graph.nodes.values()) {
        //遍历所有节点
        inMap.put(node,node.in);
        if(node.in == 0){
            zeroInQueue.add(node);
        }
    }

    //拓扑排序的结果，依次加入 result
    List<Node> result = new LinkedList<>();
    while (!zeroInQueue.isEmpty()){

        Node curr = zeroInQueue.poll();
        result.add(curr);

        //将当前入度为0的节点的直接相邻节点的入度-1
        for (Node elem : curr.nexts) {
            inMap.put(elem,inMap.get(elem)-1);    
            if(inMap.get(elem) == 0){
                zeroInQueue.add(elem);
            }
        }

    }

    return result;

}
```











































































