import javax.swing.text.html.HTMLWriter;
import java.util.Arrays;

public class Main {

    public int findUnsortedSubarray(int[] nums) {

        int len = nums.length;
        int[] arr = new int[len];

        System.arraycopy(nums,0,arr,0,len);

        Arrays.sort(arr);

        int L = 0,R = len - 1;

        while (L < len && nums[L] == arr[L]) L++;
        while (R >= 0 && nums[R] == arr[R]) R--;


        if(L > R) return 0;

        return R - L + 1;

    }

}