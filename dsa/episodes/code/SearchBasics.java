import java.util.*;

// Episode 21: linear search vs binary search. Run: java SearchBasics.java
public class SearchBasics {

    // O(n): check every box from left to right. Works on ANY array.
    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1; // not found
    }

    // O(log n): halve the range each step. Needs a SORTED array.
    static int binarySearch(int[] a, int x) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // safe: (lo + hi) / 2 can overflow
            if (a[mid] == x) return mid;
            if (a[mid] < x) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    // Same search, printing every check so you can follow it
    static int binarySearchTrace(int[] a, int x) {
        int lo = 0, hi = a.length - 1, checks = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            checks++;
            System.out.println("  check " + checks + ": lo=" + lo + " hi=" + hi + " mid=" + mid + " a[mid]=" + a[mid]);
            if (a[mid] == x) return mid;
            if (a[mid] < x) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] unsorted = {4, 8, 2, 9, 5};
        System.out.println("linearSearch(" + Arrays.toString(unsorted) + ", 9) → " + linearSearch(unsorted, 9));
        System.out.println("linearSearch(" + Arrays.toString(unsorted) + ", 7) → " + linearSearch(unsorted, 7));

        int[] sorted = {1, 3, 5, 7, 9, 11, 13};
        System.out.println("binarySearch(" + Arrays.toString(sorted) + ", 9):");
        System.out.println("  → index " + binarySearchTrace(sorted, 9));

        // the overflow bug, made visible
        int lo = 2_000_000_000, hi = 2_100_000_000;
        System.out.println("(lo + hi) / 2      = " + (lo + hi) / 2 + "   ← overflow!");
        System.out.println("lo + (hi - lo) / 2 = " + (lo + (hi - lo) / 2));

        // how many checks for a million numbers?
        int n = 1_000_000;
        int[] big = new int[n];
        for (int i = 0; i < n; i++) big[i] = 2 * i;
        int steps = 0, l = 0, h = n - 1, target = big[n - 1];
        while (l <= h) { steps++; int m = l + (h - l) / 2; if (big[m] == target) break; if (big[m] < target) l = m + 1; else h = m - 1; }
        System.out.println("1,000,000 sorted numbers: found the last one in " + steps + " checks");
    }
}
