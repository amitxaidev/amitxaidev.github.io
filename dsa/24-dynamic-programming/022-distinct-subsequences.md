# 22. Distinct Subsequences

**LeetCode 115** · 🔴 Hard · Pattern: **2D DP counting**

## The problem, in short

Count how many distinct ways t appears as a subsequence of s.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/distinct-subsequences/](https://leetcode.com/problems/distinct-subsequences/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/022-distinct-subsequences.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/022-distinct-subsequences.html)

## Understanding

**Really asking:** in how many ways does t appear as a subsequence of s?

**Why this works:** dp[j] = ways to build t's first j letters. A matching letter of s can extend dp[j-1] (loop j downward).

**Example:** s "rabbbit", t "rabbit"
```text
choose which 2 of the 3 b's → 3 ways
```

## Hints

<details>
<summary>💡 Hint 1</summary>

dp[i][j] = ways to form the first j chars of t from the first i chars of s.

</details>

<details>
<summary>💡 Hint 2</summary>

You can always skip s[i−1]. If it matches t[j−1], you can also use it.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

dp[i][0] = 1 (empty t). Transition: dp[i][j] = dp[i−1][j] + (match ? dp[i−1][j−1] : 0). A 1D array with j going downwards works.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int numDistinct(String s, String t) {
        int m = t.length();
        long[] dp = new long[m + 1];   // long to be safe with intermediate counts
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = m; j >= 1; j--) {           // downwards: s[i] used at most once
                if (s.charAt(i) == t.charAt(j - 1)) dp[j] += dp[j - 1];
            }
        }
        return (int) dp[m];
    }
}
```

</details>

## Complexity

- **Time:** O(n·m).
- **Space:** O(m).

## Common mistake

⚠️ Looping j upwards in the 1D version, which reuses the same character of s twice.

---

⬅️ [Previous: Beautiful Arrangement](./021-beautiful-arrangement.md) · [📋 Dynamic Programming list](./README.md) · [Next: Wildcard Matching](./023-wildcard-matching.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
