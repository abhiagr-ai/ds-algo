package graphs.util;

import java.util.ArrayList;

public final class GetAdjList {
    public static ArrayList<Integer>[] get(int[][] edges, int V){
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

    public static ArrayList<Integer>[] getDirected(int[][] edges, int V){
        ArrayList<Integer>[] al = new ArrayList[V];
        for(int i = 0; i< V; i++){
            al[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            int u = edge[0];
            Integer v = edge[1];
            al[u].add(v);
        }
        return al;
    }
}
