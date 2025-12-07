package graphs.C_BFS;

import java.util.*;

public class bfs_traversal {
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
        bfs(adj, visited, startNode);
        System.out.println(Arrays.toString(visited));
    }

    static void bfs(Map<Integer, List<Integer>> adj, boolean[] visited, int node) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        visited[node] = true;
        while (!q.isEmpty()){
            int u = q.peek();
            q.poll();
            for(int v: adj.get(u)){
                if(!visited[v]){
                    q.offer(v);
                    visited[v] = true;
                }
            }
        }
    }
}
