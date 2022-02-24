import com.sun.javafx.robot.FXRobotImage;
import com.sun.org.apache.bcel.internal.generic.LUSHR;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) {
        int c = '(';

        System.out.println(c);

        System.out.println((char) c);

        new Main().removeInvalidParentheses("(a)");

    }


    List<int[]> data = new ArrayList<>();
    int maxLen;
    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        int sum = 0, r = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {

            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
                cnt++;
            } else {
                data.add(new int[]{s.charAt(i - 1), cnt});
                cnt = 1;
            }

            if (s.charAt(i) == '(') sum++;
            else if (s.charAt(i) == ')') {
                if (sum == 0) r++;
                else sum--;
            }

        }

        data.add(new int[]{s.charAt(s.length() - 1), cnt});


        maxLen = s.length() - (sum + r);

        List<int[]> ret = new ArrayList<>();

        dfs(0, 0, 0, ret);

        return ans;


    }

    private void dfs(int curr, int sum, int len, List<int[]> ret) {

        if (curr == data.size()) {
            if (sum == 0 && len == maxLen) {
                ans.add(gen(ret));
            }
            return;
        }

        if (data.get(curr)[0] != ')' && data.get(curr)[0] != '(') {
            if (len + data.get(curr)[1] > maxLen) return;

            ret.add(new int[]{data.get(curr)[0], data.get(curr)[1]});

            dfs(curr + 1, sum, len + data.get(curr)[1], ret);

            ret.remove(ret.size() - 1);

            return;

        }

        ret.add(new int[]{data.get(curr)[0], data.get(curr)[1]});
        for (int i = 0; i <= data.get(curr)[1]; i++) {
            if (data.get(curr)[0] == '(') {
                if (len + i <= maxLen) {
                    ret.get(curr)[1] = i;
                    dfs(curr + 1, sum + i, len + i, ret);
                }
            } else {
                if (sum >= i && len + i <= maxLen) {
                    ret.get(curr)[1] = i;
                    dfs(curr + 1, sum - i, len + i, ret);
                }
            }
        }

        ret.remove(ret.size() - 1);

    }

    private String gen(List<int[]> ret) {
        StringBuffer r = new StringBuffer();

        for (int[] ints : ret) {
            for (int i = 0; i < ints[1]; i++) {
                r.append((char) ints[0]);
            }
        }

        return r.toString();
    }
}



