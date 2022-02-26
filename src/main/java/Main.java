import java.util.Arrays;
import java.util.Map;

class Main {

    public static void main(String[] args) {
        int c = '(';

        System.out.println(c);

        System.out.println((char) c);

        new Main().coinChange(new int[]{2},3);


    }

    public int coinChange(int[] coins, int amount) {

        int len = coins.length;

        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1;i <= amount;i++){

            for(int j = 0;j < len;j++){

                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]] + 1);
                }

            }

        }

        if(dp[amount] == Integer.MAX_VALUE) return -1;

        return  dp[amount];


    }


}



