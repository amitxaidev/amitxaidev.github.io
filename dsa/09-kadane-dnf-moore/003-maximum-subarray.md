# 3. Maximum Subarray

**LeetCode 53** · 🟡 Medium · Pattern: **Kadane**

## The problem, in short

Find the contiguous non-empty subarray with the largest sum and return the sum.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/maximum-subarray/](https://leetcode.com/problems/maximum-subarray/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/003-maximum-subarray.html](https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/003-maximum-subarray.html)

## Understanding

**Really asking:** the contiguous piece with the biggest sum.

**Why this works:** a running sum that has gone negative only drags down whatever comes next, so start over from the current number.

**Example:** [-2, 1, -3, 4, -1, 2, 1, -5, 4]
```text
cur: -2, 1, -2, 4, 3, 5, 6, 1, 5
best = 6 → [4, -1, 2, 1]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

At each index decide: extend the previous subarray, or start fresh here?

</details>

<details>
<summary>💡 Hint 2</summary>

Start fresh when the running sum would be smaller than the element alone.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Kadane's algorithm: cur = max(nums[i], cur + nums[i]); best = max(best, cur). A negative running sum can only hurt what comes next, so drop it.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int cur = nums[0], best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);   // extend or restart
            best = Math.max(best, cur);
        }
        return best;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Starting best at 0 — if every number is negative, the answer is the largest negative, not 0.

---

⬅️ [Previous: Sort Array By Parity](./002-sort-array-by-parity.md) · [📋 Kadane, Dutch Flag & Moore's Voting list](./README.md) · [Next: Maximum Product Subarray](./004-maximum-product-subarray.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
