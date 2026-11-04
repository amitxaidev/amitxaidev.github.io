import java.util.*;

// Episode 24: bubble, selection and insertion sort, printing every pass. Run: java BasicSorts.java
public class BasicSorts {

    // swap neighbours; stop early if a pass makes no swaps (O(n) on sorted input)
    static void bubbleSort(int[] a) {
        for (int pass = 0; pass < a.length - 1; pass++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - 1 - pass; j++) {
                if (a[j] > a[j + 1]) { int t = a[j]; a[j] = a[j + 1]; a[j + 1] = t; swapped = true; }
            }
            System.out.println("  bubble pass " + (pass + 1) + ": " + Arrays.toString(a));
            if (!swapped) break;
        }
    }

    // move the smallest remaining number to the front; at most n - 1 swaps, always O(n²) compares
    static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) if (a[j] < a[min]) min = j;
            int t = a[i]; a[i] = a[min]; a[min] = t;
            System.out.println("  selection step " + (i + 1) + ": " + Arrays.toString(a));
        }
    }

    // slide each number left into place, like sorting playing cards
    static int insertionSort(int[] a) {
        int comparisons = 0;
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0) {
                comparisons++;
                if (a[j] <= key) break;
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        return comparisons;
    }

    public static void main(String[] args) {
        System.out.println("bubbleSort([5, 1, 4, 2, 8]):");
        bubbleSort(new int[]{5, 1, 4, 2, 8});
        System.out.println("selectionSort([5, 1, 4, 2, 8]):");
        selectionSort(new int[]{5, 1, 4, 2, 8});
        int[] c = {5, 1, 4, 2, 8};
        insertionSort(c);
        System.out.println("insertionSort([5, 1, 4, 2, 8]) → " + Arrays.toString(c));
        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("insertionSort on 10 sorted numbers: " + insertionSort(sorted) + " comparisons   (your turn)");
    }
}
