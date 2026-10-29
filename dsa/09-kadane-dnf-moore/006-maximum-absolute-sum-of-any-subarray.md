# 6. Maximum Absolute Sum of Any Subarray

**LeetCode 1749** · 🟡 Medium · Pattern: **Kadane max & min**
🔗 Solve it here: [https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/](https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/006-maximum-absolute-sum-of-any-subarray.html](https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/006-maximum-absolute-sum-of-any-subarray.html)

## The problem, in short

Return the largest absolute value of any subarray sum (an empty subarray counts as 0).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The largest absolute sum is either the biggest positive sum or the most negative sum.

</details>

<details>
<summary>💡 Hint 2</summary>

Run Kadane for both at once.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Track the max-ending-here and min-ending-here sums (both allowed to reset to 0). The answer is max(bestMax, −bestMin).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int curMax = 0, curMin = 0, best = 0;
        for (int x : nums) {
            curMax = Math.max(0, curMax + x);
            curMin = Math.min(0, curMin + x);
            best = Math.max(best, Math.max(curMax, -curMin));
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

⚠️ Taking the absolute value of each element first — that changes the problem.

---

⬅️ [Previous: Maximum Sum Circular Subarray](./005-maximum-sum-circular-subarray.md) · [📋 Kadane, Dutch Flag & Moore's Voting list](./README.md) · [Next: Sort Colors](./007-sort-colors.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
