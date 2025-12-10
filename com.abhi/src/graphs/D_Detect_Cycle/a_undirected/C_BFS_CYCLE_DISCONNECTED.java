package graphs.D_Detect_Cycle.a_undirected;

import graphs.util.GetAdjList;

import java.util.*;

public class C_BFS_CYCLE_DISCONNECTED {
    static void main() {
        // edge list only, vertices can be different
        int[][] edges = {{0,1},{1,2},{1,3},{0,3},{2,4},{3,4},{5,6},{6,7},{7,5}};
        int V = 8;
        /**
         *     0---1---2
         *     |   |   |
         *     +---3---4
         *
         *     5---6
         *     |   |
         *     +---7
         */
        int cycleCount = bfs_prep(V, edges);
        System.out.println("cycle count "+ cycleCount);
    }

    static int bfs_prep(int V, int[][] edges){
        ArrayList[] al = GetAdjList.get(edges, V);
        boolean[] visited = new boolean[V];
        int count = 0;
        for(int i=0; i < V; i++){
            if(!visited[i]){
                if (bfs(visited, al, i)){
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(visited));
        return count;
    }

    static boolean bfs(boolean[] visited, ArrayList<Integer>[] al, int node){
        //System.out.println("visited" + Arrays.toString(visited) + " al:"+ Arrays.toString(al) + " node:"+ node );
        visited[node] = true;
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(node, -1));

        while (!q.isEmpty()){
            Pair item = q.peek();
            q.poll();
            Integer q_node = item.node;
            Integer parent = item.parent;

            for(Integer neighbour: al[q_node]){
                if(neighbour.compareTo(parent)==0){
                    continue;
                }
                if(visited[neighbour]){
                    //System.out.println("cycle found");
                    return true;
                }
                q.offer(new Pair(neighbour, q_node));
                visited[neighbour] = true; // why since there is no recursion
            }
        }
        return false;
    }

    record Pair(Integer node, Integer parent){};

}
