package recursion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class l_possible_subsequence {
    static void main() {
        SolutionPsSs ps = new SolutionPsSs();
        System.out.println(ps.generate("abc"));
    }
}

class SolutionPsSs {
    List<List<Character>> result = new ArrayList<>();

    List<List<Character>> generate(String s) {
        subsequence(s, 0, new ArrayList<>());
        // Open sort the list
        return result;
    }

    void subsequence(String input, int i, ArrayList<Character> temp) {
        if (i >= input.length()) {
            if (!temp.isEmpty()) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        // take it
        temp.addLast(input.charAt(i));
        subsequence(input, i + 1, temp);

        // don't take it
        temp.removeLast();
        subsequence(input, i + 1, temp);
    }
}

/**
 * [[a, b, c], [a, b], [a, c], [a], [b, c], [b], [c], []]
 */
