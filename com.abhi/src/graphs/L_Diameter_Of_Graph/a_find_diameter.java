package graphs.L_Diameter_Of_Graph;

import java.util.*;

public class a_find_diameter {

    static void main() {
        //0 -> 1 -> 2 -> 3 -> 4 -> 5
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int V = 6;
        int diameter = getDiameter(edges, V);
        System.out.println(diameter);
    }

    record Pair(int node, int dist){};

    private static int getDiameter(int[][] edges, int V) {
        // build adj
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // start with node 0;
        int start = 3;
        Pair fn = bfs(adj, start);
        System.out.println(fn);
        Pair en = bfs(adj, fn.node);
        // get farthest node from 0 - fn bfs(adj, 0)
        // get farthest node from fn - fn bfs(adj, fn) -> dia
        System.out.println(en);
        return en.dist;
    }

    private static Pair bfs(Map<Integer, List<Integer>> adj, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        boolean[] visited = new boolean[adj.size()];
        int distance = 0;
        int node = start;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int u = q.peek();
                q.poll();
                visited[u] = true;
                for (int v : adj.get(u)) {
                    if (!visited[v]) {
                        q.offer(v);
                        node = v;
                    }
                }
                size --;
            }
            if (!q.isEmpty()){
                distance++;
            }
        }
        return new Pair(node, distance);
    }
}
