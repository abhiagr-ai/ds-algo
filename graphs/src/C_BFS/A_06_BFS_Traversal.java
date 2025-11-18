package C_BFS;

import java.util.*;

public class A_06_BFS_Traversal {
    static void main() {
        int noOfVertices = 6;
        int[][] edgePairs = {{0,1},{1,2}, {1,3},{2,3},{2,4}, {2,5}, {4,5}};
        // 1-> 2
        // 1-> 3
        // 2-> 3
        // 2-> 4
        // 2-> 5
        // 4-> 5
        bfs_prep(noOfVertices, edgePairs);
    }


    private static void bfs_prep(int noOfVertices, int[][] edgePairs) {
        // start node
        int startNode = 0;
        // create adj List
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=0; i < noOfVertices; i++){
            adjList.put(i, new ArrayList<>());
        }
        System.out.println("adjList: "+adjList);
        int i=0;
        for(int[] edge: edgePairs){
            int source = edge[0];
            int target = edge[1];
            List<Integer> l = adjList.get(source);
            l.add(target);
            adjList.put(source, l);
            i++;
        }
        System.out.println("adjList: "+adjList);

        // create a queue
        Queue<Integer> queue = new ArrayDeque<>();
        // push start node in queue
        queue.add(startNode);
        // add visited
        boolean[] visited = new boolean[noOfVertices];
        visited[startNode] = true;

        // call bfs
        bfs(visited, adjList, queue);
        System.out.println("start: "+Arrays.toString(visited));

    }

    private static void bfs(boolean[] visited, Map<Integer, List<Integer>> adjList, Queue<Integer> q) {
        // pop item
        while(!q.isEmpty()) {
            Integer item = q.poll();
            visited[item] = true;
            System.out.println("visited " + item);

            List<Integer> neighbours = adjList.get(item);
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    q.add(neighbour);
                } else {
                    System.out.println("already visited " + neighbour);
                }
                System.out.println("queue " + q);
            }
            System.out.println("> "+Arrays.toString(visited));
        }
    }
}
