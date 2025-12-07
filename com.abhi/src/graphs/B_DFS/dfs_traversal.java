package graphs.B_DFS;

import java.util.*;

public class dfs_traversal {
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

        // traversal
        boolean[] visited = new boolean[V];
        System.out.println(Arrays.toString(visited));
        int startNode = 0;
        dfs(adj, visited, startNode);
        System.out.println(Arrays.toString(visited));
    }

    static void dfs(Map<Integer, List<Integer>> adj, boolean[] visited, int u) {
        if(visited[u]){
            return;
        }
        visited[u] = true;
        for(int v: adj.get(u)){
            if(!visited[v]){
                dfs(adj, visited, v);
            }
        }
    }
}
