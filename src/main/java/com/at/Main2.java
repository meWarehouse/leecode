package com.at;


import com.at.bean.TreeNode;
import sun.misc.LRUCache;

import javax.swing.*;
import java.util.*;

/**
 * @author zero
 * @create 2021-07-04
 */
public class Main2 {

    public static void main(String[] args) {



    }



    public boolean isNumber(String s) {

        if(s == null || s.trim().length() == 0) return false;

        byte[] arr = s.trim().getBytes();

        boolean num = false,dot = false,e = false;


        for (int i = 0; i < arr.length; i++) {

            if(arr[i] >= '0' && arr[i] <= '9'){
                num = true;
            }else if(arr[i] == '.'){
                if(dot || e) return false;
                dot = true;
            }else if(arr[i] == 'e' || arr[i] == 'E'){
                if(e || !num) return false;
                e = true;
                num = false;
            }else if(arr[i] == '+' || arr[i] == '-'){
                if(i != 0 && arr[i-1] != 'e' && arr[i-1] != 'E') return false;
            }else return false;


        }

        return num;
    }





}


