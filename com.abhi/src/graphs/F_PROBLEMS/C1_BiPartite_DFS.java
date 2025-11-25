package graphs.F_PROBLEMS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1_BiPartite_DFS {
    static void main() {
        BiDFSPartiteSolution biPartiteSolution = new  BiDFSPartiteSolution();

        // 0 --> 3 1 --> 2
        System.out.println(biPartiteSolution.isBipartite(4, new int[][]{{0, 3}, {1, 2}, {3, 2}, {0, 2}}));
        System.out.println(biPartiteSolution.isBipartite(4, new int[][]{{0, 3}, {1, 2}, {3, 2}, {0, 2}}) ? false : "Not a BiPartite");
    }
}

class BiDFSPartiteSolution{
    boolean isBipartite(int V, int[][] edges){
        List<Integer>[] adj = getAdj(V, edges);
        int[] color = new int[V];
        // color-1 = 1
        // color-0 = 0
        // no color = -1
        Arrays.fill(color, -1);

        for(int i =0; i < V; i++){
            if(color[i]==-1){
                if(!dfs(adj, color, i, 1)){
                    return false;
                };
            }
        }
        return true;
    }

    boolean dfs(List<Integer>[] adj, int[] color, int u, int paintColor){
        color[u] = paintColor;

        for(int v: adj[u]){
            if(color[v] == paintColor){
                return false;
            }
            if(color[v] == -1){
                int nextColor = 1 - paintColor;
                if(!dfs(adj, color, v, nextColor)){
                    return false;
                };
            }
        }
        return true;
    }

    List<Integer>[] getAdj(int V, int[][] edges){
        List<Integer>[] adj = new ArrayList[V];
        for(int i =0; i < V; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            // undirected
            adj[u].add(v);
            adj[v].add(u);
        }
        return adj;
    }
}

