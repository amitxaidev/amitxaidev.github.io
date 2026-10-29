# 16. Edit Distance

**LeetCode 72** · 🟡 Medium · Pattern: **2D DP on two strings**

## The problem, in short

Return the minimum number of single-character inserts, deletes and replacements needed to turn word1 into word2.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/edit-distance/](https://leetcode.com/problems/edit-distance/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/016-edit-distance.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/016-edit-distance.html)

## Understanding

**Really asking:** fewest inserts, deletes and replaces to turn one word into another.

**Why this works:** dp[i][j] for prefixes: same letter → no cost; otherwise 1 + the best of replace, delete or insert.

**Example:** "horse" → "ros"
```text
horse → rorse (replace h) → rose (delete r) → ros (delete e) → 3
```

## Hints

<details>
<summary>💡 Hint 1</summary>

dp[i][j] = edits to turn the first i chars of word1 into the first j chars of word2.

</details>

<details>
<summary>💡 Hint 2</summary>

Equal last chars: dp[i−1][j−1]. Otherwise 1 + min(replace dp[i−1][j−1], delete dp[i−1][j], insert dp[i][j−1]).

</details>

<details>
<summary>💡 Hint 3</summary>

Base cases: dp[i][0] = i, dp[0][j] = j.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Fill the table row by row with the transition above.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int minDistance(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = i;   // delete everything
        for (int j = 0; j <= m; j++) dp[0][j] = j;   // insert everything
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[n][m];
    }
}
```

</details>

## Complexity

- **Time:** O(n·m).
- **Space:** O(n·m).

## Common mistake

⚠️ Forgetting the base row/column, so converting to or from an empty string costs 0.

---

⬅️ [Previous: Longest Palindromic Subsequence](./015-longest-palindromic-subsequence.md) · [📋 Dynamic Programming list](./README.md) · [Next: Best Time to Buy and Sell Stock with Cooldown](./017-best-time-to-buy-and-sell-stock-with-cooldown.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
