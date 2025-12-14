package graphs.J_min_spanning_tree;

import java.util.*;

/**
 * provide sum of wt in minimum spanning tree
 *
 *
 >         (10)        (15)
    0 ─────→ 1 ─────────→ 3
    │ ↖               ↗   ↑
    │  ╲ (6)     (4) ╱    │
 (5)│   ╲           ╱     │
    │    ╲         ╱      │
    ↓     ╲       ╱       │
    3 ←────2─────────────┘
 *
 */

public class b_kruskal_algo {

    static void main() {
        Solution s = new Solution();
        // An edge contains, weight, source and destination
        int[][] edges = {
                {0, 1, 10}, {1, 3, 15}, {2, 3, 4}, {2, 0, 6}, {0, 3, 5}
        };
        System.out.println(s.apply_kruskal(edges, 4));
    }

}

class Solution {
    int apply_kruskal(int[][] edges, int V) {
        // O(ELogE)
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));
        System.out.println(Arrays.deepToString(edges));
        DSU dsu = new DSU(V);
        int sum = 0;
        // O(E*4*alpha)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (dsu.find(u) != dsu.find(v)) {
                System.out.println("u, v, w -> " + u + "  "+ v + "  "+ w );
                dsu.union(u, v);
                sum = sum + w;
            }
        }
        return sum;
    }
}

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int V){
        this.parent = new int[V];
        this.rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return x;
    }

    void union(int x, int y) {
        int x_p = find(x);
        int y_p = find(y);
        if (rank[x_p] > rank[y_p]) {
            parent[y_p] = x_p;
        } else if (rank[x_p] < rank[y_p]) {
            parent[x_p] = y_p;
        } else {
            parent[x_p] = y_p;
            rank[y_p]++;
        }
    }
}