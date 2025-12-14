package graphs.H_Bellman_Ford;

import java.util.Arrays;

public class BellmenFord{
    public int[] getShortestDistace(int[][] edges, int V){
        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        for(int i=1; i <= V-1; i++ ){
            relax(edges, result);
        }
    return result;
        /**
         * O[V*E]
         */
    }

    public void relax(int[][] edges, int[] result){
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(result[u] ==Integer.MAX_VALUE){
                continue;
            }
            if(result[u]+w < result[v]){
                result[v] = result[u]+w;
            }
        }
    }
}
