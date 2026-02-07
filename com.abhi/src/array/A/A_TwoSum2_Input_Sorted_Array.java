package array.A;

import java.util.Arrays;

/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
167. Two Sum II - Input Array Is Sorted
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 */
public class A_TwoSum2_Input_Sorted_Array {
    static void main() {
        int[] input = {1,2,4,6,8,9};
        int target = 12;
        int[] answer = solve(input, target);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] solve(int[] input, int target) {
        for(int i=0, j=input.length-1; i < input.length && j > 0;){
            if(input[i]+input[j] == target){
                // return 1 based index
                return new int[]{i+1,j+1};
            }
            if(input[i]+input[j] > target){
                j--;
            }
            if(input[i]+input[j] < target){
                i++;
            }
        }
        return new int[]{-1};
    }
}
