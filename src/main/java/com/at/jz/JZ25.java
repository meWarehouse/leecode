package jz;

/**
 * @author zero
 * @create 2021-06-05 21:36
 */
public class JZ25 {

    public RandomListNode Clone(RandomListNode pHead) {

        if(pHead == null) return null;

        RandomListNode currNode = pHead;

        //复制
        while (currNode != null){
            RandomListNode cloneNode = new RandomListNode(currNode.label);
            cloneNode.next = currNode.next;
            currNode.next = cloneNode;

            currNode = cloneNode.next;
        }

        //建立 random 指针
        currNode = pHead;
        while (currNode != null){
            currNode.next.random = currNode.random==null?null:currNode.random.next;
            currNode = currNode.next.next;
        }

        //拆分
        currNode = pHead;
        RandomListNode pCloneH = pHead.next;

        while (currNode != null){

            RandomListNode clone = currNode.next;
            currNode.next = clone.next;

            clone.next = clone.next==null?null:clone.next.next;

            currNode = currNode.next;

        }

        return pCloneH;

    }

}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
