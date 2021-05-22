package com.at.jz;

import java.util.Stack;

/**
 * @author zero
 * @create 2021-05-16 17:17
 */
public class JZ5 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        stack1.push(node);

    }

    public int pop() {

        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }


        int res = stack2.pop();

        if(stack1.empty()){
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }


        return res;

    }


}
