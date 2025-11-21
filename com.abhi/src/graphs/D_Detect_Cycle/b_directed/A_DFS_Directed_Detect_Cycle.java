package graphs.D_Detect_Cycle.b_directed;

import graphs.util.GetAdjList;

import java.util.Arrays;
import java.util.List;

public class A_DFS_Directed_Detect_Cycle {
    static void main() {
        // edge list only, vertices can be different
        int[][] edges = {{0, 1}, {2, 1}};
        int V = 3;
        System.out.println("cycle detected? " + dfs_prep(V, edges));
    }

    /**
     *   0 -----> 1 <---- 2
     *    bool[] visited <----- across all dfs calls
     *    bool[] inCurrentRecursion  <---- only covers a single dfs call
     *
     *   0 ---> 1 both are marked true in visited in 1st dfs recursion
     *   but once that dfs is complete, inCurrentRecursion should be false
     *
     *   2 will fall in 2nd recursion call
     */
    static boolean dfs_prep(int v, int[][] edges) {
        List<Integer>[] al = GetAdjList.getDirected(edges, v);
        boolean[] visited = new boolean[v];
        // to check if - visited is in current stack and also already visited
        boolean[] inCurrentRecursion = new boolean[v];

        for (int i = 0; i < v; i++) {
            System.out.println("\n >> i:"+ i +" visited:"+ Arrays.toString(visited) + " inCurrentRecursion:"+ Arrays.toString(inCurrentRecursion));
            if (visited[i]) {
                continue;
            }
            if (dfs(al, visited, inCurrentRecursion, i)) {
                return true;
            }
        }
        return false;
    }

    static boolean dfs(List<Integer>[] al, boolean[] visited, boolean[] inCurrentRecursion, int u) {
        visited[u] = true;
        inCurrentRecursion[u] = true;
        System.out.println("u:"+ u +" visited:"+ Arrays.toString(visited) + " inCurrentRecursion:"+ Arrays.toString(inCurrentRecursion));
        for (Integer neighbour : al[u]) {
            if (visited[neighbour] && inCurrentRecursion[neighbour]) {
                System.out.println("CYCLE FOUND: u:"+ u + " neighbour: "+neighbour+ " visited:"+ Arrays.toString(visited) + " inCurrentRecursion:"+ Arrays.toString(inCurrentRecursion));
                return true;
            }
            // if not visited, then we can call dfs, and if that returns true... it's a cycle
            if (!visited[neighbour] && dfs(al, visited, inCurrentRecursion, neighbour)) {
                System.out.println("CYCLE FOUND: u:"+ u + " neighbour: "+neighbour+ " visited:"+ Arrays.toString(visited) + " inCurrentRecursion:"+ Arrays.toString(inCurrentRecursion));
                return true;
            }
        }
        inCurrentRecursion[u] = false;
        return false;
    }
}
