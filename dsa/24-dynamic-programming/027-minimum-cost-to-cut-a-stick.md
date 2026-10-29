# 27. Minimum Cost to Cut a Stick

**LeetCode 1547** · 🔴 Hard · Pattern: **Partition DP (MCM style)**

## The problem, in short

A stick of length n must be cut at given positions, in any order. Each cut costs the length of the piece being cut. Return the minimum total cost.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/minimum-cost-to-cut-a-stick/](https://leetcode.com/problems/minimum-cost-to-cut-a-stick/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/027-minimum-cost-to-cut-a-stick.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/027-minimum-cost-to-cut-a-stick.html)

## Understanding

**Really asking:** the cheapest order of cuts, where each cut costs the current piece length.

**Why this works:** interval DP over the sorted cut positions: dp[i][j] = piece length + the best first cut k inside.

**Example:** n = 7, cuts [1, 3, 4, 5]
```text
cutting at 3 first, then 5, then 1 and 4 → 16
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Sort the cuts and add 0 and n as boundaries.

</details>

<details>
<summary>💡 Hint 2</summary>

dp[i][j] = cheapest way to make all cuts strictly between boundary i and boundary j.

</details>

<details>
<summary>💡 Hint 3</summary>

Try each cut k in between as the first one: cost = (pos[j] − pos[i]) + dp[i][k] + dp[k][j].

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Same shape as matrix chain multiplication. Fill by increasing gap between i and j.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length + 2;
        int[] pos = new int[m];
        for (int i = 0; i < cuts.length; i++) pos[i + 1] = cuts[i];
        pos[m - 1] = n;
        Arrays.sort(pos);
        int[][] dp = new int[m][m];
        for (int gap = 2; gap < m; gap++) {
            for (int i = 0; i + gap < m; i++) {
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {   // first cut inside (i, j)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
                dp[i][j] += pos[j] - pos[i];        // that cut costs the piece length
            }
        }
        return dp[0][m - 1];
    }
}
```

</details>

## Complexity

- **Time:** O(m³), m = number of cuts.
- **Space:** O(m²).

## Common mistake

⚠️ Building the DP over the stick length n (up to 10^6) instead of over the cut positions.

---

⬅️ [Previous: Burst Balloons](./026-burst-balloons.md) · [📋 Dynamic Programming list](./README.md) · [Next: Shortest Path Visiting All Nodes](./028-shortest-path-visiting-all-nodes.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
