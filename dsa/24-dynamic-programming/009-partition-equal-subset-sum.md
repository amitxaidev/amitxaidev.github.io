# 9. Partition Equal Subset Sum

**LeetCode 416** · 🟡 Medium · Pattern: **0/1 knapsack (subset sum)**
🔗 Solve it here: [https://leetcode.com/problems/partition-equal-subset-sum/](https://leetcode.com/problems/partition-equal-subset-sum/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/009-partition-equal-subset-sum.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/009-partition-equal-subset-sum.html)

## The problem, in short

Decide whether the array can be split into two subsets with equal sums.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

If the total is odd, it's impossible.

</details>

<details>
<summary>💡 Hint 2</summary>

Otherwise: is there a subset that sums to total / 2? That's 0/1 knapsack.

</details>

<details>
<summary>💡 Hint 3</summary>

With a 1D boolean array, loop the sum downwards so each number is used once.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

can[s] = some subset sums to s. Start with can[0] = true. For each number x, for s from target down to x: can[s] |= can[s − x].

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;
        if (total % 2 == 1) return false;
        int target = total / 2;
        boolean[] can = new boolean[target + 1];
        can[0] = true;
        for (int x : nums) {
            for (int s = target; s >= x; s--) {   // downwards: each item once
                can[s] |= can[s - x];
            }
        }
        return can[target];
    }
}
```

</details>

## Complexity

- **Time:** O(n · target).
- **Space:** O(target).

## Common mistake

⚠️ Looping s upwards, which lets the same number be used many times (that's unbounded knapsack).

---

⬅️ [Previous: Triangle](./008-triangle.md) · [📋 Dynamic Programming list](./README.md) · [Next: Target Sum](./010-target-sum.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
