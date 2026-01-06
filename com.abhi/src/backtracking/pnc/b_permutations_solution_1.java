package backtracking.pnc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b_permutations_solution_1 {
    static void main() {
        SolutionPS1 solutionPS1 = new SolutionPS1();
        int[] num = {1, 2, 3};
        System.out.println(solutionPS1.getPermutations(num));
    }
}

class SolutionPS1 {

    Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

    private void backtrack(int[] numbers, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() >= numbers.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int number : numbers) {
            if (map.isEmpty() || !map.containsKey(number)) {
                // do
                temp.addLast(number);
                map.put(number, true);
                // explore
                backtrack(numbers, result, temp);

                // it for loop, so i moves to next, and we need not call backtrack again
                // undo
                temp.removeLast();
                map.remove(number);
            }
        }
    }

    public List<List<Integer>> getPermutations(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(numbers, result, temp);
        return result;
    }
}
