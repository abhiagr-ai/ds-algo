package util;

import java.util.ArrayList;
import java.util.List;

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
}
