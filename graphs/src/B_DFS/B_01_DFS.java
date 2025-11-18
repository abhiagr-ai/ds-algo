package B_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_01_DFS {
    static void main() {
        int[][] edges = {{0,1},{1,2},{1,3},{2,4},{3,4}};
        int V = edges.length;
        dfs_prep(V, edges);
    }

    static void dfs_prep(int V, int[][] edges) {
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
        dfs(startNode, visited, al);
        //
        System.out.println(Arrays.toString(visited));
    }

    static void dfs(int startNode, boolean[] visited, List<Integer>[] al){
        if(visited[startNode]){
            return;
        }
        visited[startNode] = true;
        for(Integer neighbour: al[startNode]){
            if(!visited[neighbour]){
                dfs(neighbour, visited, al);
            }
        }
    }
}
