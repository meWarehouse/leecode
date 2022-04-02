import java.util.PriorityQueue;

public class Main {


    public int trapRainWater(int[][] heightMap) {

        if (heightMap == null) return 0;

        int x = heightMap.length, y = heightMap[0].length;

        if (x < 3 || y < 3) return 0;

        boolean[][] isEnter = new boolean[x][y];
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.col);

        for (int i = 0; i < y; i++) {
            if (!isEnter[0][i]) {
                queue.add(new Node(heightMap[0][i], 0, i));
                isEnter[0][i] = true;
            }
            if (!isEnter[x - 1][i]) {
                queue.add(new Node(heightMap[x - 1][i], x - 1, i));
                isEnter[x - 1][i] = true;
            }
        }


        for (int i = 0; i < x; i++) {
            if (!isEnter[i][0]) {
                queue.add(new Node(heightMap[i][0], i, 0));
                isEnter[i][0] = true;
            }
            if (!isEnter[i][y - 1]) {
                queue.add(new Node(heightMap[i][y - 1], i, y - 1));
            }
        }


        int water = 0, max = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            max = Math.max(max, node.val);
            int row = node.row, col = node.col;

            //上
            if (row - 1 >= 0 && !isEnter[row - 1][col]) {
                water += Math.max(0, max - heightMap[row - 1][col]);
                isEnter[row - 1][col] = true;
                queue.add(new Node(heightMap[row - 1][col], row - 1, col));
            }
            // 下
            if (row + 1 < x && !isEnter[row + 1][col]) {
                water += Math.max(0, max - heightMap[row + 1][col]);
                isEnter[row + 1][col] = true;
                queue.add(new Node(heightMap[row + 1][col], row + 1, col));
            }
            // 左
            if (col - 1 >= 0 && !isEnter[row][col - 1]) {
                water += Math.max(0, max - heightMap[row][col - 1]);
                isEnter[row][col - 1] = true;
                queue.add(new Node(heightMap[row][col - 1], row, col - 1));
            }
            // 右
            if (col + 1 < y && !isEnter[row][col + 1]) {
                water += Math.max(0, heightMap[row][col + 1])
                isEnter[row][col + 1] = true;
                queue.add(new Node(heightMap[row][col + 1], row, col + 1));
            }

        }


        return water;

    }


    class Node {
        int val, row, col;

        public Node(int v, int r, int c) {
            this.val = v;
            this.row = r;
            this.col = c;
        }
    }

}

