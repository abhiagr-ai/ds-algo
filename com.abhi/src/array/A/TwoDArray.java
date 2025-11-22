package array.A;

public class TwoDArray {
    static void main() {

        int[][] arr = new int[3][2];

        int[][] arr2 = {
                {0, 1},
                {2, 3},
                {3, 5}
        };

        int[][] arrJagged = {
                {0, 1},    // ->> accessed by arrJagged[0]
                {2, 3, 4}, // ->> accessed by arrJagged[1]
                {3, 4}     // ->> accessed by arrJagged[2]
        };

        for(int i=0; i< arrJagged.length; i++){
            for(int j=0; j< arrJagged[i].length; j++){
                System.out.print(arrJagged[i][j] + " ");
            }
            System.out.println();
        }

        for (int[] rows : arrJagged) {
            for (int value : rows) {
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }
}
