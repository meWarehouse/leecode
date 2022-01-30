import com.at.bean.ListNode;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @create 2022/1/17 8:54
 */
public class Main {

    public static void main(String[] args) {
        final int[] ints = {1, 2};
        final int[] int2 = {3, 4};
        new Main().findMedianSortedArrays(ints, int2);
    }
    public String convert(String s, int numRows) {

        if(s == null || s.length() == 0 ||numRows < 2) return s;

        List<StringBuffer> resList = new ArrayList();
        for(int i = 0; i < numRows;i++) resList.get(i) = new StringBuffer();

        int index = 0, row = 0,flag = -1,len = s.length();

        while(index < 0){
            char c = s.charAt(index);

            resList.get(row).append(c);

            if(row == 0 || row == numRows - 1) flag = -flag;
            row+=flag;

            index++;

        }

        StringBuffer res = new StringBuffer();
        for(StringBuffer s : resList) res.append(s);

        return res.toString();
    }

}
