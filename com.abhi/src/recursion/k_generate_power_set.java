package recursion;

import java.util.ArrayList;
import java.util.List;

public class k_generate_power_set {
    static void main() {
        SolutionPS ps = new SolutionPS();
        System.out.println(ps.generate(new int[]{1,2,3}));
    }
}

class SolutionPS {
    List<List<Integer>> result = new ArrayList<>();
    List<List<Integer>> generate(int[] input){
        powerSet(input, 0, new ArrayList<>());
        return result;
    }

    void powerSet(int[] input, int i, List<Integer> temp){
        if(i >= input.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        // take it
        temp.addLast(input[i]);
        powerSet(input, i+1, temp); // trust
        // don't take it
        temp.removeLast();
        powerSet(input, i+1, temp); // trust
    }
}

/**
 * [[1, 2, 3], [1, 2], [1, 3], [1], [2, 3], [2], [3], []]
 */
