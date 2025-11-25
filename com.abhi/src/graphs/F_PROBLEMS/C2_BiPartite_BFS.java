package graphs.F_PROBLEMS;

import java.util.*;

public class C2_BiPartite_BFS {
    static void main() {
        BiBFSPartiteSolution biPartiteSolution = new  BiBFSPartiteSolution();

        // 0 --> 3 1 --> 2
        System.out.println(biPartiteSolution.isBipartite(4, new int[][]{{0, 3}, {1, 2}, {3, 2}, {0, 2}}));
        System.out.println(biPartiteSolution.isBipartite(4, new int[][]{{0, 3}, {1, 2}, {3, 2}, {0, 2}}) ? false : "Not a BiPartite");
    }
}

class BiBFSPartiteSolution{
    boolean isBipartite(int V, int[][] edges){
        List<Integer>[] adj = getAdj(V, edges);
        int[] color = new int[V];
        // color-1 = 1
        // color-0 = 0
        // no color = -1
        Arrays.fill(color, -1);

        for(int i =0; i < V; i++){
            if(color[i]==-1){
                if(!bfs(adj, color, i, 1)){
                    return false;
                };
            }
        }
        return true;
    }

    boolean bfs(List<Integer>[] adj, int[] color, int startNode, int paintColor) {
        Queue<Integer> q = new ArrayDeque<>();
        color[paintColor] = paintColor;
        q.offer(startNode);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (color[v] == color[u]) {
                    return false;
                }
                if (color[v] == -1) {
                    int nextColor = 1 - paintColor;
                    q.offer(v);
                    color[v] = nextColor;
                }
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
