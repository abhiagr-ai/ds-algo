package graphs.A_01_Representation;

/**
 * channel: codeStoryWithMK
 */
public class A_03_AdjacencyList_LC207 {
    static void main() {
        System.out.println(
                """
                        There are a total of numCourses courses you have to take, 
                        ***labeled*** from 0 to numCourses - 1. 
                        
                        You are given an array prerequisites where prerequisites[i] = [ai, bi] 
                        
                        indicates that you must take course bi first if you want to take course ai.
                        
                        For example, the pair [0, 1], 
                        indicates that to take course 0 you have to first take course 1.
                        Return true if you can finish all courses. Otherwise, return false.
                        
                        https://leetcode.com/problems/course-schedule/description/
                        """);
        makeAdj();
    }

    private static void makeAdj() {
        // pair [0,1]
        // take 1 and then take 0
        // 1[vertices] --[edge]---> 0 [vertices]
        int[][] input = new int[4][2];
        //[[1,0],[2,0],[2,1],[3,1]]
        // vertices
    }

    static void solution() {

    }
}
