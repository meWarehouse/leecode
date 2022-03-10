import sun.misc.FpUtils;

import java.net.Inet4Address;
import java.nio.ByteBuffer;
import java.util.*;

public class Main {

    public static void main(String[] args) {


        new Main().canPartition(new int[]{1,5,11,5});

    }


    public boolean canPartition(int[] nums) {

        int len = nums.length;

        if(len < 2) return false;

        int sum = 0,max = 0;

        for(int x : nums){
            Math.max(x,max);
            sum+=x;
        }

        if(sum % 2 == 1) return false;

        int t = sum / 2;

        if(t < max) return false;

        boolean[] dp = new boolean[t+1];
        dp[0] = true;


        for (int i = 0; i < len; i++) {
            int x = nums[i];
            for (int j = t; j >= x; j--) {
                dp[j] = j - x >=0 ? dp[j] | dp[j-x] : dp[j];
            }
        }

        return dp[t];




    }


}