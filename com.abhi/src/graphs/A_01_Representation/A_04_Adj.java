package graphs.A_01_Representation;

import java.util.ArrayList;
import java.util.Arrays;

public class A_04_Adj {
    static void main() {
        // C++  vector<int> adj[]
        // Java List<Integer>[] adj;
        ArrayList<Integer>[] adjList;
        int n = 5;

        // To initialize it:
        ArrayList[] adj1 = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj1[i] = new ArrayList<>();
        }
        System.out.println(Arrays.toString(adj1));

        // java
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj2.add(new ArrayList<>());
        }
        System.out.println(adj2);
    }
}
