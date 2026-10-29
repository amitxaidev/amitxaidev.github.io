# 6. Find All Anagrams in a String

**LeetCode 438** · 🟡 Medium · Pattern: **Fixed window + counts**
🔗 Solve it here: [https://leetcode.com/problems/find-all-anagrams-in-a-string/](https://leetcode.com/problems/find-all-anagrams-in-a-string/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/08-sliding-window/006-find-all-anagrams-in-a-string.html](https://amitxaidev.github.io/dsa/08-sliding-window/006-find-all-anagrams-in-a-string.html)

## The problem, in short

Return every starting index in s where a rearrangement of p begins.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Same as Permutation in String, but collect every match instead of stopping.

</details>

<details>
<summary>💡 Hint 2</summary>

Compare two 26-length count arrays — that's O(26) per step, which is fine.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Build counts of p. Slide a window of length |p| over s, updating window counts by adding the new character and removing the old one. Whenever the arrays are equal, record the window start.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = p.length();
        if (n > s.length()) return res;
        int[] need = new int[26], window = new int[26];
        for (int i = 0; i < n; i++) {
            need[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(need, window)) res.add(0);
        for (int i = n; i < s.length(); i++) {
            window[s.charAt(i) - 'a']++;
            window[s.charAt(i - n) - 'a']--;
            if (Arrays.equals(need, window)) res.add(i - n + 1);   // window start
        }
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(26 · n).
- **Space:** O(26).

## Common mistake

⚠️ Recording the end index of the window instead of the start.

---

⬅️ [Previous: Permutation in String](./005-permutation-in-string.md) · [📋 Sliding Window list](./README.md) · [Next: Minimum Size Subarray Sum](./007-minimum-size-subarray-sum.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
