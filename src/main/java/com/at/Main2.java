package com.at;


import com.at.bean.ListNode;
import com.at.bean.TreeNode;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.corba.se.impl.orbutil.graph.Node;
import com.sun.crypto.provider.HmacPKCS12PBESHA1;
import com.sun.deploy.pings.Pings;
import com.sun.javafx.geom.Edge;
import com.sun.media.sound.RIFFInvalidDataException;
import com.sun.org.apache.bcel.internal.generic.INEG;
import com.sun.org.apache.bcel.internal.generic.IREM;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.ir.ThrowNode;
import sun.java2d.opengl.WGLGraphicsConfig;
import sun.reflect.generics.tree.Tree;
import sun.rmi.transport.proxy.CGIHandler;

import javax.lang.model.element.Element;
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


    }


    public void recoverTree(TreeNode root) {

        inOrder(root);

        TreeNode tmp = t1;
        t1 = t2;
        t2 = tmp;

    }

    TreeNode t1, t2, pre;

    public void inOrder(TreeNode head) {

        if(head == null) return;

        inOrder(head.left);

        if(pre != null && pre.val > head.val){
            if(t1 == null) t1 = pre;
            t2 = head;
        }

        pre = head;


        inOrder(head.right);

    }


}












