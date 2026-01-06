package backtracking;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=SwD51tfRaO0
 * Given an integer array nums,
 * return all the
 * different possible non-decreasing subsequences of the given array
 * with at least two elements.
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [4,6,7,7]
 * Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * <p>
 * Example 2:
 * Input: nums = [4,4,3,2,1]
 * Output: [[4,4]]
 */
public class c_non_decreasing_subsequence_lc_491_m {
    static void main() {
        SolutionLC491 s = new SolutionLC491();
        int[] numbers = {4, 6, 7, 7, 5};
        System.out.println(s.findSubsequences(numbers));
    }
}

class SolutionLC491 {
    int n;

    public List<List<Integer>> findSubsequences(int[] numbers) {
        n = numbers.length;
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        backtrack(numbers, 0, new LinkedList<>(), result);
        return result;
    }

    private void backtrack(int[] numbers,
                           int idx,
                           LinkedList<Integer> curr,
                           List<List<Integer>> result) {
        if (curr.size() > 1) {
            result.add(new LinkedList<>(curr));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = idx; i < n; i++) {
            if ((curr.isEmpty() || numbers[i] >= curr.peekLast()) && !used.contains(numbers[i])) {
                used.add(numbers[i]);
                curr.add(numbers[i]);
                backtrack(numbers, i + 1, curr, result);
                curr.removeLast();
            }
        }
    }
}