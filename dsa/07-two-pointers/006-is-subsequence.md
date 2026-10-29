# 6. Is Subsequence

**LeetCode 392** · 🟢 Easy · Pattern: **Same direction**

## The problem, in short

Decide whether s can be obtained from t by deleting some characters without changing the order of the rest.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/is-subsequence/](https://leetcode.com/problems/is-subsequence/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/07-two-pointers/006-is-subsequence.html](https://amitxaidev.github.io/dsa/07-two-pointers/006-is-subsequence.html)

## Understanding

**Really asking:** can you find s's letters inside t in the same order?

**Why this works:** walk t once; whenever its letter matches the next needed letter of s, move forward in s.

**Example:** s = "abc", t = "ahbgdc"
```text
a ✓, h, b ✓, g, d, c ✓ → all found → true
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Walk through t once with a pointer into s.

</details>

<details>
<summary>💡 Hint 2</summary>

Advance the s pointer only when characters match.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Greedy matching: for each character of t, if it equals the next needed character of s, move forward in s. s is a subsequence if you reach its end.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length() && i < s.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) i++;   // matched one more char of s
        }
        return i == s.length();
    }
}
```

</details>

## Complexity

- **Time:** O(|t|).
- **Space:** O(1).

## Common mistake

⚠️ Using indexOf for each character from the start of t each time, which ignores order.

---

⬅️ [Previous: Squares of a Sorted Array](./005-squares-of-a-sorted-array.md) · [📋 Two Pointers list](./README.md) · [Next: Two Sum II - Input Array Is Sorted](./007-two-sum-ii-input-array-is-sorted.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
