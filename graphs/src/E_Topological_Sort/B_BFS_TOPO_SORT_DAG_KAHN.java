package E_Topological_Sort;

import util.GetAdjList;

import java.util.*;

/**
 * topo sort can be performed in Directed Acyclic graph only
 * how BFS can be performed in dag is using KAHN Algorithm
 * Kahn algo: create indegree queue, and only push item which has indegree 0
 * additionally this algo can be sed to find cycle in a graph using bfs
 * -> when items pushed in queue == total V --> No Cycle
 */
public class B_BFS_TOPO_SORT_DAG_KAHN {
    static void main() {
        int[][] edges = {{0,1},{1,2},{1,3},{2,4},{3,4}};
        /*          --> 3   -----
         *  0--> 1              \|/
         *          --> 2 ----> 4
         */
        int V = edges.length;
        System.out.println(getSortedUsingKahn(V, edges));
    }

    /**
     * Create adj
     * Create indegree array
     */
    private static List<Integer> getSortedUsingKahn(int V, int[][] edges) {
        List<Integer>[] adj = GetAdjList.getDirected(edges, V);
        // 0 -> 1
        // 1 -> 3,2
        // 2 -> 4
        // 3 -> 4
        // 4 ->
        int[] indegree = new int[V];

        for(int k=0; k < V; k++){
            for(int v: adj[k]){
                // when k=0 -> v == 1 [0,1,0,0,0]
                // when k=1, v == 3 [0,1,0,1,0]
                // when k=1, v == 2 [0,1,1,1,0]
                // when k=2, v == 4 [0,1,1,1,1]
                // when k=3, v == 4 [0,1,1,1,2]
                // when k=4, v == none [0,1,1,1,2]
                indegree[v]++;
            }
        }
        System.out.println("indegree" + Arrays.toString(indegree));
        return bfs(adj, indegree);
    }

    /*
     * Create zero-indegree-queue
     * Create a result list
     * push item in zero-indegree-queue, by iterating indegree-array with item in-degree as 0
     * when any item is pushed in zero-indegree-queue, reduce in-degree by 1
     * when item is polled from queue, push that into result array
     */
    private static List<Integer> bfs(List<Integer>[] adj, int[] indegree) {
        Queue<Integer> zeroIndegreeQueue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        // Fill Queue
        int count = 0;
        for(int k: indegree){
            if(indegree[k]==0){
                count++;
                zeroIndegreeQueue.offer(k);
            }
        }

        // bfs
        while(!zeroIndegreeQueue.isEmpty()){
            int z = zeroIndegreeQueue.peek();
            zeroIndegreeQueue.poll();
            result.add(z);
            for(int v : adj[z]){
                indegree[v]--;
                if(indegree[v]==0){
                    zeroIndegreeQueue.offer(v);
                    count++;
                }
            }
        }
        return result;
    }
}
