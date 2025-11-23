package graphs.F_PROBLEMS;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/course-schedule/description/">...</a>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi]
 * indicates that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 */
public class D_COURSE_SCHEDULE_BFS_LC_207 {
    static void main() {
        BFSSolution solution = new BFSSolution();
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 4}};
        if (solution.canFinish(5, edges)) {
            System.out.println("test success");
        }
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
class BFSSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = getAdj(prerequisites, numCourses);
        return !isCycle(adj, numCourses);
    }

    boolean isCycle(List<Integer>[] adj, int numCourses) {
        int[] indegree = new int[numCourses];
        int count = 0;
        for (List<Integer> list : adj) {
            indegree[count] = list.size();
            count++;
        }
        System.out.println(Arrays.toString(adj));
        System.out.println(Arrays.toString(indegree));
        Queue<Integer> q = new ArrayDeque<>();
        int itemsInserted = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                itemsInserted++;
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                    itemsInserted++;
                }
            }
        }
        return itemsInserted==numCourses;
}

List<Integer>[] getAdj(int[][] prerequisites, int numCourses) {
    List<Integer>[] adj = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; i++) {
        adj[i] = new ArrayList();
    }
    for (int[] edge : prerequisites) {
        int u = edge[1];
        int v = edge[0];
        adj[u].add(v);
    }
    return adj;
}
}
