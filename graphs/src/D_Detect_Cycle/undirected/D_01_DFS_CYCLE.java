package D_Detect_Cycle.undirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_01_DFS_CYCLE {
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
        if(dfs(startNode, visited, al, -1)){
            System.out.println("CYCLE DETECTED");
        };
        //
        System.out.println(Arrays.toString(visited));
    }

    static boolean dfs(int startNode, boolean[] visited, List<Integer>[] al, int parent){
        System.out.println("-----dfs: startNode:"+startNode+ " visited"+ Arrays.toString(visited) + " parent:"+ parent);
        visited[startNode] = true;
        System.out.println("visited: "+ startNode);
        for(Integer neighbour: al[startNode]){
            System.out.println("al of node: "+ startNode +" is " + al[startNode] + " child: "+ neighbour + " parent " + parent);
            // make sure not to visit parent
            if(parent == neighbour){
                System.out.println("skipped visiting parent: "+ parent + " from "+ startNode);
                continue;
            }
            if(visited[neighbour]){
                System.out.println("return true: neighbour: "+ neighbour + " is already visited .. cycle detected");
                return true;
            }
            // visiting non parent node
            if(dfs(neighbour, visited, al, startNode)){
                System.out.println("it has cycle------");
                return true;
            }
        }
        return false;
    }
}
