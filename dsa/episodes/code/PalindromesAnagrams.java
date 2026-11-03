import java.util.*;

// Episode 17: palindromes, anagrams and frequency counting. Run: java PalindromesAnagrams.java
public class PalindromesAnagrams {

    // LeetCode 125: two pointers, skipping anything that isn't a letter or digit
    static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char a = Character.toLowerCase(s.charAt(l));
            char b = Character.toLowerCase(s.charAt(r));
            if (!Character.isLetterOrDigit(a)) l++;
            else if (!Character.isLetterOrDigit(b)) r--;
            else if (a != b) return false;
            else { l++; r--; }
        }
        return true;
    }

    // LeetCode 242: +1 for s, -1 for t, then every count must be zero
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count)
            if (c != 0) return false;
        return true;
    }

    // LeetCode 49: the sorted letters are the key
    static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String w : strs) {
            char[] c = w.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(w);
        }
        return new ArrayList<>(map.values());
    }

    // LeetCode 387: count, then walk again
    static int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (count[s.charAt(i) - 'a'] == 1) return i;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));   // true
        System.out.println(isPalindrome("rocket"));                           // false
        System.out.println(isAnagram("listen", "silent"));                    // true
        System.out.println(isAnagram("rat", "car"));                          // false
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        // three groups, in any order: [eat, tea, ate], [tan, nat], [bat]
        System.out.println(firstUniqChar("loveleetcode"));                    // 2
    }
}
