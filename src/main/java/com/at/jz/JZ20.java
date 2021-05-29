package com.at.jz;

import java.util.Stack;

/**
 * @author zero
 * @create 2021-05-27 21:53
 */
public class JZ20 {

    public Stack<Integer> stack = new Stack();

    public void push(int node) {

        if(stack.isEmpty()){
            stack.add(node);
        }else {

//            int top = top();
//            if(node > top){
//                pop();
//                stack.add(node);
//                stack.add(top);
//            }else {
//                stack.add(node);
//            }

            int top = top();
            if(node < top){
                stack.push(node);
            }else{
                stack.push(top);
            }


        }

    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
//        return top();
        return stack.pop();
    }


}
