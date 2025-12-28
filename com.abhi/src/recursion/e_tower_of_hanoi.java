package recursion;

import graphs.F_PROBLEMS.d_dsu.D_NumberOfComponents;

public class e_tower_of_hanoi {
    static void main() {
        Solution s = new Solution();
        s.moveDisks(3,"Rod-S","Rod-D", "Rod-A");
        System.out.println(s.count);
    }
}

// Given  source, aux, destination rods
// source has n disks
// you need to move these n disk to destination using aux.

/**
 *
 * Initial State (3 disks):
 *     |         |         |
 *    ###        |         |
 *   #####       |         |
 *  #######      |         |
 * ---------  ---------  ---------
 *     S         A         D

  * Goal State:
 *     |         |         |
 *     |         |        ###
 *     |         |       #####
 *     |         |      #######
 * ---------  ---------  ---------
 *     S         A         D
 */

class Solution {

    public int count =0;

    int moveDisks(int n, String source, String destination, String aux) {
        // base case
        if(n==0){
            return 0;
        }
        if(n==1){
            System.out.println("move "+ n +"th disk from "+ source +" to "+ destination);
            return count++;
        }
        // move [n-1] disk from [rod-S] to [rod-A], using [rod-D]
        int x = moveDisks(n-1, source, aux, destination);

        // move [1] disk from [rod-S] to destination [rod-D]
        System.out.println("move "+n+"th  disk from "+ source +" to "+ destination);
        count ++;
        // move [n-1] disk from  [rod-Aux] to [rod-D] using [rod-S]
        int y = moveDisks(n-1, aux, destination, source);
        return x+y+1;
    }
}


/** output:
 * move 1 disk from Rod-S to Rod-D
 * move 2th  disk from Rod-S to Rod-A
 * move 1 disk from Rod-D to Rod-A
 * move 3th  disk from Rod-S to Rod-D
 * move 1 disk from Rod-A to Rod-S
 * move 2th  disk from Rod-A to Rod-D
 * move 1 disk from Rod-S to Rod-D
 * 7
 */