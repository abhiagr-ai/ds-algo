package array.A;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
LeetCode -1
https://leetcode.com/problems/two-sum/
https://www.youtube.com/watch?v=TCaBnVIllrQ&list=PLpIkg8OmuX-K6A0sEPFxOSJh4_AjCGAFf
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class A_TwoSum {
    static void main() {
        int[] input = {3,4,9,2};
        int target = 6;
        int[] answer = solveBruteForce(input, target);
        System.out.println(Arrays.toString(answer));
        int[] answer2 = solveOn(input, target);
        System.out.println(Arrays.toString(answer2));
    }

    /**
     * O[n^2]
     */
    private static int[] solveBruteForce(int[] input, int target) {
        for(int i =0; i < input.length; i ++){
            for (int j = i+1; j< input.length; j++){
                if (target == input[i]+ input[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1};
    }

    /**
     * [2,7,11,15]
     * num -> index
     * loop
     * 9-2 exist in map? no, add [key 2, value 0] in map
     * 9-7 exist in map? yes, means current index and map.get(2)-> index return it.
     * 2 -> 0  --> 9-2 =7? exist in Map? No
     * 7 -> 1  --> 9-7= 2 ? exist in Map yes,-> get index of 2
     */
    private static int[] solveOn(int[] input, int target) {
        Map<Integer, Integer> map = new HashMap<>(input.length);

        for(int i=0; i < input.length; i++){
            // target - input[i]
            int remaining = target - input[i];
            if(!map.containsKey(remaining)){
                map.put(input[i], i);
            } else {
                return new int[]{i, map.get(remaining)};
            }
        }
        return new int[]{-1};
    }
}
