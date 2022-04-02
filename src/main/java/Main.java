public class Main {


    public int trap(int[] height) {

        if (height == null) return 0;

        int len = height.length;

        if (len < 3) return 0;

        int LMax = height[0], RMax = height[len - 1];
        int L = 1, R = len - 2;

        int water = 0;

        while (L <= R) {

            if (LMax <= RMax) {
                water += Math.max(0, LMax - height[L]);
                LMax = Math.max(LMax, height[L++]);
            } else {
                water += Math.max(0, RMax - height[R]);
                RMax = Math.max(RMax, height[R--]);
            }

        }

        return water;

    }

}