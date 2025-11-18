package A_01_Representation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 14.11
 */
public class A_02_LC207 {

    public static void main() {
        canFinish(4, List.of(
                List.of(1, 0),
                List.of(2, 0),
                List.of(2, 1),
                List.of(3, 1)
        ));
    }


    public static void canFinish(int numCourses, List<List<Integer>> prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int i = 0;
        for (List<Integer> courseCombo : prerequisites) {
            int u = courseCombo.get(0);
            int v = courseCombo.get(1);
            adj.put(i, List.of(u, v));
            i++;
        }
        System.out.println(adj);
    }
}
