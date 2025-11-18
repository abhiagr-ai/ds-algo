package D_Detect_Cycle.undirected;

import java.util.ArrayList;
import java.util.List;

public class UndirectedDetectCycle {

    static void main() {

    }

    boolean isCycle(int V, int[][] edges){
        // convert the edge pair to adj list

        // visited, set all false
        boolean[] visited = new boolean[V];
        ArrayList[] adj = new ArrayList[V];

        // iterate thru all nodes
        for(int i=0; i< V; i++){
            if(!visited[i] && isCycleDFS(adj, i, visited, -1)){
                return true;
            }
        }
        return false;
    }

    boolean isCycleDFS(List<Integer>[] adj, int source, boolean[] visited, int parent){
        return true;
    }

}
