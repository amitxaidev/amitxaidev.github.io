# 21. Beautiful Arrangement

**LeetCode 526** · 🟡 Medium · Pattern: **Bitmask DP**
🔗 Solve it here: [https://leetcode.com/problems/beautiful-arrangement/](https://leetcode.com/problems/beautiful-arrangement/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/021-beautiful-arrangement.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/021-beautiful-arrangement.html)

## The problem, in short

Count permutations of 1..n (n ≤ 15) where, at every position i (1-indexed), either the number divides i or i divides the number.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Fill positions in order. The state is "which numbers are already used" — a bitmask.

</details>

<details>
<summary>💡 Hint 2</summary>

The next position to fill is (number of set bits) + 1.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

dp[mask] = ways to fill the first popcount(mask) positions using exactly the numbers in mask. For each mask, let pos = bitCount(mask) + 1 and try every unused number that fits pos.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int countArrangement(int n) {
        int[] dp = new int[1 << n];
        dp[0] = 1;
        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == 0) continue;
            int pos = Integer.bitCount(mask) + 1;          // next position to fill
            for (int num = 1; num <= n; num++) {
                int bit = 1 << (num - 1);
                if ((mask & bit) == 0 && (num % pos == 0 || pos % num == 0)) {
                    dp[mask | bit] += dp[mask];
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
```

</details>

## Complexity

- **Time:** O(2^n · n).
- **Space:** O(2^n).

## Common mistake

⚠️ Storing the position as part of the state — it's determined by the mask already.

---

⬅️ [Previous: House Robber III](./020-house-robber-iii.md) · [📋 Dynamic Programming list](./README.md) · [Next: Distinct Subsequences](./022-distinct-subsequences.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
