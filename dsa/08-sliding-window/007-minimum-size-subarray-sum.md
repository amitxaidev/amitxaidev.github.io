# 7. Minimum Size Subarray Sum

**LeetCode 209** · 🟡 Medium · Pattern: **Variable window (shrink while valid)**

## The problem, in short

All numbers are positive. Return the length of the shortest contiguous subarray whose sum is at least target, or 0 if none.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/minimum-size-subarray-sum/](https://leetcode.com/problems/minimum-size-subarray-sum/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/08-sliding-window/007-minimum-size-subarray-sum.html](https://amitxaidev.github.io/dsa/08-sliding-window/007-minimum-size-subarray-sum.html)

## Understanding

**Really asking:** the shortest piece (positive numbers) with sum ≥ target.

**Why this works:** grow until the sum is big enough, then shrink from the left as long as it stays big enough, recording lengths.

**Example:** target 7, [2, 3, 1, 2, 4, 3]
```text
2+3+1+2 = 8 ≥ 7 → length 4, drop 2 → 6
+4 → 10 → length 4, drop 3 → 7 → length 3, drop 1 → 6
+3 → 9 → length 3, drop 2 → 7 → length 2 ✓
answer 2
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Expand the window until the sum reaches target.

</details>

<details>
<summary>💡 Hint 2</summary>

Then shrink from the left as long as it still reaches target, recording lengths.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Because values are positive, adding grows the sum and removing shrinks it. Expand right; while sum >= target, update the best length and remove nums[left].

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, best = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {            // shrink while still valid
                best = Math.min(best, r - left + 1);
                sum -= nums[left++];
            }
        }
        return best == Integer.MAX_VALUE ? 0 : best;
    }
}
```

</details>

## Complexity

- **Time:** O(n) — each index enters and leaves once.
- **Space:** O(1).

## Common mistake

⚠️ Using "if" instead of "while" for shrinking — you'd miss shorter windows.

---

⬅️ [Previous: Find All Anagrams in a String](./006-find-all-anagrams-in-a-string.md) · [📋 Sliding Window list](./README.md) · [Next: Max Consecutive Ones III](./008-max-consecutive-ones-iii.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
