import java.util.*;

// Episode 25: merge sort, divide and conquer. Run: java MergeSort.java
public class MergeSort {

    static void mergeSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;                 // 0 or 1 number: already sorted
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);                // sort the left half
        mergeSort(a, mid + 1, hi);            // sort the right half
        merge(a, lo, mid, hi);                // merge the two sorted halves
    }

    // two pointers over a[lo..mid] and a[mid+1..hi]
    static void merge(int[] a, int lo, int mid, int hi) {
        int[] t = new int[hi - lo + 1];
        int i = lo, j = mid + 1, k = 0;
        while (i <= mid && j <= hi)
            t[k++] = a[i] <= a[j] ? a[i++] : a[j++];  // <= keeps equal values in order (stable)
        while (i <= mid) t[k++] = a[i++];              // leftovers from the left half
        while (j <= hi) t[k++] = a[j++];               // leftovers from the right half
        System.arraycopy(t, 0, a, lo, t.length);
    }

    // the bug: no leftover loops, so numbers go missing
    static int[] buggyMerge(int[] left, int[] right) {
        int[] t = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length)
            t[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        return t; // missing leftovers! empty slots stay 0
    }

    public static void main(String[] args) {
        int[] a = {8, 3, 5, 1, 7, 2, 6, 4};
        System.out.println("before: " + Arrays.toString(a));
        mergeSort(a, 0, a.length - 1);
        System.out.println("after:  " + Arrays.toString(a));

        int[] left = {1, 3, 5, 8}, right = {2, 4, 6, 7};
        System.out.println("buggy merge loses the 8: " + Arrays.toString(buggyMerge(left, right)));

        int n = 1_000_000;
        int[] big = new int[n];
        Random r = new Random(1);
        for (int i = 0; i < n; i++) big[i] = r.nextInt();
        long t0 = System.nanoTime();
        mergeSort(big, 0, n - 1);
        System.out.println("sorted 1,000,000 random numbers in " + (System.nanoTime() - t0) / 1_000_000 + " ms");
    }
}
