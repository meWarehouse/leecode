import com.sun.javafx.robot.FXRobotImage;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
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

    List<String> res = new ArrayList<>();
    List<int[]> data = new ArrayList<>();
    int maxLen;

    public List<String> removeInvalidParentheses(String s) {

        int len = s.length();

        int countS = 0, r = 0;
        int cnt = 0;
        for (int i = 0; i < len; i++) {

            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) cnt++;
            else {
                data.add(new int[]{s.charAt(i - 1), cnt});
                cnt = 1;
            }

            if (s.charAt(i) == '(') countS += 1;
            else if (s.charAt(i) == ')') {
                if (countS == 0) r += 1;
                else countS -= 1;
            }

        }

        data.add(new int[]{s.charAt(len - 1), cnt});

        //删除无法元素后剩余的最大长度
        maxLen = len - (countS + r);

        List<int[]> ans = new ArrayList<>();
        dfs(0, 0, 0, ans);

        return res;
    }

    //index 当前遍历到了那段字符串
    private void dfs(int index, int sum, int currLen, List<int[]> ans) {

        if (index == data.size()) {
            if (sum == 0 && currLen == maxLen) {
                res.add(gen(ans));
            }
            return;
        }

        int[] currData = data.get(index);

        //不是 (  )
        if (currData[0] != '(' && currData[0] != ')') {
            if (currLen + currData[1] > maxLen) return;

            ans.add(new int[]{currData[0], currData[1]});

            dfs(index + 1, sum, currLen + currData[1], ans);

            ans.remove(ans.size() - 1);

            return;

        }


        ans.add(new int[]{currData[0], currData[1]});

        for (int i = 0; i <= currData[1]; i++) {
            if (currData[0] == '(') {

                if (currLen + i <= maxLen) {
                    ans.get(index)[1] = i;
                    dfs(index + 1, sum + i, currLen + i, ans);
                }

            } else if (currData[0] == ')') {
                if (sum >= i && currLen + i <= maxLen) {
                    ans.get(index)[1] = i;
                    dfs(index + 1, sum - i, currLen + i, ans);
                }
            }
        }


        ans.remove(ans.size() - 1);

    }

    private String gen(List<int[]> ans) {
        StringBuffer r = new StringBuffer();

        for (int[] ints : ans) {
            for (int i = 0; i < ints[1]; i++) {
                r.append((char) ints[0]);
            }
        }

        return r.toString();
    }

}



