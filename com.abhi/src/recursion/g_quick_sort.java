package recursion;

import java.util.Arrays;

public class g_quick_sort {
    static void main() {
        int[] arr = {3,2,4,7,9,6,8,5};
        SolutionQS s = new SolutionQS();
        s.quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

class SolutionQS {
    void quickSort(int[] arr, int low, int high) {
        if(low > high){
            return;
        }
        // partitioning [move tha pivot value - high to its correct position], and every quickSort calls partition.
        int pi = partition(arr, low, high);
        // recursion
        quickSort(arr, low, pi -1);
        quickSort(arr, pi+1, high);
    }

    int partition(int[] arr, int low, int high) {
        // take high as pivot
        // get value of pivot
        int pv = arr[high];
        int pi = low;

        for (int i = low; i <= high-1; i++) {
            // when element is gt pv
            if(arr[i] > pv){
                System.out.println("element "+arr[i] + " gt pv "+pv + " pi "+pi + " i "+i);
                // leave it
            }
            // when element is less than pv
            if(arr[i] <= pv){
                System.out.println("element "+arr[i] + " lt pv "+pv+ " pi "+pi + " i "+i);
                int temp = arr[pi];
                arr[pi] = arr[i];
                arr[i] = temp;
                pi++;
            }
            System.out.println("array "+Arrays.toString(arr));
        }
        // when all elements sorted wrt pivot, and i has reached end -1.
        int temp = arr[pi];
        arr[pi] = pv;
        arr[high] = temp;
        return pi;
    }


}


