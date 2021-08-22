package com.at.leecode_1;


public class CN7 {

    //https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec

    public static void main(String[] args) {


    }


    /*
        假设数组的值是[a,b,c,d,e,f]，我们用数组的前一个值减去后一个值，得到的新数组如下
        [b-a,c-b,d-c,e-d,f-e]
        我们在新数组中随便找几个连续的数字相加就会发现一个规律，就是中间的数字都可以约掉，比如新数组中第1个到第4个数字的和是
        b-a+c-b+d-c+e-d=e-a
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) return 0;

        int curr = 0;
        int max = 0;

        for (int i = 1; i < prices.length; i++) {

            curr = Math.max(curr, 0) + prices[i] - prices[i - 1];

            max = Math.max(max, curr);


        }

        return max;


    }




    public int maxProfit2(int[] prices) {
        // write code here

        if (prices == null || prices.length < 2) return 0;

        int buy = prices[0],max = 0;

        for (int i = 1; i < prices.length; i++) {

            buy = Math.min(buy,prices[i]);
            max = Math.max(prices[i] - buy,max);
        }

        return max;

    }

    public int maxProfit1(int[] prices) {
        // write code here
        if (prices == null || prices.length < 2) return 0;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
}
