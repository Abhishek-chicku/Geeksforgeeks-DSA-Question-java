import java.util.*;

class Solution {
    private ArrayList<String> ans;

    public ArrayList<String> ratInMaze(int[][] maze) {
        ans = new ArrayList<>();
        int n = maze.length;
        int[][] visited = new int[n][n];

        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return ans;
        }

        dfs(maze, 0, 0, "", visited);
        return ans;
    }

    private void dfs(int[][] maze, int i, int j, String path, int[][] visited) {
        int n = maze.length;
        if (i == n - 1 && j == n - 1) {
            ans.add(path);
            return;
        }
        visited[i][j] = 1;
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};

        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];

            if (isSafe(ni, nj, maze, visited)) {
                dfs(maze, ni, nj, path + dir[k], visited);
            }
        }

        visited[i][j] = 0;
    }

    private boolean isSafe(int i, int j, int[][] maze, int[][] visited) {
        int n = maze.length;
        return (i >= 0 && j >= 0 && i < n && j < n && maze[i][j] == 1 && visited[i][j] == 0);
    }
}
