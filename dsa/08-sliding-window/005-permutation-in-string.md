# 5. Permutation in String

**LeetCode 567** · 🟡 Medium · Pattern: **Fixed window + counts**
🔗 Solve it here: [https://leetcode.com/problems/permutation-in-string/](https://leetcode.com/problems/permutation-in-string/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/08-sliding-window/005-permutation-in-string.html](https://amitxaidev.github.io/dsa/08-sliding-window/005-permutation-in-string.html)

## The problem, in short

Decide whether some rearrangement of s1 appears as a contiguous substring of s2.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

A rearrangement has exactly the same letter counts.

</details>

<details>
<summary>💡 Hint 2</summary>

Slide a window of length |s1| over s2 and compare counts.

</details>

<details>
<summary>💡 Hint 3</summary>

Track how many of the 26 letters currently have matching counts to compare in O(1).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep need[] = counts of s1 minus counts of the current window. Count how many letters are at zero. Each slide changes two letters; update the zero count. If all 26 are zero, return true.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;
        int[] diff = new int[26];
        for (int i = 0; i < n; i++) {
            diff[s1.charAt(i) - 'a']++;
            diff[s2.charAt(i) - 'a']--;
        }
        int zeros = 0;
        for (int d : diff) if (d == 0) zeros++;
        for (int i = n; i < m; i++) {
            if (zeros == 26) return true;
            zeros += change(diff, s2.charAt(i) - 'a', -1);       // char enters
            zeros += change(diff, s2.charAt(i - n) - 'a', +1);   // char leaves
        }
        return zeros == 26;
    }

    // applies delta to diff[c] and returns the change in the number of zero entries
    private int change(int[] diff, int c, int delta) {
        int before = diff[c] == 0 ? 1 : 0;
        diff[c] += delta;
        int after = diff[c] == 0 ? 1 : 0;
        return after - before;
    }
}
```

</details>

## Complexity

- **Time:** O(|s1| + |s2|).
- **Space:** O(26).

## Common mistake

⚠️ Generating all permutations of s1 — factorial time.

---

⬅️ [Previous: Longest Repeating Character Replacement](./004-longest-repeating-character-replacement.md) · [📋 Sliding Window list](./README.md) · [Next: Find All Anagrams in a String](./006-find-all-anagrams-in-a-string.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
