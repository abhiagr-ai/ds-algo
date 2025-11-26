package graphs.F_PROBLEMS.b_course_schedule;

import java.util.*;

public class B3_COURSE_SCHEDULE_2_BFS_LC_210 {
    static void main() {
        BFS2Solution solution = new BFS2Solution();
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 4}};
        System.out.println(solution.canFinish(5, edges));
    }
}

/**
 * Code Story
 * 1. Directed Graph
 * 2. Using BFS -> Kahn -> [topo sort] -> needs in degree array and queue
 * 3. prepare adj list
 * 4. prepare in degree array
 * 5. push in q when item has indegree 0
 * 6. when pushed, check adj and reduce indegree by 1
 * 7. check if anyone has indegree 0, then push, if no one, then finish
 * 8. as many items pushed in queue = number of vertices -> no cycle
 */
class BFS2Solution {
    public List<Integer> canFinish(int numCourses, int[][] prerequisites) {
        Pair pair = getAdj1(prerequisites, numCourses);
        List<Integer>[] adj = pair.adj;
        int[] indegree = pair.indegree;
        return isCycle(adj, numCourses, indegree);
    }

    List<Integer> isCycle(List<Integer>[] adj, int numCourses, int[] indegree) {
        System.out.println("ADJ " + Arrays.toString(adj));
        System.out.println("INDEGREE " + Arrays.toString(indegree));

        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        int itemsInserted = 0;

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                result.addLast(i);
                itemsInserted++;
            }
        }
        System.out.println("------");
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                    result.addLast(v);
                    itemsInserted++;
                }
            }
        }

        if (itemsInserted != numCourses) {
            return List.of(-1);
        }
        return result;
    }

    Pair getAdj1(int[][] prerequisites, int numCourses) {
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList();
        }
        for (int[] edge : prerequisites) {
            int u = edge[1];
            int v = edge[0];
            adj[u].add(v);
            indegree[v]++;
        }
        return new Pair(adj, indegree);
    }

    record Pair(
            List<Integer>[] adj,
            int[] indegree
    ){

    }

}
