package graphs.G_Dijkstra;

import java.util.*;

/**
 * Leet Code: 1631. Path With Minimum Effort
 * You have travel from 0,0 to r-1, c-1, move 4 dir, and wish to find a route with min effort
 * effort = max diff b./w ht two consecutive cells of the route.

 You are a hiker preparing for an upcoming hike. You are given heights,
 a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col).
 You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed).
 You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

 Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 Output: 2
 Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

 +---+---+---+
 | 1 | 2 | 2 |
 +---+---+---+
 | 3 | 8 | 2 |
 +---+---+---+
 | 5 | 3 | 5 |
 +---+---+---+

 Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
 Output: 1
 Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].

 */

public class e_path_with_minimum_effort {
    public record Triple(Integer wt, Integer x, Integer y){};
    public record Pair(Integer x, Integer y){};

    static void main() {
        /**
         * Code Story
         * grid[x][y] is given
         * we are at 0,0 , and need to move to n-1, m-1
         * move dir or adj list of present node can be calculated from dir array while removing out of bound
         * effort can be calculated by new x_, and y_ chosen, abs(grid[x][y] - grid[x_][y_])
         * since we need to choose path with min effort, we need to use Dijkstra
         * we need grid to store efforts so that we can store min effort values
         * we need PQ to store [effort, (x,y)] to pop and process min effort
         * max(pop_wt, current_wt[from adj])
         * how to mark, visited?
         * return effort_grid[n-1][m-1] when no element left in pq
         */

        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        //int[][] heights = {{1,2,3},{3,8,4},{5,3,5}};
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] grid = new int[rows][cols];
        for(int i =0; i < rows; i++){
            for(int j =0; j< cols; j++){
                grid[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Triple> pq = new PriorityQueue<>(Comparator.comparingInt(t-> t.wt));
        pq.add(new Triple(0, 0, 0));
        grid[0][0] = 0;

        while(!pq.isEmpty()){
            Triple t = pq.peek();
            System.out.println("---------->"+ t);
            pq.poll();

            int wt = t.wt;
            int x  = t.x;
            int y  = t.y;

            // where can we move
            for(Pair pair: validDirections(x,y, rows, cols)){
                int x_ = pair.x;
                int y_ = pair.y;
                int effort = getEffort(heights, x,y, x_, y_);
                if(effort < grid[x_][y_]){
                    grid[x_][y_] = effort;
                    int diff = Math.max(wt, effort);
                    pq.add(new Triple(diff,x_,y_));
                }
            }
        }

        System.out.println(grid[rows-1][cols-1]);
    }


    static List<Pair> validDirections(int x, int y, int row, int cols){
        // up, right, left, down
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        List<Pair> adj = new ArrayList<>();
        for(int[] dir: directions){
            int x_ = x + dir[0];
            int y_ = y + dir[1];
            if(x_ < row && y_ < cols && x_ >= 0 && y_ >= 0 ){
                adj.add(new Pair(x_, y_));
            }
        }
        System.out.println(adj);
        return adj;
    }

    static Integer getEffort(int[][] heights, int x, int y, int x_, int y_){
        return Math.abs(heights[x][y]- heights[x_][y_]);
    }
}
