package com.at.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2021-08-21
 */
public class lc_22 {


    /*

    22. 括号生成
        https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/

        当前左右括号都有大于 00 个可以使用的时候，才产生分支；
        产生左分支的时候，只看当前是否还有左括号可以使用；
        产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支；
        在左边和右边剩余的括号数都等于 00 的时候结算。



     */

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        if (n < 1) return res;

        dfs("",n,n);

        return res;

    }

    public void dfs(String currStr, int left, int right) {

        if (left == 0 && right == 0) {
            res.add(currStr);
            return;
        }

        // 左 （ 剩余的数量 一定是严格意义上大于 ） 剩余数量
        if (left > right) return;

        if (left > 0) dfs(currStr + "(", left - 1, right);

        if (right > 0) dfs(currStr + ")", left, right - 1);


    }

}
