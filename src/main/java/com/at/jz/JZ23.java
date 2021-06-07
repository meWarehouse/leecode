package com.at.jz;

import java.util.Stack;

/**
 * @author zero
 * @create 2021-06-05 19:39
 */
public class JZ23 {


    public boolean VerifySquenceOfBST(int[] sequence) {

        if (sequence == null || sequence.length < 1) return false;

        Stack<Integer> stack = new Stack<>();

        stack.push(Integer.MIN_VALUE);
        int max = Integer.MAX_VALUE;

        for (int i = sequence.length - 1; i >= 0; i--) {

            if (sequence[i] > max) return false;

            while (sequence[i] < stack.peek()) {
                max = stack.pop();
            }

            stack.push(sequence[i]);

        }


        return true;


    }

    public boolean VerifySquenceOfBST1(int[] sequence) {

        if (sequence == null || sequence.length < 1) return false;


        return isBST(sequence, 0, sequence.length - 1);


    }


    public static boolean isBST(int[] sequence, int start, int root) {

        if (start >= root) return true;

        int key = sequence[root];
        int i;

        for (i = start; i < root; i++) {
            if (sequence[i] > key) {
                break;
            }
        }

        for (int j = i; j < root; j++) {
            if (sequence[j] < key) return false;
        }

        return isBST(sequence, start, i - 1) && isBST(sequence, i, root - 1);


    }

}
