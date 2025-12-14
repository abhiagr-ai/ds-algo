package graphs.H_Bellman_Ford;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Shortest Distance from source from all vertices
 * Difference:
 * 1. Relax V-1 times all edges
 * 2. works with negative wts
 * 3. works with directed

        (5)         (1)
    0 ─────→ 1 ─────────→ 2
             │             │
             │ (2)     (1) │
             ↓             ↓
             3 ←─────────── 4
                  (-1)

 */
public class a_Bellmen_Ford {
    static void main() throws Exception {
        int V = 5;
        int[][] edges = {{0, 1, 5}, {1, 2, 1}, {1, 3, 2}, {2, 4, 1}, {4, 3, -1}};
        int[] expected= {0, 5, 6, 6, 7};
        if(!Arrays.equals(test(edges, V), expected)){
            throw new Exception("failed");
        } else {
            System.out.println("pass");
        }

        int V2 = 4;
        int[][] edges2 = {{0, 1, 4}, {1, 2, -6}, {2, 3, 5}, {3, 1, -2}};
        int[] expected2= {-1};
        if(!Arrays.equals(test(edges2, V2), expected2)){
            throw new Exception("failed");
        } else {
            System.out.println("pass");
        }
    }

    static int[] test(int[][] edges, int V){
        BellmenFord s = new BellmenFord();
        int[] result = s.getShortestDistace(edges, V);
        int[] result2 = Arrays.copyOf(result, result.length);
        // check if it has negative cycle
        BellmenFord s2 = new BellmenFord();
        s2.relax(edges, result2);
        return Arrays.equals(result2, result) ? result : new int[]{-1};
    }

}



