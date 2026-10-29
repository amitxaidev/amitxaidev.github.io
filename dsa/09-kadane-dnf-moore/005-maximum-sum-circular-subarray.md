# 5. Maximum Sum Circular Subarray

**LeetCode 918** · 🟡 Medium · Pattern: **Kadane max & min**
🔗 Solve it here: [https://leetcode.com/problems/maximum-sum-circular-subarray/](https://leetcode.com/problems/maximum-sum-circular-subarray/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/005-maximum-sum-circular-subarray.html](https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/005-maximum-sum-circular-subarray.html)

## The problem, in short

The array is circular (the end wraps to the start). Return the largest possible sum of a non-empty subarray that uses each element at most once.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The best subarray either doesn't wrap (normal Kadane) or wraps around.

</details>

<details>
<summary>💡 Hint 2</summary>

A wrapping subarray = total − (a middle subarray that is left out). Make that middle part as small as possible.

</details>

<details>
<summary>💡 Hint 3</summary>

If every number is negative, the "wrap" case would pick an empty subarray — use the normal answer then.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Run Kadane for the max subarray and for the min subarray at the same time. Answer = max(maxSum, total − minSum), except when maxSum &lt; 0 (all negative) return maxSum.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0, curMax = 0, curMin = 0;
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        for (int x : nums) {
            curMax = Math.max(x, curMax + x);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(x, curMin + x);
            minSum = Math.min(minSum, curMin);
            total += x;
        }
        if (maxSum < 0) return maxSum;           // all numbers negative
        return Math.max(maxSum, total - minSum); // no wrap vs wrap
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Forgetting the all-negative case, which returns 0 (an empty subarray) instead of the largest element.

---

⬅️ [Previous: Maximum Product Subarray](./004-maximum-product-subarray.md) · [📋 Kadane, Dutch Flag & Moore's Voting list](./README.md) · [Next: Maximum Absolute Sum of Any Subarray](./006-maximum-absolute-sum-of-any-subarray.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
