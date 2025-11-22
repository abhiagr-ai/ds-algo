package array.A;

public class TwoDArray {
    static void main() {

        int[][] arr = new int[3][2];

        int[][] arr2 = {
                {0, 1},
                {2, 3},
                {3, 5}
        };

        int[][] arr3 = new int[3][];
        arr3[0] = new int[1];
        arr3[1] = new int[2];
        arr3[2] = new int[3];

        arr3[0][0] = 1;
        //
        arr3[1][0] = 2;
        arr3[1][1] = 3;
        //
        arr3[2][0] = 4;
        arr3[2][1] = 5;
        arr3[2][2] = 6;

        System.out.println("===========================");

        for(int i=0; i< arr3.length; i++){
            for(int j=0; j< arr3[i].length; j++){
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===========================");

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

        System.out.println("===========================");

        for (int[] rows : arrJagged) {
            for (int value : rows) {
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }
}
