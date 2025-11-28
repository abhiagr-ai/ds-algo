package graphs.F_PROBLEMS.d_dsu;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/
 * LC 2316
 * You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1.
 * You are given a 2D integer array edges where edges[i] = [ai, bi]
 * denotes that there exists an undirected edge connecting nodes ai and bi.
 * <p>
 * Return the number of pairs of different nodes that are unreachable from each other.
 * <p>
 * Input: n = 3, edges = [[0,1],[0,2],[1,2]]
 * Output: 0
 * Explanation: There are no pairs of nodes that are unreachable from each other. Therefore, we return 0.
 * <p>
 * Input: n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
 * Output: 14
 * Explanation: There are 14 pairs of nodes that are unreachable from each other:
 * {{0,1},{0,3},{0,6},{1,2},{1,3},{1,4},{1,5},{2,3},{2,6},{3,4},{3,5},{3,6},{4,6},{5,6}};
 * Therefore, we return 14.
 * <p>
 * <p>
 * 0
 * /  \
 * /    \
 * 2      5
 * \    /
 * \  /
 * 4
 * <p>
 * 1---6
 * <p>
 * 3
 *
 *
 */
public class E_UnReachablePairOfNodes {
    static void main() {
        int V = 7;
        int[][] edges = {{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}};

        Solution s = new Solution();
        System.out.println(s.findUnReachablePairOfNodes(V, edges));
    }

    /**
     * 1. prepare parent vector
     * 2. prepare rank vector
     * 3. iterate through i=0 to V
     * 4. check edges adj, and now when union when edge is given union them
     * 5. after union graph will be built
     * 6. keep a map, which will have key as parent, value as node-count
     * 7. run through formulae of size = nodeCount*(totalRemaining-nodeCount)
     * Component 1: {0, 2, 4, 5} - forms a diamond/cycle shape
     * Component 2: {1, 6} - a simple edge
     * Component 3: {3} - isolated node
     * 0-> 4
     * 1-> 2
     * 3-> 1
     * <p>
     * n0=4*[(4+2+1)-4] = 4*(7-4) = 12
     * n1=2*[(2+1)-2] = 2*(3-1) = 2
     * n3=1*[(1)-1] = 0
     */
    public static class Solution {

        int[] parent;
        int[] rank;

        int findUnReachablePairOfNodes(int V, int[][] edges) {
            parent = new int[V];
            rank = new int[V];
            for (int i = 0; i < V; i++) {
                parent[i] = i; // parent of itself
                rank[i] = 1; // every one has rank =1
            }

            for (int i = 0; i < V; i++) {
                parent[i] = i; // parent of itself
                rank[i] = 1; // every one has rank =1
                for (int[] edge : edges) {
                    int x_parent = find(edge[0]);
                    int y_parent = find(edge[1]);
                    if (x_parent == y_parent) {
                        continue;
                    }
                    union(x_parent, y_parent);
                }
            }

            Map<Integer, Integer> parentNodeCountMap = new HashMap<>();
            for (int i = 0; i < V; i++) {
                int i_parent = parent[i];
                int val = Objects.isNull(parentNodeCountMap.get(i_parent)) ? 1 : parentNodeCountMap.get(i_parent) + 1;
                parentNodeCountMap.put(i_parent, val);
            }

            System.out.println(parentNodeCountMap);
            // sum of all values
            AtomicInteger total = new AtomicInteger();
            parentNodeCountMap.forEach((k, v) -> {
                total.set(total.get() + v);
            });

            System.out.println("total:" + total.get());

            AtomicInteger unreachableNodes = new AtomicInteger();
            AtomicInteger totalRemaining = new AtomicInteger();
            totalRemaining.set(total.get());

            parentNodeCountMap.forEach((k, v) -> {
                int remaining = totalRemaining.get()-v;
                totalRemaining.set(remaining);
                unreachableNodes.set(unreachableNodes.get() + (v * totalRemaining.get()));
            });
            return unreachableNodes.get();
        }

        private int find(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        private void union(int x, int y) {
            System.out.println("Union-----> start x:" + x + " y:" + y + " parent:" + Arrays.toString(parent) + " rank:" + Arrays.toString(rank));
            if (parent[x] == parent[y]) {
                System.out.println("already union: start x:" + x + " y:" + y + " parent:" + Arrays.toString(parent) + " rank:" + Arrays.toString(rank));
                return;
            }

            if (rank[x] > rank[y]) {
                parent[y] = x;
                System.out.println("rank-x > rank-y union: start x:" + x + " y:" + y + " parent:" + Arrays.toString(parent) + " rank:" + Arrays.toString(rank));
            }

            if (rank[x] < rank[y]) {
                parent[x] = y;
                System.out.println("rank-x < rank-y union: start x:" + x + " y:" + y + " parent:" + Arrays.toString(parent) + " rank:" + Arrays.toString(rank));
            }

            if (rank[x] == rank[y]) {
                parent[y] = x;
                rank[x] = rank[x] + 1;
                System.out.println("rank-x == rank-y union: start x:" + x + " y:" + y + " parent:" + Arrays.toString(parent) + " rank:" + Arrays.toString(rank));
            }
        }
    }
}
