package datastructures.graphs.islands;

import java.util.*;


// https://leetcode.com/problems/number-of-distinct-islands/description/
class Solution {

    boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    void dfs(int[][] grid, int i, int j, int n, int m, StringBuilder s, char dir) {
        if (!isValid(i, j, n, m) || grid[i][j] != 1) return;

        grid[i][j] = 0;
        s.append(dir);

        dfs(grid, i, j + 1, n, m, s, 'r');
        dfs(grid, i + 1, j, n, m, s, 'd');
        dfs(grid, i, j - 1, n, m, s, 'l');
        dfs(grid, i - 1, j, n, m, s, 'u');
        s.append("b");


    }

    public int numDistinctIslands(int[][] grid) {
        int i, j, n, m;
        n = grid.length;
        m = grid[0].length;

        Set<String> st = new HashSet<>();
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder s = new StringBuilder();
                    dfs(grid, i, j, n, m, s, 'o');
                    st.add(s.toString());
                }
            }
        }
        return st.size();
    }
}

public class DistinctIslands {
}
