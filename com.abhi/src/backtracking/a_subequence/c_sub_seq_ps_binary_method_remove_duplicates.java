package backtracking.a_subequence;

import java.util.ArrayList;
import java.util.List;

public class c_sub_seq_ps_binary_method_remove_duplicates {
    static void main() {
        SolutionC solution = new SolutionC();
        int[] numbers = {1,2,2};
        System.out.println(solution.subsequence(numbers));
    }
}

class SolutionC {

    void backtrack(int[] numbers, List<List<Integer>> result, List<Integer> temp, int idx){
        if(idx >= numbers.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        // add and explore
        temp.addLast(numbers[idx]);
        backtrack(numbers, result, temp, idx+1);

        // remove and explore
        temp.removeLast();
        // we need to move to index where i dont have duplicate -> look ahead
        // 2[2](2)2
        // [] -> idx position
        // () -> i position
        for(int i= idx; i < numbers.length -1 ;){
            if(numbers[i]==numbers[i+1]){
                idx++;
            }
            i++;
        }
        // we reach till last duplicate, and then increase idx+1 to reach at nonduplicate
        backtrack(numbers, result, temp, idx+1);
    }

    List<List<Integer>> subsequence(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int startIndex = 0;
        backtrack(numbers, result, temp, startIndex);
        return result;
    }
}