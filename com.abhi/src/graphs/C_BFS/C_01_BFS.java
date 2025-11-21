package graphs.C_BFS;

import java.util.*;

public class C_01_BFS {
    static void main() {
        int[][] edges = {{0,1},{1,2},{1,3},{2,4},{3,4}};
        int V = edges.length;
        bfs_prep(V, edges);
    }

    static void bfs_prep(int V, int[][] edges) {
        // Declare
        List[] al = new ArrayList[V];
        // Init
        for(int i=0; i< V; i++){
            al[i] = new ArrayList<Integer>();
        }
        // prepare
        for(int[] edge: edges){
            Integer u = edge[0];
            Integer v = edge[1];
            al[u].add(v);
            al[v].add(u);
        }
        System.out.println(Arrays.stream(al).toList());
        // [[1], [0, 2, 3], [1, 4], [1, 4], [2, 3]]
        boolean[] visited = new boolean[V];
        System.out.println(Arrays.toString(visited));
        // [false, false, false, false, false]
        int startNode =0;
        bfs(startNode, visited, al);
        //
        System.out.println(Arrays.toString(visited));
    }

    static void bfs(int startNode, boolean[] visited, List<Integer>[] al){
        // visit start node
        visited[startNode] = true;
        System.out.println(Arrays.toString(visited));
        // Create queue
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(startNode);
        while (!q.isEmpty()){
            int node = q.peek();
            q.poll();
            for(Integer neighbour: al[node]){
                if(!visited[neighbour]){
                    q.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
}
