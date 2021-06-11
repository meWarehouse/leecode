package com.at.jz;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author zero
 * @create 2021-06-09 23:17
 */
public class JZ27 {
    ArrayList<String> res = new ArrayList<>();
    char[] c;

    public ArrayList<String> Permutation(String str) {

        c = str.toCharArray();
        //从第一层开始递归
        dfs(0);
        //将字符串数组ArrayList转化为String类型数组

        return res;


    }

    public void dfs(int x){
        if(x == c.length-1){
            res.add(String.valueOf(c));
            return;
        }

        HashSet<Character> set = new HashSet<>();

        for (int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue;

            set.add(c[i]);

            swap(i,x);

            dfs(x+1);

            swap(i,x);

        }

    }

    private void swap(int i, int x) {
        char temp = c[i];
        c[i] = c[x];
        c[x] = temp;
    }
}
