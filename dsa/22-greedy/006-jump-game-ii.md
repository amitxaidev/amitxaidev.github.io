# 6. Jump Game II

**LeetCode 45** · 🟡 Medium · Pattern: **BFS by ranges**

## The problem, in short

Same jumps as Jump Game, and the end is always reachable. Return the minimum number of jumps to reach the last index.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/jump-game-ii/](https://leetcode.com/problems/jump-game-ii/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/22-greedy/006-jump-game-ii.html](https://amitxaidev.github.io/dsa/22-greedy/006-jump-game-ii.html)

## Understanding

**Really asking:** the fewest jumps to the end.

**Why this works:** think in levels: all indexes reachable in j jumps form a range; the next range ends at the furthest point reachable from it.

**Example:** [2, 3, 1, 1, 4]
```text
jump 1 covers indexes 1..2
from there furthest 4 → jump 2 → done
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Think of levels: all indexes reachable with j jumps form a range.

</details>

<details>
<summary>💡 Hint 2</summary>

The next range ends at the furthest point reachable from the current range.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep the end of the current range and the furthest reach. When i hits the current end, you must jump: count it and set the end to the furthest reach.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, furthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {   // no jump needed from the last index
            furthest = Math.max(furthest, i + nums[i]);
            if (i == curEnd) {                        // range used up: jump
                jumps++;
                curEnd = furthest;
            }
        }
        return jumps;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Looping up to the last index inclusive and counting an extra jump when you're already there.

---

⬅️ [Previous: Jump Game](./005-jump-game.md) · [📋 Greedy list](./README.md) · [Next: Gas Station](./007-gas-station.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
