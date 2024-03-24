package backtracking;

import java.util.ArrayList;

public class RatInAMaze {

    public static ArrayList<String> findPath(int[][] arr, int n) {
        if (arr[0][0] == 0) return new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        findAllPossiblePaths(arr, visited, 0, 0, "", n, n, ans);
        return ans;
    }

    public static void findAllPossiblePaths(int[][] maze, boolean[][] visited, int i, int j, String path, int rows, int cols, ArrayList<String> ans) {
        if (i == rows - 1 && j == cols - 1) {
            ans.add(path);
            return;
        }
        // The Directions we are following is D L R U
        // check on down
        if (isValid(i + 1, j, maze, visited, rows, cols)) {
            visited[i + 1][j] = true;
            findAllPossiblePaths(maze, visited, i + 1, j, path + "D", rows, cols, ans);
            visited[i + 1][j] = false;
        }
        // check on left
        if (isValid(i, j - 1, maze, visited, rows, cols)) {
            visited[i][j - 1] = true;
            findAllPossiblePaths(maze, visited, i, j - 1, path + "L", rows, cols, ans);
            visited[i][j - 1] = false;
        }
        // check on right
        if (isValid(i, j + 1, maze, visited, rows, cols)) {
            visited[i][j + 1] = true;
            findAllPossiblePaths(maze, visited, i, j + 1, path + "R", rows, cols, ans);
            visited[i][j + 1] = false;
        }
        // check on up
        if (isValid(i - 1, j, maze, visited, rows, cols)) {
            visited[i - 1][j] = true;
            findAllPossiblePaths(maze, visited, i - 1, j, path + "U", rows, cols, ans);
            visited[i - 1][j] = false;
        }
    }

    private static boolean isValid(int i, int j, int[][] maze, boolean[][] visited, int rows, int cols) {
        boolean isIAndJInBoundary = (i < rows && i >= 0) && (j < cols && j >= 0);
        if (!isIAndJInBoundary) return false;
        boolean isGivenPositionOne = (maze[i][j] == 1);
        boolean notVisited = !visited[i][j];
        return isGivenPositionOne && notVisited;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        int n = maze.length;

        System.out.println("findPath(maze,n) = " + findPath(maze, n));

    }
}
