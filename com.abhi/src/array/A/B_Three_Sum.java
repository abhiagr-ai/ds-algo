package array.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
https://leetcode.com/problems/3sum/description/
Leet Code 15

Given an integer array nums,
return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

 */
public class B_Three_Sum {
    static void main() {
        int[] input = {-1,0,1,2,-1,-4};
        int target = 0;
        int[][] expectedAns = new int[][]{{-1,-1,2},{-1,0,1}};
        List<List<Integer>> ans = new ArrayList<>();
        solve(input, target, ans);
        System.out.println(ans);
    }

    private static void solve(int[] input, int target, List<List<Integer>> ans) {
        for(int i =0; i < input.length -2; i++){
            int n1 = input[i];
            if(i > 1 && input[i]==input[i-1]){
                continue;
            }
            twoSum(input, target, n1*-1, i+1, ans);
        }
    }

    private static void twoSum(int[] input, int target, int n1, int i, List<List<Integer>> ans) {
        int p = i;
        int q = input.length-1;
        while(p < q) {
            if(input[p] + input[q] > n1){
                q--;
            } else if (input[p] + input[q] < n1){
                p++;
            } else {
                while(p < q && input[p] == input[p+1]){
                    p++;
                }
                while(p < q && input[q] == input[q-1]){
                    q--;
                }
                ans.add(List.of(n1*-1, input[p], input[q]));
            }
        }
    }

}
