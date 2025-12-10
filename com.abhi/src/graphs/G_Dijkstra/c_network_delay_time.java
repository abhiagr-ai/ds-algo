package graphs.G_Dijkstra;

import java.util.*;

/**
 * LC 743
 * You are given a network of n nodes, labeled from 1 to n.
 * You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node,
 * vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * We will send a signal from a given node k.
 * Return the minimum time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 * Example 1:
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2

    [2]----1---->[1]
    |
    |
    1
    |
    [3] ---1----[4]

    ANS: 2-> {MAX,1, 0, 1, 2}
 * Output: 2
 */

record Pair(int l, int r){};
record Distance(int value){};
record Node(int value){};
record PQPair(Distance distance, Node node){};

public class c_network_delay_time {

    static void main() {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int V = 4, source = 2;

        Map<Integer, List<Pair>> adj= new HashMap<>();
        int[] result = new int[V+1];

        for(int k=0; k <= V; k++){
            adj.put(k, new ArrayList<>());
            result[k] = Integer.MAX_VALUE;
        }
        for(int[] edge: times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v,w)); //directed edges
        }
        int[] t =  networkDelayResult(adj, result, source);
        System.out.println(Arrays.toString(t));
        int max = 0;
        for(int p=1; p <= V; p++ ){
            if(t[p]>max){
                max = t[p];
            }
        }

        if(max == Integer.MAX_VALUE){
            max = -1;
        }

        System.out.println("Ans "+ max);
    }

    static int[] networkDelayResult(Map<Integer, List<Pair>> adj, int[] result, int source){
        PriorityQueue<PQPair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance().value()));
        pq.add(new PQPair(new Distance(0), new Node(source)));
        result[source] = 0;
        while(!pq.isEmpty()){
            var pqPair = pq.peek();
            pq.remove();
            int runningDistanceFromSource = pqPair.distance().value();
            int u = pqPair.node().value();

            for(Pair v: adj.get(u) ){
                int node = v.l();
                int dist = v.r();
                if(dist+runningDistanceFromSource < result[node]){
                    result[node] = dist+runningDistanceFromSource;
                    pq.add(new PQPair(new Distance(dist+runningDistanceFromSource), new Node(node)));
                }
            }
        }
        return result;
    }


}
