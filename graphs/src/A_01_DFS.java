import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 14.11
 */
public class A_01_DFS {

    public static void main() {
        dfs_visit(4, List.of(
                List.of(1, 2, 3),  // 0-> 1,2, 3
                List.of(2), // 1 -> 2
                List.of(0, 3),   // 2 -> 0,3
                List.of()       // 3 -> none
        ));
    }

    public static void dfs_visit(int numCourses, List<List<Integer>> prerequisites) {
        // create adjacency list
        Map<Integer, List<Integer>> adj = new HashMap<>();

        int i = 0;
        for (List<Integer> courseCombo : prerequisites) {
            adj.put(i, courseCombo);
            i++;
        }
        // Create a boolean array with all values as false
        boolean[] visited = new boolean[numCourses];
        System.out.println("Graph " + adj);
        System.out.println("visited " + Arrays.toString(visited));

        dfs(adj, 0, visited);
    }


    public static void dfs(Map<Integer, List<Integer>> adj, int visitingNode, boolean[] visited) {

        System.out.println(
                "Visiting Node " + visitingNode +
                        " with visited" + Arrays.toString(visited)
        );

        // if already visited don't visit
        if (visited[visitingNode]) {
            System.out.println(
                    "Already Visited Node " + visitingNode +
                            " skipping DFS for node " + visitingNode
            );
            return;
        } else {
            System.out.println(
                    "Visiting now Node " + visitingNode +
                            " with visited" + Arrays.toString(visited)
            );
            // Visiting node marked as visited
            visited[visitingNode] = true;
            System.out.println(
                    "Just Visited Node " + visitingNode +
                            " with visited" + Arrays.toString(visited)
            );
        }

        // Get list of adjacent nodes
        System.out.println(
                "Get list of adjacent nodes for just visited Node " + visitingNode +
                        " list" + adj.get(visitingNode)
        );
        for (int v : adj.get(visitingNode)) {
            // v -> 1 2
            if (!visited[v]) {
                System.out.println(
                        "now exploring adjacent node  " + v
                );
                dfs(adj, v, visited);
            } else {
                System.out.println(
                        "now exploring adjacent node  " + v + " was already visited, skipping"
                );
            }
        }
    }
}
