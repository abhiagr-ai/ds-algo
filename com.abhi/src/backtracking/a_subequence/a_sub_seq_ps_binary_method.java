package backtracking.a_subequence;

import java.util.ArrayList;
import java.util.List;

public class a_sub_seq_ps_binary_method {
    static void main() {
        SolutionA solution = new SolutionA();
        int[] numbers = {1,2,3};
        System.out.println(solution.subsequence(numbers));
    }
}

class SolutionA {

    void backtrack(int[] numbers, List<List<Integer>> result, List<Integer> temp, int idx){
        // when idx >= numbers.length, we get ans
        if(idx == numbers.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        // include and explore
        temp.addLast(numbers[idx]);
        backtrack(numbers, result, temp, idx+1);

        // exclude and explore
        temp.removeLast();
        backtrack(numbers, result, temp, idx+1);
    }


    List<List<Integer>> subsequence(int[] numbers){
        int n = numbers.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int idx = 0;
        backtrack(numbers, result, temp, idx);
        return result;
    }
}
