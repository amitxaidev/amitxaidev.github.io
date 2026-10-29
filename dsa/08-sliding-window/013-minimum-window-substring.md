# 13. Minimum Window Substring

**LeetCode 76** · 🔴 Hard · Pattern: **Variable window with need counts**

## The problem, in short

Return the shortest substring of s that contains every character of t (with multiplicity). Return "" if none exists.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/minimum-window-substring/](https://leetcode.com/problems/minimum-window-substring/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/08-sliding-window/013-minimum-window-substring.html](https://amitxaidev.github.io/dsa/08-sliding-window/013-minimum-window-substring.html)

## Understanding

**Really asking:** the shortest part of s containing all letters of t.

**Why this works:** expand until everything is covered, then shrink from the left while it stays covered. A single "missing" counter tells you when you're covered.

**Example:** s = "ADOBECODEBANC", t = "ABC"
```text
first cover "ADOBEC" (6)
keep sliding … "BANC" covers A, B, C (4)
answer "BANC"
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Expand until the window covers t, then shrink from the left while it still covers t.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep need[c] counts and a single "missing" counter instead of comparing maps.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

need[c] starts as counts in t; missing = |t|. Moving right decrements need[c] and, if it was positive, missing. When missing == 0, record the window and shrink: increment need of the left char, and if it becomes positive, the window is no longer valid.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        for (char c : t.toCharArray()) need[c]++;
        int missing = t.length(), left = 0, bestStart = 0, bestLen = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            if (need[s.charAt(r)]-- > 0) missing--;          // a needed char arrived
            while (missing == 0) {
                if (r - left + 1 < bestLen) {
                    bestLen = r - left + 1;
                    bestStart = left;
                }
                if (++need[s.charAt(left++)] > 0) missing++;   // we just lost a needed char
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}
```

</details>

## Complexity

- **Time:** O(|s| + |t|).
- **Space:** O(128).

## Common mistake

⚠️ Comparing full count maps on every step — correct but much slower and error-prone.

---

⬅️ [Previous: Count Number of Nice Subarrays](./012-count-number-of-nice-subarrays.md) · [📋 Sliding Window list](./README.md) · [Next: Subarrays with K Different Integers](./014-subarrays-with-k-different-integers.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
