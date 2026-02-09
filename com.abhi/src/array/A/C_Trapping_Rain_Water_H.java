package array.A;


/**
 * Leet Code 42
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 */
public class C_Trapping_Rain_Water_H {
    static void main() {
        int[] input = {4,2,0,3,2,5};
        int ans = solve(input);
        System.out.println(ans);
    }

    /**
     * formula
     *
     * for any given index , except first and last
     * ex: 4, 0, 5
     *  waterHold = min[leftMax - rightMax] - height
     */
    static int solve(int[] input){
        int ans =0;
        for(int i=1; i < input.length-1; i++ ){
            // lMax
            int lMax = 0;
            for(int l=i-1; l >=0; l--){
                if(input[l]> lMax){
                    lMax = input[l];
                }
            }
            // rMax
            int rMax = 0;
            for(int r=i+1; r <= input.length-1; r++){
                if(input[r]  > rMax){
                    rMax = input[r];
                }
            }
            int holdW = Math.min(lMax, rMax) - input[i];
            if(holdW>0){
                ans = ans +holdW;
            }
        }
        return ans;
    }
}
