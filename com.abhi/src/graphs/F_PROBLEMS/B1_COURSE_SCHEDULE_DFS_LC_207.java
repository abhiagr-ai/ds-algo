package graphs.F_PROBLEMS;

import java.util.ArrayList;
import java.util.List;

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
 *
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 */
public class B1_COURSE_SCHEDULE_DFS_LC_207 {
    static void main() {
        Solution solution= new Solution();
        if(solution.canFinish(2, new int[][]{{1,0}})){
            System.out.println("test success");
        }
        if(!solution.canFinish(2, new int[][]{{1,0},{0,1}})){
            System.out.println("test success");
        }
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = getAdj(prerequisites, numCourses);
        return !isCycle(adj, numCourses);
    }

    boolean isCycle(List<Integer>[] adj, int numCourses){
        boolean[] visited = new boolean[numCourses];
        boolean[] currentRecursion = new boolean[numCourses];
        for(int i=0; i< numCourses; i++){
            if(visited[i]){
                continue;
            }
            if(!visited[i] && dfsCycle(adj, visited, currentRecursion, i)){
                return true;
            }
        }
        return false;
    }

    boolean dfsCycle(List<Integer>[] adj, boolean[] visited, boolean[] recur, int u){
        visited[u] = true;
        recur[u] = true;
        for(int v: adj[u]){
            if(visited[v] && recur[v]){
                return true;
            }
            if(!visited[v] && dfsCycle(adj, visited, recur, v)){
                return true;
            }
        }
        recur[u] = false;
        return false;
    }

    List<Integer>[] getAdj(int[][] prerequisites, int numCourses){
        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0; i< numCourses; i++){
            adj[i]= new ArrayList();
        }
        for(int[] edge: prerequisites){
            int u = edge[1];
            int v = edge[0];
            adj[u].add(v);
        }
        return adj;
    }
}
