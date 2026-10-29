# 8. Custom Sort String

**LeetCode 791** · 🟡 Medium · Pattern: **Counting by custom order**

## The problem, in short

order lists some unique letters in a custom order. Rearrange s so that letters in order appear in that order; other letters can go anywhere.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/custom-sort-string/](https://leetcode.com/problems/custom-sort-string/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/14-sorting/008-custom-sort-string.html](https://amitxaidev.github.io/dsa/14-sorting/008-custom-sort-string.html)

## Understanding

**Really asking:** reorder s to follow the letter order in order.

**Why this works:** count letters of s, write them in order's sequence, then the rest.

**Example:** order "cba", s = "abcd"
```text
c, b, a, then d → "cbad"
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Count the letters in s.

</details>

<details>
<summary>💡 Hint 2</summary>

Output letters in order's sequence, then everything else.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

A counting sort keyed by the custom order: write each letter of order count times, then the remaining letters.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (count[c - 'a']-- > 0) sb.append(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a']-- > 0) sb.append(c);
        }
        return sb.toString();
    }
}
```

</details>

## Complexity

- **Time:** O(|s| + |order|).
- **Space:** O(26).

## Common mistake

⚠️ Using a comparator on Character objects with indexOf — slower and more code.

---

⬅️ [Previous: Merge Intervals](./007-merge-intervals.md) · [📋 Sorting list](./README.md) · [Next: Maximum Gap](./009-maximum-gap.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
