package dp;

import java.util.Arrays;

/**
 * LC - 70
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps

 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Constraints:
 *     1 <= n <= 45
 */
public class d_climbing_stairs {
    static void main() {
        SolutionCSRecursion s = new SolutionCSRecursion();
        System.out.println(s.waysToClimb(4));

        SolutionCSRecursionMemoization sm = new SolutionCSRecursionMemoization();
        System.out.println(sm.waysToClimb(40));

        SolutionBottomUp dps = new SolutionBottomUp();
        System.out.println(dps.ways2Climb(45));

        SolutionBottomUpSC dpZeroSC = new SolutionBottomUpSC();
        System.out.println(dpZeroSC.ways2Climb(45));
    }

}

class SolutionCSRecursion {
    int waysToClimb(int n){
        if(n<=2){
            return n;
        }
        return solve(n);
    }
    private int solve(int n) {
        if (n <= 2 && n >= 0) {
            return n;
        }
        if (n < 0) {
            return 0;
        }
        int choice1 = solve(n - 1);
        int choice2 = solve(n - 2);
        return choice1 + choice2;
    }
}

class SolutionCSRecursionMemoization {

    int waysToClimb(int n){

        if(n<=2){
            return n;
        }
        int[] m = new int[n+1];
        Arrays.fill(m, -1);
        m[0] =0;
        m[1] =1;
        m[2] =2;
        return solve(n, m);
    }
    private int solve(int n, int[] m) {
        if (n < 0) {
            return 0;
        }
        if(m[n]!=-1){
            //System.out.println("calling n="+n + " with m = "+ Arrays.toString(m));
            return m[n];
        }
        int choice1 = solve(n - 1,m);
        int choice2 = solve(n - 2,m);
        return m[n] = choice1 + choice2;
    }
}

class SolutionBottomUp{
    int ways2Climb(int n){
        int[] waysToClimbKthStair = new int[n+1];
        waysToClimbKthStair[0] = 0;
        waysToClimbKthStair[1] = 1;
        waysToClimbKthStair[2] = 2;

        // we can reach kth stair = ways to reach k-1th stair + ways to reach k-2 stair
        // ex:
        // ways to reach 3rd stair = ways to reach 2nd [k-1] stair + ways to reach 1st [k-2] stair = 2+1 = 3
        // ways to reach 4th stair = ways to reach 3rd [k-1] stair + ways to reach 2nd [k-2] stair = 3+2 = 5

        // fill the array
        for(int i =3; i <=n ; i++){
            waysToClimbKthStair[i] = waysToClimbKthStair[i-1]+waysToClimbKthStair[i-2];
            System.out.println("calling for i="+i + " with waysToClimbKthStair = "+ Arrays.toString(waysToClimbKthStair));
        }
        return waysToClimbKthStair[n];
    }
}

class SolutionBottomUpSC{
    int ways2Climb(int n){

        if(n==0|| n==1 || n==2){
            return n;
        }

        int a = 1; // i -2
        int b = 2; // i -1
        int c = 3;

        // fill the array
        for(int i =3; i <=n ; i++){
            c = a + b;
            int temp_b = b;
            b = c;
            a = temp_b;
        }
        return c;
    }
}