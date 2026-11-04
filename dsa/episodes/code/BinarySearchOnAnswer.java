import java.util.*;

// Episode 23: binary search on the answer. Koko, book allocation, aggressive cows. Run: java BinarySearchOnAnswer.java
public class BinarySearchOnAnswer {

    // LeetCode 875: slowest speed that finishes all piles in h hours (minimise → first yes)
    static int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 0;
        for (int p : piles) hi = Math.max(hi, p);
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (hoursAt(piles, mid) <= h) hi = mid;   // fast enough: answer is mid or smaller
            else lo = mid + 1;                        // too slow
        }
        return lo;
    }

    static long hoursAt(int[] piles, int k) {
        long hours = 0;
        for (int p : piles) hours += (p + k - 1) / k; // rounds up p / k
        return hours;
    }

    // Book allocation: give books in order to m students, minimise the biggest share (first yes)
    static int allocateBooks(int[] pages, int m) {
        if (m > pages.length) return -1;
        int lo = 0, hi = 0;
        for (int p : pages) { lo = Math.max(lo, p); hi += p; }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (studentsNeeded(pages, mid) <= m) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    static int studentsNeeded(int[] pages, int limit) {
        int students = 1, sum = 0;
        for (int p : pages) {
            if (sum + p > limit) { students++; sum = 0; }
            sum += p;
        }
        return students;
    }

    // Aggressive cows: place c cows, maximise the smallest gap (last yes)
    static int aggressiveCows(int[] stalls, int c) {
        int[] s = stalls.clone();
        Arrays.sort(s);
        int lo = 1, hi = s[s.length - 1] - s[0];
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;         // round UP when searching for the last yes
            if (canPlace(s, c, mid)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    static boolean canPlace(int[] s, int c, int gap) {
        int placed = 1, last = s[0];
        for (int i = 1; i < s.length; i++) {
            if (s[i] - last >= gap) { placed++; last = s[i]; }
        }
        return placed >= c;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        System.out.println("hoursAt(piles, 4) = " + hoursAt(piles, 4) + ", hoursAt(piles, 3) = " + hoursAt(piles, 3));
        System.out.println("minEatingSpeed([3, 6, 7, 11], 8) → " + minEatingSpeed(piles, 8));
        System.out.println("minEatingSpeed([4, 8], 4) → " + minEatingSpeed(new int[]{4, 8}, 4) + "   (your turn)");
        System.out.println("allocateBooks([12, 34, 67, 90], 2) → " + allocateBooks(new int[]{12, 34, 67, 90}, 2));
        System.out.println("aggressiveCows([1, 2, 4, 8, 9], 3) → " + aggressiveCows(new int[]{1, 2, 4, 8, 9}, 3));
    }
}
