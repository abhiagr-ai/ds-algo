package graphs.D_Detect_Cycle.b_directed;

import java.util.*;

public class dfs_cycle_undirected {
    static void main() {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {3, 0}};
        /**
         *
         * 0 → 1 → 2
         * ↑   ↓   ↓
         * └── 3 ←─┘

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
            // ordered
            adj.get(u).add(v);
        }
        System.out.println(isCycle(adj, V));
    }

    static boolean isCycle(Map<Integer, List<Integer>> adj, int V){
        boolean[] visited = new boolean[V];
        boolean[] cr = new boolean[V]; // current recursion
        for(int i =0; i< V; i++){
            if(!visited[i] && dfs(adj, visited, i, cr)){
                return true;
            }
        }
        return false;
    }

    static boolean dfs(Map<Integer, List<Integer>> adj, boolean[] visited, int u, boolean[] cr) {
        visited[u]=true;
        cr[u] = true;
        for(int v: adj.get(u)){
            if(!visited[v] && dfs(adj,visited, v, cr)){
                return true;
            }
            if(visited[v] && cr[v]){
                return true;
            }
        }
        cr[u] = false;
        return false;
    }
}
