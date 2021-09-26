import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //https://www.nowcoder.com/questionTerminal/3f4867e9cbe54403ac5df55b8e678df9

    //https://www.nowcoder.com/test/question/done?tid=48426020&qid=141064#summary



    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n];

        String[] splits = reader.readLine().split(" ");
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            int sum = arr[i], value = arr[i], left = i - 1, right = i + 1;
            while (left >= 0 && arr[left] >= value) {
                sum += arr[left];
                left--;
            }
            while (right < n && arr[right] >= value) {
                sum += arr[right];
                right++;
            }
            max = Math.max(max, value * sum);
        }


        System.out.println(max);


    }


}