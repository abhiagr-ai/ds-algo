package graphs.G_Dijkstra;

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 *     All the visited cells of the path are 0.
 *     All the adjacent cells of the path are 8-directionally connected (i.e., they are different, and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.

 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
         +---+---+---+
         | 0 | 0 | 0 |
         +---+---+---+
         | 1 | 1 | 0 |
         +---+---+---+
         | 1 | 1 | 0 |
         +---+---+---+
 * Output: 4

 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
 */

/**
 * there can be 2 solutions
 * 1. using simple BFS, and count layers, since distance is always 1 between nodes, means no wts
 * 2. using Dijkstra, using normal queue [works same time, since distances are equal]
 * 3. using Dijkstra, using priority queue [when moving up, down etc. can have different wts]
 */

public class d_shortest_path_binary_matrix_bfs {
    static void main() {
        // what is given?
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        int n = grid.length;
        int m = grid[0].length;
        // start x,y = 0,0
        // end x,y = n-1, m-1
        // test edge condition that start should not be 1
        // visit start point and update grid with 1
        // push in queue
        // layer counter
        // while q not empty
            // check q size
            // check if are at end node? if yes, return layer+1
            // while(size--)
                // pop start point
                // check where can we visit from here
                // 8 directions we can move
                // push all (x,y) in queue where we can visit, and mark them visited
            // layer+1
    }

    int getDistance(){
        return -1;
    }

}
