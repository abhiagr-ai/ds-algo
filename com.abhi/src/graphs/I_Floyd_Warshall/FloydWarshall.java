package graphs.I_Floyd_Warshall;

/**
 * Multi Source Shortest Path
 * You are given a weighted directed graph,
 * represented by an adjacency matrix, dist[][] of size n x n,
 * where dist[i][j] represents the weight of the edge from node i to node j.
 * If there is no direct edge, dist[i][j] is set to a large value (i.e., 10^8) to represent infinity.
 * The graph may contain negative edge weights, but it does not contain any negative weight cycles.
 *
 * Your task is to find the shortest distance between every pair of nodes i and j in the graph.
 *
 * Note: Modify the distances for every pair in place.
 *
 * Input: dist[][] = [[0, 4, 10^8, 5, 10^8], [10^8, 0, 1, 10^8, 6], [2, 10^8, 0, 3, 10^8], [10^8, 10^8, 1, 0, 2], [1, 10^8, 10^8, 4, 0]]
                     0     1     2      3    4
                  +-----+-----+-----+-----+-----+
            0     |  0  |  4  | ∞   |  5  | ∞   |
                  +-----+-----+-----+-----+-----+
            1     | ∞   |  0  |  1  | ∞   |  6  |
                  +-----+-----+-----+-----+-----+
            2     |  2  | ∞   |  0  |  3  | ∞   |
                  +-----+-----+-----+-----+-----+
            3     | ∞   | ∞   |  1  |  0  |  2  |
                  +-----+-----+-----+-----+-----+
            4     |  1  | ∞   | ∞   |  4  |  0  |
                  +-----+-----+-----+-----+-----+
 *
 *
 * Output: [[0, 4, 5, 5, 7], [3, 0, 1, 4, 6], [2, 6, 0, 3, 5], [3, 7, 1, 0, 2], [1, 5, 5, 4, 0]]
                 +---+---+---+---+---+
                 | 0 | 4 | 5 | 5 | 7 |
                 +---+---+---+---+---+
                 | 3 | 0 | 1 | 4 | 6 |
                 +---+---+---+---+---+
                 | 2 | 6 | 0 | 3 | 5 |
                 +---+---+---+---+---+
                 | 3 | 7 | 1 | 0 | 2 |
                 +---+---+---+---+---+
                 | 1 | 5 | 5 | 4 | 0 |
                 +---+---+---+---+---+
 */

/**
 * 1 to 2 --> 10^8
 * 1 to k to 2 -->
 *
 *
 * 1 to 0 to 2 -->
 * 1 to 1 to 2 -->
 * 1 to 2 to 2 -->
 * 1 to 3 to 2 -->
 * 1 to 4 to 2 -->

 */

public class FloydWarshall {

    void apply(int[][] grid){
        // if there are v vertices for each element in grid
        // grid[i][j] -> grid[i][via] + grid[via][j]
        for(int via =0; via < grid.length; via++){
            for(int i=0; i < grid.length; i++){
                for (int j= 0; j<  grid[0].length; j++){
                    grid[i][j] = Math.min(grid[i][j], grid[i][via] + grid[via][j]);
                }
            }
        }
    }
}
