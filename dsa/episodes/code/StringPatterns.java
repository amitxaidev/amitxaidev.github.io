import java.util.*;

// Episode 20: three of the top string questions, one per pattern. Run: java StringPatterns.java
public class StringPatterns {

    // LeetCode 3, sliding window: jump the left edge past a repeated letter
    static int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        Arrays.fill(last, -1);
        int best = 0, left = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            left = Math.max(left, last[c] + 1);
            last[c] = r;
            best = Math.max(best, r - left + 1);
        }
        return best;
    }

    // LeetCode 20, stack: push the closing bracket you expect next
    static boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') st.push(')');
            else if (c == '{') st.push('}');
            else if (c == '[') st.push(']');
            else if (st.isEmpty() || st.pop() != c) return false;
        }
        return st.isEmpty();
    }

    // LeetCode 5, expand from every centre (odd and even)
    static String longestPalindrome(String s) {
        int start = 0, len = 0;
        for (int c = 0; c < s.length(); c++) {
            for (int k = 0; k < 2; k++) {
                int l = c, r = c + k;
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; }
                if (r - l - 1 > len) { len = r - l - 1; start = l + 1; }
            }
        }
        return s.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));   // 3
        System.out.println(isValid("({[]})"));                      // true
        System.out.println(isValid("(()]"));                        // false
        System.out.println(longestPalindrome("babad"));             // bab
    }
}
