import java.util.*;

// Episode 19: Rabin-Karp with a rolling hash, and the Z algorithm. Run: java StringMatching.java
public class StringMatching {

    // Rabin-Karp: compare hashes, and check the letters when they match
    static int search(String t, String p) {
        int n = t.length(), m = p.length();
        if (m > n) return -1;
        long B = 256, M = 1_000_000_007L;
        long hp = 0, ht = 0, pow = 1;
        for (int i = 0; i < m; i++) {
            hp = (hp * B + p.charAt(i)) % M;
            ht = (ht * B + t.charAt(i)) % M;
            if (i > 0) pow = pow * B % M;
        }
        for (int i = 0; ; i++) {
            if (hp == ht && t.startsWith(p, i)) return i;
            if (i + m == n) return -1;
            ht = (ht - t.charAt(i) * pow % M + M) % M;   // remove the letter leaving
            ht = (ht * B + t.charAt(i + m)) % M;          // shift, add the letter coming in
        }
    }

    // z[i] = how many letters from i match the start of s
    static int[] zArray(String s) {
        int n = s.length();
        int[] z = new int[n];
        char[] c = s.toCharArray();
        for (int i = 1, l = 0, r = 0; i < n; i++) {
            if (i < r) z[i] = Math.min(r - i, z[i - l]);
            while (i + z[i] < n && c[z[i]] == c[i + z[i]])
                z[i]++;
            if (i + z[i] > r) { l = i; r = i + z[i]; }
        }
        return z;
    }

    // every place p appears in t, using pattern + "$" + text
    static List<Integer> zSearch(String t, String p) {
        int[] z = zArray(p + "$" + t);
        List<Integer> found = new ArrayList<>();
        for (int i = p.length() + 1; i < z.length; i++)
            if (z[i] == p.length()) found.add(i - p.length() - 1);
        return found;
    }

    public static void main(String[] args) {
        System.out.println(search("abcabd", "abd"));                  // 3
        System.out.println(Arrays.toString(zArray("ab$xabab")));      // [0, 0, 0, 0, 2, 0, 2, 0]
        System.out.println(zSearch("xabab", "ab"));                   // [1, 3]
    }
}
