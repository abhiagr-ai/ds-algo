package recursion;

import java.util.ArrayList;
import java.util.List;

public class h_rate_in_maze {
    static void main() {
        SolutionRIM s = new SolutionRIM();
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        s.explorePath(maze, 0, 0, "");
        System.out.println(s.paths);
    }
}

class SolutionRIM {

    List<String> paths = new ArrayList<>();

    void explorePath(int[][] maze, int x, int y, String path) {
        System.out.println(path);
        // return when path found, insert into result
        if (x < 0 || y < 0 || x >= maze.length || y >= maze.length) {
            return;
        }

        if (maze[x][y] == 0) {
            return;
        }

        if (x == maze.length - 1 && y == maze.length - 1) {
            paths.add(path);
            return;
        }

        // Start from x,y
        // when visiting mark it as 0,
        maze[x][y] = 0;

        // explore paths
        // Left
        explorePath(maze, x, y - 1, path + "L");

        // Right
        explorePath(maze, x, y + 1, path + "R");

        // Up
        explorePath(maze, x - 1, y, path + "U");

        // Down
        explorePath(maze, x + 1, y, path + "D");

        // when backtracking mark it as 1,
        maze[x][y] = 1;
    }
}