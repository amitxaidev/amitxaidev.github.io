import java.util.*;

// Episode 18: the KMP algorithm. Run: java Kmp.java
public class Kmp {

    // lps[i] = length of the longest prefix of p that is also a suffix of p[0..i]
    static int[] buildLps(String p) {
        int[] lps = new int[p.length()];
        int len = 0;
        for (int i = 1; i < p.length(); i++) {
            while (len > 0 && p.charAt(i) != p.charAt(len))
                len = lps[len - 1];
            if (p.charAt(i) == p.charAt(len)) len++;
            lps[i] = len;
        }
        return lps;
    }

    // LeetCode 28: i only moves forward, j falls back with lps
    static int strStr(String t, String p) {
        if (p.isEmpty()) return 0;
        int[] lps = buildLps(p);
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            while (j > 0 && t.charAt(i) != p.charAt(j))
                j = lps[j - 1];
            if (t.charAt(i) == p.charAt(j)) j++;
            if (j == p.length()) return i - j + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(buildLps("ababc")));   // [0, 0, 1, 2, 0]
        System.out.println(Arrays.toString(buildLps("aabaa")));   // [0, 1, 0, 1, 2]
        System.out.println(strStr("abababcab", "ababc"));         // 2
        System.out.println(strStr("hello", "xyz"));               // -1
    }
}
