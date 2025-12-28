package recursion;

import java.util.Arrays;

public class f_merge_sort {
    static void main() {
        SolutionMS s = new SolutionMS();
        int[] arr = {3, 2, 1, 5};
        s.mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

class SolutionMS {
    void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // get mid-point
        int mid = (l + r) / 2;
        System.out.println("left "+l + " mid: "+mid + " right:"+r + " arr: "+ Arrays.toString(arr));
        // sort left part
        mergeSort(arr, l, mid);
        // sort right part
        mergeSort(arr, mid + 1, r);
        // merge left and right
        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        // l------------m------------r
        // arr-left l to m [iteration -> i]
        int k =l;
        int nl = mid-l+1;
        int[] left = new int[nl];
        for(int i = 0; i < nl; i++ ){
            left[i] = arr[k];
            k++;
        }
        // arr-right m+1 to r [iteration -> j]
        int nr = r-mid;
        int[] right = new int[nr];
        for(int j = 0; j < nr; j++ ){
            right[j] = arr[k];
            k++;
        }
        System.out.println("left " + Arrays.toString(left));
        System.out.println("right "+ Arrays.toString(right));
        // merged-arr l to r [iterator -> k]
        int i = 0; // L
        int j = 0; // R
        k =l;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
