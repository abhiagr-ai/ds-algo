package A_01_Representation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * channel: codeStoryWithMK
 * www.youtube.com/watch?v=5JGiZnr6B5w&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY
 */
public class A_01_Graph_Representation {
    static void main() {
        System.out.println("two types of graphs");
        System.out.println("Undirected and directed");
        System.out.println("vertices v=4, v=0 to v-1");
        System.out.println("space is wasted in adjacency metric");

        System.out.println("Adjacency List");
        System.out.println("0 -> 1,2");
        System.out.println("1 -> 2,3");
        System.out.println("2 -> ");
        System.out.println("Unordered Map-> adj");
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        adjacencyList.put(0, List.of(1,2));
        adjacencyList.put(1, List.of(2,3));
        adjacencyList.put(2, List.of(0,1));
        adjacencyList.put(3, List.of(1));
        System.out.println(adjacencyList);
        System.out.println("edge + vertices");
        System.out.println("How to identify graph question");
        System.out.println("numbered");
        System.out.println("direction");
    }
}
