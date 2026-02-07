package dp;

import java.util.Arrays;

/**
 * 213. House Robber II
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * Example 1:
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * <p>
 * Example 2:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * <p>
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: 3
 * <p>
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
public class f_house_robber_II {
    static void main() {
        int[] input = {1, 2, 3};
        A_SolutionHR2 a = new A_SolutionHR2();
        System.out.println(a.robbed(input));

        B_Bottom_Up b = new B_Bottom_Up();
        System.out.println(b.rob(input));
    }
}

class A_SolutionHR2 {

    int solve(int[] houses, int i, int n) {
        if (i >= n) {
            return 0;
        }
        int steal = houses[i] + solve(houses, i + 2, n);
        int skip = solve(houses, i + 1, n);
        return Math.max(steal, skip);
    }

    int robbed(int[] houses) {
        if (houses.length == 0) {
            return 0;
        }
        if (houses.length == 1) {
            return houses[0];
        }
        if (houses.length == 2) {
            return Math.max(houses[0], houses[1]);
        }

        // start with 0 to n-1 [skip last element, or 0 to 2nd last]
        int zero_To_N_Minus1 = solve(houses, 0, houses.length-1);
        // start with 1 to n [skip first element, or 1 to last]
        int one_To_N = solve(houses, 1, houses.length);
        return Math.max(zero_To_N_Minus1, one_To_N);
    }
}

class B_Bottom_Up {

    int rob(int[] houses){
        int n = houses.length;
        if(n ==0){
            return 0;
        }
        if(n ==1){
            return houses[0];
        }
        if(n ==2){
            return Math.max(houses[0], houses[1]);
        }

        int[] dp = new int[n+1];
        // dp : money stolen when i houses

        // rob from house-1 to house n-1 [skip last house]
        dp[0] = 0;
        dp[1] = houses[0];
        dp[2] = Math.max(houses[0], houses[1]);
        for(int i=1; i <= n-1; i++){
            int skip = dp[i-1];
            int take = houses[i-1] + (i-2 > 0 ? dp[i-2] : 0);
            dp[i] = Math.max(skip, take);
        }
        int result1 = dp[n-1];

        // rob from house-2 to house n
        Arrays.fill(dp, 0);
        dp[0] = 0;
        dp[1] = 0; // skip 1st house
        dp[2] = houses[1];
        for(int i=2; i <= n; i++){
            int skip = dp[i-1];
            int take = houses[i-1] + (i-2 > 0? dp[i-2]: 0);
            dp[i] = Math.max(skip, take);
        }
        int result2 = dp[n];
        return Math.max(result1, result2);
    }
}
