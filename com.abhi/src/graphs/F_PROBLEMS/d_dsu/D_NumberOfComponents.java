package graphs.F_PROBLEMS.d_dsu;


import java.util.Arrays;

/**
 * LC 1319
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network
 * where connections[i] = [ai, bi] represents a connection between computers ai and bi.
 * Any computer can reach any other computer directly or indirectly through the network.
 *
 * You are given an initial computer network connections.
 * You can extract certain cables between two directly connected computers,
 * and place them between any pair of disconnected computers to make them directly connected.
 *
 * Return the minimum number of times you need to do this in order to make all the computers connected.
 * If it is not possible, return -1.
 *
 * Input: n = 4, connections = [[0,1],[0,2],[1,2]]
 * Output: 1
 *
 */
public class D_NumberOfComponents {
    static void main() {
        int V = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}};
        Solution s = new Solution();
        System.out.println(s.findComponents(V, edges));
    }

    public static class Solution {

        int[] parent;
        int[] rank;

        int findComponents(int V, int[][] edges) {

            this.parent = new int[V];
            this.rank = new int[V];
            for (int i=0; i< V; i++){
                parent[i] = i;
                rank[i] = 1;
            }
            // we need at-least V-1 connections to connect them
            if(edges.length < V-1){
                return -1;
            }

            //
            int components = V;
            for(int i =0; i<edges.length; i++){
                int[] edge = edges[i];
                if(find(edge[0])!=find(edge[1])){
                    union(edge[0], edge[1]);
                    components --;
                }
            }

            // if x components are found disjoint at last then we need x-1 cables to connect them
            return components-1;
        }

        private int find(int node){
            if(parent[node]==node){
                System.out.println("find returning "+node + " with parent "+ Arrays.toString(parent));
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        private void union(int x, int y){
            if(parent[x]== parent[y]){
                System.out.println("union x "+x + " with y "+ y);
                return;
            }

            if(rank[x]> rank[y]){
                System.out.println("union x "+x + " with y "+ y);
                parent[y] = x;
                System.out.println("rank x>y: union x "+x + " with y "+ y + " parent "+ Arrays.toString(parent)+ " rank "+ Arrays.toString(rank));
            }

            if(rank[x]< rank[y]){
                parent[x] = y;
                System.out.println("rank x<y: union x "+x + " with y "+ y + " parent "+ Arrays.toString(parent)+ " rank "+ Arrays.toString(rank));
            }

            if(rank[x]==rank[y]){
                parent[y] = x;
                rank[x]++;
                System.out.println("rank x=y:union x "+x + " with y "+ y + " parent "+ Arrays.toString(parent)+ " rank "+ Arrays.toString(rank));
            }
        }
    }
}

