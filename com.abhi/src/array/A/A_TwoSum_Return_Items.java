package array.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Return item array of two which can make the target
 */
public class A_TwoSum_Return_Items {

    static void main() {
        int[] input = {-1,0,0,1,2,2,7};
        int target = 1;
        List<List<Integer>> answer = new ArrayList<>();
        solve(input, target, answer);
        System.out.println(answer);
    }

    static void solve(int[] input, int target, List<List<Integer>> answer)  {
        // sorting
        Arrays.sort(input);
        System.out.println(Arrays.toString(input));

        int i = 0;
        int j = input.length-1;

        // two pointer
        while(i < j){
            System.out.println("i: "+i + " j: "+j);
            if(input[i]+input[j] > target){
                j--;
            } else if(input[i]+input[j] < target) {
                i++;
            } else {
                //remove duplicates
                while(i < j && input[i] == input[i+1]) {
                    i++;
                }
                //remove duplicates
                while(i < j && input[j] == input[j-1]){
                    j--;
                }
                answer.add(List.of(input[i], input[j]));
                i++;
                j--;
            }
        }
    }
}
