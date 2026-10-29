# 13. Longest Common Subsequence

**LeetCode 1143** · 🟡 Medium · Pattern: **2D DP on two strings**
🔗 Solve it here: [https://leetcode.com/problems/longest-common-subsequence/](https://leetcode.com/problems/longest-common-subsequence/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/013-longest-common-subsequence.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/013-longest-common-subsequence.html)

## The problem, in short

Return the length of the longest sequence of characters that appears in both strings in the same order (not necessarily contiguous).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

dp[i][j] = LCS of the first i characters of a and the first j of b.

</details>

<details>
<summary>💡 Hint 2</summary>

If a[i−1] == b[j−1], dp[i][j] = dp[i−1][j−1] + 1; otherwise max(dp[i−1][j], dp[i][j−1]).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Fill an (n+1) × (m+1) table row by row; row 0 and column 0 are 0 (empty prefix).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int longestCommonSubsequence(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }
}
```

</details>

## Complexity

- **Time:** O(n·m).
- **Space:** O(n·m), reducible to O(m).

## Common mistake

⚠️ Confusing subsequence with substring and resetting to 0 on a mismatch.

---

⬅️ [Previous: Coin Change II](./012-coin-change-ii.md) · [📋 Dynamic Programming list](./README.md) · [Next: Longest Increasing Subsequence](./014-longest-increasing-subsequence.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
