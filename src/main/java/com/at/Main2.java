package com.at;


import com.at.bean.ListNode;
import com.at.bean.TreeNode;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.corba.se.impl.orbutil.graph.Node;
import com.sun.crypto.provider.HmacPKCS12PBESHA1;
import com.sun.deploy.pings.Pings;
import com.sun.javafx.geom.Edge;
import com.sun.media.sound.RIFFInvalidDataException;
import com.sun.org.apache.regexp.internal.RE;
import sun.java2d.opengl.WGLGraphicsConfig;
import sun.reflect.generics.tree.Tree;
import sun.rmi.transport.proxy.CGIHandler;

import javax.lang.model.element.VariableElement;
import java.awt.*;
import java.nio.channels.Pipe;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.*;
import java.util.List;
import java.util.function.DoublePredicate;

/**
 * @author zero
 * @create 2021-07-04
 */
public class Main2 {

    public static void main(String[] args) {


//        new Main2().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});

        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);

        List<List<Integer>> r = new ArrayList<>();
        r.add(l1);
        r.add(l2);
        r.add(l3);
        r.add(l4);


        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t5.left = t2;
        t5.right = t6;

        t2.left = t1;
        t2.right = t4;

        t1.right = t3;


        char[][] te = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        //"cabefgecdaecf"
        //"cae"

        System.out.println(new Main2().minWindow("DOABECODEBANC", "ABC"));

    }

    //need
    HashMap<Character, Integer> ori = new HashMap<>();
    HashMap<Character, Integer> cnt = new HashMap<>();

    public String minWindow1(String s, String t) {

        int tLen = t.length();

        //need
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;

        int sLen = s.length();

        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }

            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - 1 + 1;
                    ansL = 1;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }

        return ansL == -1 ? "" : s.substring(ansL, ansR);


    }

    private boolean check() {
        Iterator<Map.Entry<Character, Integer>> iterator = ori.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }

        return true;
    }


    public String minWindow(String s, String t) {

        //https://leetcode-cn.com/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/
        //76. 最小覆盖子串

        int sLen = s.length();
        int tlen = t.length();

        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < tlen; i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int needCnt = tlen;


        int I = 0, J = sLen + 1;
        int L = 0, R = 0;

        while (R < sLen) {

            char cR = s.charAt(R);
            if (need.getOrDefault(cR, 0) > 0) {
                needCnt -= 1;
            }
            need.put(cR, need.getOrDefault(cR, 0) - 1);


            if (needCnt == 0) {
                //L -> R 上包含所有 t 上的字符串
                // 从 左 向右收缩
                while (L <= R && need.get(s.charAt(L)) != 0) {
                    char cL = s.charAt(L);
                    need.put(cL, need.get(cL) + 1);
                    L++;
                }

                if (R - L < J - I) {
                    J = R;
                    I = L;
                }

                need.put(s.charAt(L), need.get(s.charAt(L)) + 1);
                needCnt += 1;
                L++;

            }

            R--;
        }

        return J - I > sLen ? "" : s.substring(I, J + 1);


    }


}












