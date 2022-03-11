import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) {



    }

    public int subarraySum(int[] nums, int k) {

        int len = nums.length;

        //前缀和
        int[] dp = new int[len +1];

        for (int i =  1; i <= len ; i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }

        int ret = 0;

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = len; i >=0 ; i--) {


            map.put(dp[i],map.getOrDefault(dp[i],0) + 1);

            int t = dp[i-1] + k;

            if(map.containsKey(t))
                ret+=map.get(t);

        }



        return ret;


    }

    public int subarraySum(int[] nums, int k) {

        int len = nums.length;

        int p[] = new int[len+1];

        for(int i = 1; i <= len;i++) p[i] = p[i-1] + nums[i-1];

        int ans = 0;

        Map<Integer,Integer> map = new HashMap();

        for(int i = len;i > 0;i++){
            map.put(p[i],map.getOrDefault(p[i],0) + 1);

            int t = p[i - 1]  + k;

            if(map.containsKey(t)) ans+=map.get(t);

        }

        return ans;


    }


}