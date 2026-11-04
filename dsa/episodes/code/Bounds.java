import java.util.*;

// Episode 22: lower bound, upper bound, first and last position. Run: java Bounds.java
public class Bounds {

    // first index with a[i] >= x (a.length if none). Also = Search Insert Position (LeetCode 35).
    static int lowerBound(int[] a, int x) {
        int lo = 0, hi = a.length;           // hi = n: the answer can be n
        while (lo < hi) {                    // lo < hi goes with hi = mid
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < x) lo = mid + 1;
            else hi = mid;                   // mid might be the answer: keep it
        }
        return lo;
    }

    // first index with a[i] > x. One character different: <=
    static int upperBound(int[] a, int x) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] <= x) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // LeetCode 34: first and last position of x
    static int[] searchRange(int[] a, int x) {
        int first = lowerBound(a, x);
        if (first == a.length || a[first] != x) return new int[]{-1, -1};
        int last = upperBound(a, x) - 1;
        return new int[]{first, last};
    }

    // how many times x appears, in O(log n)
    static int count(int[] a, int x) {
        return upperBound(a, x) - lowerBound(a, x);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2, 3, 5};
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("lowerBound(a, 2) = " + lowerBound(a, 2));
        System.out.println("upperBound(a, 2) = " + upperBound(a, 2));
        System.out.println("lowerBound(a, 4) = " + lowerBound(a, 4) + "   (where 4 would go)");
        System.out.println("searchRange(a, 2) = " + Arrays.toString(searchRange(a, 2)));
        System.out.println("searchRange(a, 4) = " + Arrays.toString(searchRange(a, 4)));
        System.out.println("count(a, 2) = " + count(a, 2));

        int[] b = {1, 3, 3, 3, 3, 8}; // your turn
        System.out.println("b = " + Arrays.toString(b) + ": lb(3)=" + lowerBound(b, 3) + " ub(3)=" + upperBound(b, 3) + " count=" + count(b, 3));
    }
}
