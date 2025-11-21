package graphs.E_Topological_Sort;


import graphs.util.GetAdjList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A_DFS_TOPO_SORT {

    static void main() {
        int[][] edges = {{0,1},{1,2},{1,3},{2,4},{3,4}};
        /**         --> 3   -----
         *  0--> 1              \|/
         *          --> 2 ----> 4
         */
        int V = edges.length;
        System.out.println(getSorted(V, edges));
    }

    /*
     * create adjacency list and run dfs,
     * create a stack
     * push items in stack
     * pop items from stack and push into result list
     */

    private static List<Integer> getSorted(int v, int[][] edges) {
        List<Integer>[] adj = GetAdjList.getDirected(edges, v);
        boolean[] visited = new boolean[v];
        Stack<Integer> st = new Stack<>();
        List<Integer> result =new ArrayList<>();
        dfs(adj, st, visited, 0);

        while(!st.empty()){
            result.add(st.pop());
        }

        return result;
    }

    private static void dfs(List<Integer>[] adj, Stack<Integer> st, boolean[] visited, int u) {
        visited[u] = true;
        for (Integer v: adj[u]){
            if(!visited[v]){
                dfs(adj, st, visited, v);
            }
        }
        st.add(u);
    }
}
