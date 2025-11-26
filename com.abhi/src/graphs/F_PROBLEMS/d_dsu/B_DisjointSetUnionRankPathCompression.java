package graphs.F_PROBLEMS.d_dsu;

// Given an array of vertices, can be considered as an individual sets, which does not have any intersection
// means vertices 0,1,2,3....n-1 does not have any common vertices [obvious]
//  also edges[][] is also given which provides relation b/w these individual sets
// ex:
// V=4
// [0,1][1,2][2,3][3,0]
// 0 -> 1 --> 2 --> 3 --->0 has a cycle
// * Or as a visual representation:
//        *   0 ──→ 1
//        *   ↑     ↓
//        *   │     │
//        *   3 ←── 2
// dsu can be used to prove it.

// there are two functions 1. find 2. union

/**
 *  1. at start parent []
 *      +---+---+---+---+
 *      | 0 | 1 | 2 | 3 |
 *      +---+---+---+---+
 *      | 0 | 1 | 2 | 3 |
 *      +---+---+---+---+
 *  2. adjacency list for edges [0,1], [1,2], [2,3], [3,0]:
 *      0 → 1
 *      1 → 2
 *      2 → 3
 *      3 → 0
 *  3. we need to use this adj and use union function, and update parent
 *
 */

/**
 * Rule: 1
 * update find function so that it does not go recursively every time to find parent
 *
 *
 *
 *
 */

public class B_DisjointSetUnionRankPathCompression {
    static void main() {

    }

    /**
     * find parent of the node
     * at start every node is its own parent
     +---+---+---+---+
     | 0 | 1 | 2 | 3 |
     +---+---+---+---+
     | 0 | 1 | 2 | 3 |
     +---+---+---+---+
     *
     *   0 ──→ 1
     *         ↓
     *         │
     *   3 ←── 2
     * after union is performed
     * parent[] =  [0, 0, 1, 3]
     *             ↑   ↑  ↑  ↑
     * index:      0   1  2  3
     *
     * after union is performed with find path expression
     * parent[] =  [0, 0, 0, 0]
     *             ↑   ↑  ↑  ↑
     * index:      0   1  2  3
     * @param i: any child node
     * @return: u parent node
     */
    static int find(int i, int[] parent){
        if(parent[i] == i){
            return i;
        }
        return parent[i]=find(parent[i], parent);
    }

    /**
     * given 2 items, we need to union them
     * we check their parents using find
     * and when not in same set, means parent is not same. we union it
     *
     * define a rank []
     *+---+---+---+---+
     * | 0 | 1 | 2 | 3 |
     * +---+---+---+---+
     * | 0 | 0 | 0 | 0 |
     * +---+---+---+---+
     *
     *  Rule: 1. when we a and b -> if rank is equal,
     *  -> then combine, and increase rank of a when b-> a
     *+---+---+---+---+
     * | 0 | 1 | 2 | 3 |
     * +---+---+---+---+
     * | 1 | 0 | 0 | 0 |
     * +---+---+---+---+
     *
     *  Rule: 2. when we parent of a[rank-1] and parent of c[rank-0] -> if rank is not equal,
     *  -> then we make a as parent since rank of a is high
     *+---+---+---+---+
     * | 0 | 1 | 2 | 3 |
     * +---+---+---+---+
     * | 1 | 0 | 0 | 0 |
     * +---+---+---+---+

     * parent[] =  [0, 0, 0, 3]
     *             ↑   ↑  ↑  ↑
     * index:      0   1  2  3
     * @param x
     * @param y
     * @param parent
     */
    static void union(int x, int y, int[] parent, int[] rank){
        //u(0,1)
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        // both part of set, then just return, no need to union, already in union
        if(x_parent == y_parent){
            return;
        }

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }

        if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }

        if(rank[x_parent] == rank[y_parent]){
            parent[x_parent] = y_parent;
            rank[y_parent]= rank[y_parent]+1;
        }
    }
}
