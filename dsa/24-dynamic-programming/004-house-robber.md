# 4. House Robber

**LeetCode 198** · 🟡 Medium · Pattern: **1D DP (take / skip)**
🔗 Solve it here: [https://leetcode.com/problems/house-robber/](https://leetcode.com/problems/house-robber/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/004-house-robber.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/004-house-robber.html)

## The problem, in short

Houses in a row hold money. You can't rob two adjacent houses. Return the most money you can rob.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

At house i, either rob it (plus the best up to i − 2) or skip it (best up to i − 1).

</details>

<details>
<summary>💡 Hint 2</summary>

dp[i] = max(dp[i − 1], dp[i − 2] + nums[i]).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep the best totals for the previous two positions and roll them forward.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int rob(int[] nums) {
        int prev2 = 0, prev1 = 0;   // best up to i-2, i-1
        for (int x : nums) {
            int cur = Math.max(prev1, prev2 + x);   // skip vs rob
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Robbing all even or all odd houses — the best choice can skip two in a row.

---

⬅️ [Previous: N-th Tribonacci Number](./003-n-th-tribonacci-number.md) · [📋 Dynamic Programming list](./README.md) · [Next: House Robber II](./005-house-robber-ii.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
