package datastructures.graphs;


import java.util.*;

class FindShortestDistanceWeightedBFSandPQSolution {
    boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    public int minFallingPathSum(int[][] matrix) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int i, j, n, m, x, y, z, ans;
        n = matrix.length;
        m = matrix[0].length;
        ans = Integer.MAX_VALUE;

        int[][] dis = new int[n][m];

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) dis[i][j] = Integer.MAX_VALUE;
        }

        for (i = 0; i < m; i++) {
            dis[0][i] = matrix[0][i];
            pq.add(new Integer[]{0, i, matrix[0][i]});
        }

        int[][] dirs = new int[3][2];
        dirs[0] = new int[]{1, 0};
        dirs[1] = new int[]{1, 1};
        dirs[2] = new int[]{1, -1};


        while (!pq.isEmpty()) {
            Integer[] parent = pq.poll();

            if (parent[0] == n - 1) {
                ans = Math.min(ans, parent[2]);
            }

            for (int[] dir: dirs) {
                x = parent[0] + dir[0];
                y = parent[1] + dir[1];
                if (!isValid(x, y, n, m)) continue;

                z = parent[2] + matrix[x][y];
                if (dis[x][y] > z) {
                    pq.add(new Integer[]{x, y, z});
                    dis[x][y] = z;
                }
            }
        }
        return ans;
    }
}

public class FindShortestDistanceWeightedBFSandPQ {
}
