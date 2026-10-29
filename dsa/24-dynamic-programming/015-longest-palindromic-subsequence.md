# 15. Longest Palindromic Subsequence

**LeetCode 516** · 🟡 Medium · Pattern: **Interval DP**
🔗 Solve it here: [https://leetcode.com/problems/longest-palindromic-subsequence/](https://leetcode.com/problems/longest-palindromic-subsequence/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/015-longest-palindromic-subsequence.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/015-longest-palindromic-subsequence.html)

## The problem, in short

Return the length of the longest subsequence of s that is a palindrome.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

dp[i][j] = answer for s[i..j].

</details>

<details>
<summary>💡 Hint 2</summary>

If s[i] == s[j], dp[i][j] = dp[i+1][j−1] + 2; else max(dp[i+1][j], dp[i][j−1]).

</details>

<details>
<summary>💡 Hint 3</summary>

Fill i from the end so dp[i+1][…] is ready. (It's also LCS of s and reverse(s).)

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Single characters are length 1. Loop i from n − 1 down to 0 and j from i + 1 up to n − 1, applying the transition.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;   // both ends used
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
}
```

</details>

## Complexity

- **Time:** O(n²).
- **Space:** O(n²).

## Common mistake

⚠️ Filling i in increasing order, which reads cells that aren't computed yet.

---

⬅️ [Previous: Longest Increasing Subsequence](./014-longest-increasing-subsequence.md) · [📋 Dynamic Programming list](./README.md) · [Next: Edit Distance](./016-edit-distance.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
