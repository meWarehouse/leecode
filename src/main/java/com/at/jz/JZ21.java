package com.at.jz;

import java.util.Stack;

/**
 * @author zero
 * @create 2021-05-29 17:05
 */
public class JZ21 {

    public boolean IsPopOrder(int[] pushA, int[] popA) {

        Stack<Integer> stack = new Stack<>();

        int j = 0;

        for (int i = 0; i < popA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }

        return stack.empty();
    }

    public boolean IsPopOrder1(int[] pushA, int[] popA) {

        Stack<Integer> stack = new Stack<>();

        int i = 0, j = 0;

        while (i < pushA.length) {

            if (pushA[i] != popA[j]) {
                i++;
            } else {
                i++;
                j++;
                while (!stack.empty() && stack.peek() == popA[j]) {
                    stack.pop();
                    j++;
                }
            }
        }

        return stack.isEmpty();
    }

}
