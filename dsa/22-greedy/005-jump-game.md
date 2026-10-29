# 5. Jump Game

**LeetCode 55** · 🟡 Medium · Pattern: **Furthest reach**
🔗 Solve it here: [https://leetcode.com/problems/jump-game/](https://leetcode.com/problems/jump-game/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/22-greedy/005-jump-game.html](https://amitxaidev.github.io/dsa/22-greedy/005-jump-game.html)

## The problem, in short

nums[i] is the maximum jump length from index i. Starting at index 0, decide whether you can reach the last index.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Track the furthest index you can reach so far.

</details>

<details>
<summary>💡 Hint 2</summary>

If you ever stand on an index beyond that reach, you're stuck.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Scan i from 0; if i > reach return false; otherwise reach = max(reach, i + nums[i]). Return true when the scan finishes (or reach covers the end).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) return false;          // can't even get here
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Trying all jumps recursively — exponential without memoisation.

---

⬅️ [Previous: Best Time to Buy and Sell Stock II](./004-best-time-to-buy-and-sell-stock-ii.md) · [📋 Greedy list](./README.md) · [Next: Jump Game II](./006-jump-game-ii.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
