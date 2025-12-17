package graphs.J_min_spanning_tree;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 */
public class c_min_cost_to_connect_all_points {
    static void main() {
        int[][] input = {{0,0},{2,2}, {3,10},{5,2},{7,0}};
        KruskalAlgo s = new KruskalAlgo();
        System.out.println(s.run(input));
    }
}

class KruskalAlgo{
    int run(int[][] input){
        // convert into edges
        int[][] edges = new int[input.length*input.length][3];
        DisJointSet dsu = new DisJointSet(input.length);
        int count = 0;
        for(int i=0; i < input.length; i++){
            for(int j = i+1; j < input.length; j++){
                int xi = input[i][0];
                int xj = input[j][0];
                int yi = input[i][1];
                int yj = input[j][1];
                int d = Math.abs(xi-xj)+Math.abs(yi-yj);
                edges[count++] = new int[]{i, j, d};
            }
        }
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));
        int sum =0;
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(dsu.parent[u]!= dsu.parent[v]){
                dsu.union(u,v);
                sum = sum +w;
            }
        }
        return sum;
    }
}

class DisJointSet {
    int[] parent;
    int[] rank;
    public DisJointSet(int V){
        this.parent = new int[V];
        this.rank = new int[V];
        for (int i =0; i < V; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }
    int find(int x){
        if(parent[x]!=x){
            return parent[x] = find(parent[x]);
        }
        return x;
    }
    void union(int x, int y){
        int p_x = find(x);
        int p_y = find(y);
        if(p_x!=p_y){
            if(rank[p_x] > rank[p_y]){
                parent[p_y] = p_x;
            } else if (rank[p_x] < rank[p_y]){
                parent[p_x] = p_y;
            } else {
                parent[p_x] = p_y;
                rank[p_y]+=1;
            }
        }
    }

}