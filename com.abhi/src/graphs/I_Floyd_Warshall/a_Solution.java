package graphs.I_Floyd_Warshall;

import java.util.Arrays;

public class a_Solution {
    static void main() {

        int[][] dist = {
                {0, 4, 10000, 5, 10000},
                {10000, 0, 1, 10000, 6},
                {2, 10000, 0, 3, 10000},
                {10000, 10000, 1, 0, 2},
                {1, 10000, 10000, 4, 0}
        };

        //expected_ Output: [[0, 4, 5, 5, 7], [3, 0, 1, 4, 6], [2, 6, 0, 3, 5], [3, 7, 1, 0, 2], [1, 5, 5, 4, 0]]

        FloydWarshall f = new FloydWarshall();
        f.apply(dist);
        System.out.println(Arrays.deepToString(dist));
    }
}
