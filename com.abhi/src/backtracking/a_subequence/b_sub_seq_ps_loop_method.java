package backtracking.a_subequence;

import java.util.ArrayList;
import java.util.List;

public class b_sub_seq_ps_loop_method {
    static void main() {
        SolutionB solution = new SolutionB();
        int[] numbers = {1, 2, 3};
        System.out.println(solution.subsequence(numbers));
    }
}

class SolutionB {

    void backtrack(int[] numbers, List<List<Integer>> result, List<Integer> temp, int idx) {
        // when temp is not empty, every iteration generate a temp that can be added
        if (!temp.isEmpty()) {
            result.add(new ArrayList<>(temp));
        }

        for (int i = idx; i < numbers.length; i++) {
            temp.addLast(numbers[i]);
            backtrack(numbers, result, temp, i + 1);
            // excluded and explored after backtrack of above is done, by starting at next idx
            temp.removeLast();
        }
    }


    List<List<Integer>> subsequence(int[] numbers) {
        int n = numbers.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int idx = 0;
        backtrack(numbers, result, temp, idx);
        return result;
    }
}
