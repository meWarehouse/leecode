package com.at;


import com.at.bean.TreeNode;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.corba.se.impl.orbutil.graph.Node;
import com.sun.crypto.provider.HmacPKCS12PBESHA1;
import com.sun.deploy.pings.Pings;
import com.sun.javafx.geom.Edge;
import sun.reflect.generics.tree.Tree;

import javax.lang.model.element.VariableElement;
import java.nio.channels.Pipe;
import java.util.*;

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

        t1.right = t2;
        t2.left = t3;


    }




}












