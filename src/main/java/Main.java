import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[0] - o2[0]));

        while (n-- > 0) {
            String[] param = reader.readLine().split(" ");
            queue.add(new int[]{Integer.parseInt(param[0]), Integer.parseInt(param[1])});
        }


        int sum = 1;
        int R = queue.poll()[1];
        boolean flag = true;

        int index = 0;
        int len = queue.size();

        while (!queue.isEmpty()) {

            int max = queue.poll()[1];
            if (max >= R) {
                flag = true;
                R = max;
            }

            if (flag && index + 1 < len && queue.peek()[0] < R) {
                sum += 1;
                flag = false;
            }
            index++;
        }

        System.out.println(sum);


    }


    public static void m1(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String params = reader.readLine();
        int len = params.length();
        params = params.substring(1, len - 1);


        String[] arr = params.split(",");
        len = arr.length;

        Map<Integer, Integer> map = new HashMap<>(len);
        int sum = 0;

        int i = 0;
        for (; i < arr.length; i++) {

            int m = Integer.parseInt(arr[i]);

            if (m - 5 > sum) break;
            if (i != 0 && map.getOrDefault(5, 0) == 0) break;

            sum += 5;

            map.put(m, map.getOrDefault(m, 0) + 1);
            boolean flag = true;
            int s = m - 5;
            while (s != 0) {


                if (s >= 10) {
                    if (map.getOrDefault(10, 0) > 0) {
                        map.put(10, map.get(10) - 1);
                        s -= 10;
                    }
                } else {

                    if (map.getOrDefault(5, 0) >= (s / 5)) {

                        map.put(5, map.get(5) - (s / 5));
                        s = s - (s / 5) * 5;


                    }

                }

            }


        }

        System.out.println(i == arr.length);


    }

}