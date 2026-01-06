package recursion;

import java.util.ArrayList;
import java.util.List;

public class n_possible_subsequence_numbers {
    static void main() {
        SolutionPSSN ps = new SolutionPSSN();
        int[] nums = {4,6,7,7,5};
        System.out.println(ps.generate(nums));
    }
}

class SolutionPSSN {
    List<List<Integer>> result = new ArrayList<>();

    List<List<Integer>> generate(int[] nums) {
        subsequence(nums, 0, new ArrayList<>());
        return result;
    }

    void subsequence(int[] input, int i, ArrayList<Integer> temp) {
        if (i >= input.length) {
            if (!temp.isEmpty()) {
                if(temp.size()>1){
                    result.add(new ArrayList<>(temp));
                }
            }
            return;
        }
        // take it
        //if((temp.isEmpty() || temp.getLast() <= input[i])){
            temp.addLast(input[i]);
            subsequence(input, i + 1, temp);
            // don't take it
            temp.removeLast();
            subsequence(input, i + 1, temp);
        //}

    }
}
