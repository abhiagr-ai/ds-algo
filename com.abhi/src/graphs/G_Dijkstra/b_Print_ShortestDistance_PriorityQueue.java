package graphs.G_Dijkstra;

import java.util.*;

/**
 *                           5
 *                           ↑
 *                           │
 *                           │(1)
 *         (3)         (4)   │
 *     0 ─────→ 1 ─────────→ 3 ─────→ 4
 *     │                     ↑    (2)
 *     │                     │
 * (1) │                 (2) │
 *     │                     │
 *     ↓                     │
 *     2 ────────────────────┘

   0 -> 4 [5, 9]
   0-> 1-> 3-> 4 [9]
   0-> 2-> 3-> 4 [5]
 */

public class b_Print_ShortestDistance_PriorityQueue {
    static void main() {
        int[][] edges = {{0, 1, 3}, {0, 2, 1}, {1, 3, 4}, {2, 3, 2}, {3, 4, 2}, {3,5, 1}};
        int V = 6;

        Map<Integer, List<EdgePair>> adj = new HashMap<>();
        for (int i =0; i <V; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new EdgePair(v, w));
            adj.get(v).add(new EdgePair(u, w));
        }
        int[] parents = getShortestPath(0, adj);
        System.out.println(Arrays.toString(parents));

        // path from 0 to 4  0-> 2-> 3-> 4 [5]
        // [0, 0, 0, 2, 3, 3]
        //  0  1  2  3  4  5
        //  3, 2, 0
        //  value = parent[target]; --> p[4] -> 3/ p[3] -> 2/ p[2] -> 0, p[0] -> 0
        //  result -> add value r[3, 2, 0]
        //  target = value... until target and values are equal t=3, t=2, t=0
        //  Loop -> parent[target] = value
        //  reverse result and add taget

        List<Integer> path = new ArrayList<>(V);

        int target = 4;
        path.add(target);
        while(parents[target] != target){
            path.add(parents[target]);
            target = parents[target];
        }
        System.out.println(path.reversed());
    }

    /**
     * Code Story
     * 1. Create a result array of distances from source = 0
     * ex: distance of 0 from 0, 1, 2 ....5
     * 2. assume all as Integer.max_int
     * @param source
     * @param adj
     * @return
     */
    static int[] getShortestPath(int source, Map<Integer, List<EdgePair>> adj){

        int[] result = new int[adj.size()];
        int[] parent = new int[adj.size()];

        // initialize with max value
        for(int i=0; i < adj.size(); i++){
            result[i]= Integer.MAX_VALUE;
            parent[i] = -1;
        }

        // distance of source to source as 0;
        result[source] = 0;

        // create a priority queue
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        pq.add(new Pair(0,source));
        parent[0] = 0;


        while(!pq.isEmpty()){
            System.out.println(pq + "    result " + Arrays.toString(result));
            Pair p = pq.remove();
            int w = p.weight;
            int u = p.node;

            for(EdgePair pair: adj.get(u)){
                int v_n = pair.node;
                int v_w = pair.weight;
                if(result[v_n] > w+ v_w){
                    result[v_n] = w+ v_w;
                    pq.add(new Pair(w+ v_w, v_n));
                    parent[v_n] = u;
                }
            }
        }
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(parent));
        return parent;
    }

    record Pair(int weight, int node) implements Comparator<Pair>{
        @Override
        public int compare(Pair p1, Pair p2) {
            if(p1.weight == p2.weight){
                return p1.node - p2.node;
            }
            return p1.weight - p2.weight;
        }
    }

    record EdgePair(int node, int weight) implements Comparator<Pair>{
        @Override
        public int compare(Pair p1, Pair p2) {
            if(p1.weight == p2.weight){
                return p1.node - p2.node;
            }
            return p1.weight - p2.weight;
        }
    }
}


