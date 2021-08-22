package com.at.leecode_1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zero
 * @create 2021-06-06 15:36
 */
public class Lru {
}
class LRUCache{

    class DLinkedNode{
        int key;
        int val;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public DLinkedNode() {
        }
    }

    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key,int val){

        DLinkedNode node = cache.get(key);
        if(node == null){
            DLinkedNode newNode = new DLinkedNode(key, val);
            cache.put(key,newNode);
            addToHead(newNode);
            size++;

            if(size > capacity){
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else {
            node.val = val;
            moveToHead(node);
        }

    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(node == null) return -1;

        moveToHead(node);

        return node.val;

    }


    public void addToHead(DLinkedNode node){
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public void removeNode(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    public DLinkedNode removeTail(){
        DLinkedNode pre = tail.pre;
        removeNode(pre);
        return pre;
    }

}

class LRUCache1 extends LinkedHashMap<Integer,Integer> {

    int cap;

    public LRUCache1(int cap) {
        super(cap,0.75F,true);
        this.cap = cap;
    }

    public Integer get(int key){
        return super.getOrDefault(key,-1);
    }

    public void put(int key,int val){
        super.put(key,val);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
        return size() > cap;
    }
}
