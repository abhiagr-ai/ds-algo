package graphs.F_PROBLEMS.d_dsu;

import java.util.ArrayList;
import java.util.List;

public class C_CycleDetection {
    static void main() {
        int[][] edges = {{0,1},{1,2},{1,3},{2,4},{3,4},{5,6},{6,7},{7,5}};
        int V = 8;
        boolean isCycle = findCycle(V, getLists(V, edges));
        System.out.println(isCycle);
    }

    static boolean findCycle(int V, List<Integer>[] adj){

        // parent is same as node initially
        int[] parent = new int[V];
        int[] rank = new int[V];
        for(int i =0; i < V; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        for(int u=0; u <V; u++){
            for(int v: adj[u]){
                if(u<v){
                    int u_parent = find(u, parent);
                    int v_parent = find(v, parent);
                    if(u_parent==v_parent){
                        return true;
                    }
                    union(u_parent, v_parent, parent, rank);
                }
            }
        }
    return false;
    }

    static void union(int x, int y, int[] parent, int[] rank){
        //u(0,1)
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        // both part of set, then just return, no need to union, already in union
        if(x_parent == y_parent){
            return;
        }

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }

        if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }

        if(rank[x_parent] == rank[y_parent]){
            parent[x_parent] = y_parent;
            rank[y_parent]= rank[y_parent]+1;
        }
    }

    static int find(int i, int[] parent){
        if(parent[i] == i){
            return i;
        }
        return parent[i]=find(parent[i], parent);
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
}
