package D_Detect_Cycle.a_undirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_DFS_CYCLE_DISCONNECTED {
    static void main() {
        // edge list only, vertices can be different
        int[][] edges = {{0,1},{1,2},{1,3},{2,4},{3,4},{5,6},{6,7},{7,5}};
        int V = 8;
        int cycleCount = dfs_prep(V, edges);
        System.out.println("cycle count "+ cycleCount);
    }

    private static ArrayList<Integer>[] getLists(int V, int[][] edges) {
        ArrayList<Integer>[] al = new ArrayList[V];
        for(int i = 0; i< V; i++){
            al[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            Integer u = edge[0];
            Integer v = edge[1];
            al[u].add(v);
            al[v].add(u);
        }
        return al;
    }

    static int dfs_prep(int V, int[][] edges) {
        ArrayList<Integer>[] al = getLists(V, edges);
        boolean[] visited = new boolean[V];
        int cycleCount = 0;
        for(int j=0; j< V; j++){
            if(!visited[j]) {
                System.out.println("##############################----DFS----- start for j="+j);
                if (dfs(j, visited, al, -1)) {
                    System.out.println("CYCLE DETECTED");
                    cycleCount++;
                }
                System.out.println(Arrays.toString(visited));
            }
        }
        return cycleCount;
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
                return true;
            }
        }
        return false;
    }
}
