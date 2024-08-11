import java.util.*;

public class Solution {
    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        if (numIslands(grid) != 1) {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (numIslands(grid) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    private int numIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] grid1 = {{0,1,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(sol.minDays(grid1));

        int[][] grid2 = {{1,1}};
        System.out.println(sol.minDays(grid2));
    }
}
