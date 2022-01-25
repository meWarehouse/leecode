import com.at.bean.ListNode;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.math.BigInteger;
import java.util.*;

/**
 * @create 2022/1/17 8:54
 */
public class Main {


    List<List<Integer>> res = new ArrayList();
    ArrayList<Integer> list = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) return res;

        for (int n : nums) list.add(n);

        dfs(0);

        return res;

    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


        reverse(list,0+1,3);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
    public static void reverse(List<Integer> list,int s,int e){

        while(s < e){
            int t = list.get(s);
            list.remove(s);

            list.add(s,);
            list.remove(e);
            list.add(e,t);
            s++;
            e--;

        }

    }


    public void dfs(int index) {

        if (index == list.size() - 1) {
            res.add(new ArrayList(list));
            return;
        }

        for (int i = index; i < list.size(); i++) {

            Collections.swap(list, index, i);

            dfs(index + 1);

            Collections.swap(list, index, i);
        }
    }


}
