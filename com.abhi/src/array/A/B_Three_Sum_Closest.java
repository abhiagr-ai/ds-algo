package array.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/3sum-closest/description/
Given an integer array nums of length n and an integer target, find three integers at distinct indices in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.
Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 */
public class B_Three_Sum_Closest {
    static void main() {
        int[] input = {-1,2,1,-4};
        int target = 1;
        List<Integer> ts = new ArrayList<>();
        int ans = solve(input, target, ts);
        System.out.println(ans);
    }

    static int solve(int[] input, int target, List<Integer> ts){
        // since its sum, so we can sort it
        Arrays.sort(input);

        // n1+n2+n3 = target => n1+n2 = target - n1
        // n1 = input[i]

        // let iterate over i and then call twoSum on rest of input with updated targetSum
        for(int i=0; i < input.length; i++){
            // remove duplicate
            if(i>1 && input[i]==input[i-1]){
                continue;
            }
            int targetSum = target - input[i];
            twoSum(input, targetSum, i+1, ts, input[i]);
        }

        //
        int max = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for(Integer element: ts){
            int k = Math.abs(element-target);
            if(k < max){
                max = k;
                ans = element;
            }
        }
        return ans;
    }

    static void twoSum(int[] input, int target, int i, List<Integer> ts, int n1){
        int p = i;
        int q = input.length-1;
        while(p< q){
            if(input[p]+ input[q] > target){
                ts.add(n1+input[p]+input[q]);
                q--;
            } else if(input[p]+ input[q] < target){
                ts.add(n1+input[p]+input[q]);
                p++;
            } else {
                // optimization- remove duplicates
                while(p<q && input[p]==input[p+1]) p++;
                while(p<q && input[q]==input[q-1]) q--;
                ts.add(n1+input[p]+input[q]);
                p++;
                q--;
                System.out.println(ts);
            }
        }
    }
}
