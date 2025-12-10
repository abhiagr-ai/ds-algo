package graphs.D_Detect_Cycle.a_undirected;

import java.util.*;

public class dfs_cycle {
    static void main() {
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 4}};

        /**
         *     0
         *     |
         *     1
         *    / \
         *   2   3
         *    \ /
         *     4
         */

        int V = edges.length;

        // ADJ List
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            // unordered
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(isCycle(adj, V));
    }

    static boolean isCycle(Map<Integer, List<Integer>> adj, int V){
        boolean[] visited = new boolean[V];
        for(int i =0; i< V; i++){
            if(!visited[i] && dfs(adj, visited, i, -1)){
                return true;
            }
        }
        return false;
    }

    static boolean dfs(Map<Integer, List<Integer>> adj, boolean[] visited, int u, int parent) {
        visited[u] = true;
        for(int v: adj.get(u)){
            // do not visit parent
            if( v == parent){//
                continue;
            }
            // when not parent and visited then cycle
            if(visited[v]){
                return true;
            }
            // dfs returns cycle -> return true??
            if(dfs(adj, visited, v, u)){
                return true;
            }
        }
        return false;
    }
}
