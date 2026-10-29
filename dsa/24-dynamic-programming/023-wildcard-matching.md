# 23. Wildcard Matching

**LeetCode 44** · 🔴 Hard · Pattern: **2D DP on string and pattern**

## The problem, in short

Decide whether a pattern with '?' (any one character) and '*' (any sequence, including empty) matches the whole string.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/wildcard-matching/](https://leetcode.com/problems/wildcard-matching/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/023-wildcard-matching.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/023-wildcard-matching.html)

## Understanding

**Really asking:** does a pattern with ? and * match the whole string?

**Why this works:** dp[i][j] for prefixes. '*' matches nothing (left cell) or one more letter (cell above).

**Example:** s "adceb", p "*a*b"
```text
'*' empty, 'a' matches, '*' eats "dce", 'b' matches → true
```

## Hints

<details>
<summary>💡 Hint 1</summary>

dp[i][j] = first i chars of s match first j chars of p.

</details>

<details>
<summary>💡 Hint 2</summary>

'*' either matches nothing (dp[i][j−1]) or one more character (dp[i−1][j]).

</details>

<details>
<summary>💡 Hint 3</summary>

A pattern prefix of only '*' matches the empty string.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

dp[0][0] = true; dp[0][j] true while p[0..j) is all '*'. For '*' use the two options above; for '?' or an equal letter use dp[i−1][j−1].

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m && p.charAt(j - 1) == '*'; j++) dp[0][j] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char pc = p.charAt(j - 1);
                if (pc == '*') dp[i][j] = dp[i][j - 1] || dp[i - 1][j];   // empty, or eat one more char
                else if (pc == '?' || pc == s.charAt(i - 1)) dp[i][j] = dp[i - 1][j - 1];
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

⚠️ Forgetting the leading-'*' row, so patterns like "*a" fail to match.

---

⬅️ [Previous: Distinct Subsequences](./022-distinct-subsequences.md) · [📋 Dynamic Programming list](./README.md) · [Next: Best Time to Buy and Sell Stock III](./024-best-time-to-buy-and-sell-stock-iii.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
