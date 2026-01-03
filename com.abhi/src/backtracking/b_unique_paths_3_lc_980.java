package backtracking;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths-iii/
 * You are given an m x n integer array grid where grid[i][j] could be:
 * <p>
 * 1 representing the starting square. There is exactly one starting square.
 * 2 representing the ending square. There is exactly one ending square.
 * 0 representing empty squares we can walk over.
 * -1 representing obstacles that we cannot walk over.
 * <p>
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * ┌────┬────┬────┬────┐
 * │  1 │  0 │  0 │  0 │
 * ├────┼────┼────┼────┤
 * │  0 │  0 │  0 │  0 │
 * ├────┼────┼────┼────┤
 * │  0 │  0 │  2 │ -1 │
 * └────┴────┴────┴────┘
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 */
public class b_unique_paths_3_lc_980 {

    static void main() {
        SolutionUP s = new SolutionUP();
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        int count = s.getUniquePathCount(grid);
        System.out.println(count);
    }
}

class SolutionUP {
    int countNode;
    int resultCount=0;

    int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};

    int getUniquePathCount(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int x = -1;
        int y = -1;

        // find start point
        for(int i=0; i <m; i++){
            for(int j=0; j < n ; j++){
                if(grid[i][j]==1){
                    System.out.println("start at ("+i+","+j+")");
                    x=i;
                    y=j;
                }
            }
        }
        if(x==-1){
            return 0;
        }

        countNode ++;
        // find total node to be covered
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 0) {
                    countNode++;
                }
            }
        }
        System.out.println("total node "+ countNode);

        // start back tracking
        backT(grid, x, y, 0);

        return resultCount;
    }

    void backT(int[][] grid, int x, int y, int count){
        System.out.println(Arrays.deepToString(grid)+", "+x+", "+y+", "+count);
        // valid
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length|| grid[x][y] == -1){
            return;
        }

        // Imp
        if(grid[x][y] ==2){
            if(count == countNode){
                resultCount++;
            }
            return;
        }

        // do
        grid[x][y] = -1;
        // explore
        for(int[] dir : directions){
            // up, down, right, left
            int x_ = dir[0]+x;
            int y_ = dir[1]+y;
            backT(grid,x_, y_, count+1);
        }
        // undo
        grid[x][y] = 0;
    }
}
