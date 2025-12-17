package graphs.J_min_spanning_tree;

/**
 * p1 --w1--->
 * [to_node]
 * p2 --w2--->
 * <p>
 * structure we have ---
 * {w1, to_node, parent1}
 * {w2, to_node, parent1}
 * <p>
 * what we need to choose?
 * when w1 < w2
 * <p>
 * so we can choose min heap to keep w1 above w2
 * so for initial source, we can push wt=0, for start node =0, to come from -1
 * {0, 0, -1}
 * <p>
 * to Keep track of visited, using visited array, so that we can skip larger wt
 * to Keep track of path, so that we can use parent array
 *
 */

import java.util.*;

/**

 */
public class a_prims_algo_mst {
    static void main() {
        int[][] edges = {
                {0, 1, 10}, {1, 3, 15}, {2, 3, 4}, {2, 0, 6}, {0, 3, 5}
        };
        int V = 4;
        Prims k = new Prims();
        System.out.println(k.execute(edges, V));
    }
}

record Pair(int v, int w) {
};

class Prims {
    int execute(int[][] edges, int V) {
        // prepare adj
        Map<Integer, ArrayList<Pair>> adj = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        System.out.println(adj);
        // 0=[Pair[v=1, w=10], Pair[v=2, w=6], Pair[v=3, w=5]],
        // 1=[Pair[v=0, w=10], Pair[v=3, w=15]],
        // 2=[Pair[v=3, w=4], Pair[v=0, w=6]],
        // 3=[Pair[v=1, w=15], Pair[v=2, w=4], Pair[v=0, w=5]]

        boolean[] visited = new boolean[V];
        int[] parent = new int[V];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[0]));
        // Start insert into pq
        int w = 0;
        int p = -1;
        int n = 0;
        int[] element = new int[]{w, n, p};
        pq.add(element);
        int wt_sum = 0;
        while (!pq.isEmpty()) {
            System.out.println("> " + Arrays.toString(Arrays.stream(pq.peek()).toArray()));

            int[] e = pq.peek();
            int wi = e[0];
            int ni = e[1];
            int pi = e[2];
            pq.poll();

            if (visited[ni]) {
                continue;
            }

            wt_sum = wt_sum + wi;
            parent[ni] = pi;
            visited[ni] = true;
            for (Pair pair : adj.get(ni)) {
                int v = pair.v();
                int wt = pair.w();
                if (!visited[v]) {
                    pq.add(new int[]{wt, v, ni});
                }
            }
        }
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(visited));
        return wt_sum;
    }
}


