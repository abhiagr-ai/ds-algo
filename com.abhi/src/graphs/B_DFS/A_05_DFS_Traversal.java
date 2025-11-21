package graphs.B_DFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 14.11
 */
public class A_05_DFS_Traversal {

    public static void main() {
        // test data
        int noOfVertices = 4;
        int[][] arr = {{1, 2, 3}, {2}, {0, 3}, {}};
        dfs_visit(noOfVertices, arr);
    }

    public static void dfs_visit_ex() {
        // provided number of vertices
        // convert int[][] into adj list
        // need a start node -> start with 0
        // need a visited node array, so that we dont explore further if that node is visited
        // when we visit a node, we need to mark it as visited
        // after marking as visited
        // get list of adjacent nodes
        // explore or dfs again.
        // check if this neighbour is not visited, if visited skip this.
        // if not visited prepare for dfs
        // param:
        // start node will be one of the neighbour in list,
        // updated visited node list
        //
    }

    public static void dfs_visit(int numberOfVertices, int[][] edgeList) {
        // Preparation

        //1.  need a start node -> start with 0
        int startNode = 0;
        //2.  Prepare an adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int i = 0;
        for (int[] list : edgeList) {
            adjList.put(i, Arrays.stream(list).boxed().collect(Collectors.toList()));
            i++;
        }
        //3.  need a visited node array, so that we dont explore further if that node is visited
        boolean[] visited = new boolean[numberOfVertices];

        //4. Start DFS
        dfs(startNode, visited, adjList);
        System.out.println(Arrays.toString(visited));
    }

    private static void dfs(int startNode, boolean[] visited, Map<Integer, List<Integer>> adjList) {
        // check if already visited
        if (visited[startNode]) {
            return;
        }
        // when we visit a node, we need to mark it as visited
        visited[startNode] = true;
        // get list of adjacent nodes
        for (Integer neighbour : adjList.get(startNode)) {
            // check if this neighbour is not visited, if visited skip this.
            if (!visited[neighbour]) {
                // if not visited prepare for dfs
                // param: start node is neighbour, updated visited node list
                dfs(neighbour, visited, adjList);
            }
        }
    }

}
