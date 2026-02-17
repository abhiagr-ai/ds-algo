package array.A;

/*
      https://www.youtube.com/watch?v=dMn6NPk9nPw
      https://leetcode.com/problems/number-of-closed-islands/
*/
/**

 +---+---+---+---+
 | 0 | 0 | 0 | 0 |
 +---+---+---+---+
 | 1 | 0 | 1 | 0 |
 +---+---+---+---+
 | 0 | 1 | 1 | 0 |
 +---+---+---+---+
 | 0 | 0 | 0 | 0 |
 +---+---+---+---+

 □ □ □ □
 ■ □ ■ □
 □ ■ ■ □
 □ □ □ □

 *
 *
 *  Given a 2D grid consists of 0s (land) and 1s (water).
 *  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 *  Return the number of closed islands.
 *  Input: grid =  {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
 *  Output: 1
 *
 *
 */


import java.util.List;

/**
 * https://leetcode.com/problems/number-of-enclaves/
 * https://www.youtube.com/watch?v=dYOm367BdbM
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
 * Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 *
 * Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
 */
public class E_Number_Of_Enclaves {

    static void main() {
        int[][] input =  {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        int numberOfCloseIslands = numberOfCloseIslands(input);
        int numberOfEnclaves = numberOfEnclaves(input);
        System.out.println("numberOfCloseIslands"+numberOfCloseIslands);
        System.out.println("numberOfEnclaves"+numberOfEnclaves);
    }

    record Pair(int x, int y){};

    private List<Pair> getDirs(Pair xy){
        return List.of(new Pair(xy.x+1, xy.y), new Pair(xy.x, xy.y+1));
    }

    private static

    private static int numberOfCloseIslands(int[][] input) {
        // 1 land
        // 0 water
        // start at 0,0 and dfs , if not visited, loop, and count number of dfs's

        return 0;
    }

    private static int numberOfEnclaves(int[][] input) {
        // 1 land
        // 0 water
        // start at boundary [first-col, last-col, first-row, last-row], dfs, mark all visited,
        // iterate and count num of 1's
        //
        return 0;
    }
}
