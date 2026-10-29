# 4. Maximum Product Subarray

**LeetCode 152** · 🟡 Medium · Pattern: **Kadane with min & max**
🔗 Solve it here: [https://leetcode.com/problems/maximum-product-subarray/](https://leetcode.com/problems/maximum-product-subarray/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/004-maximum-product-subarray.html](https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/004-maximum-product-subarray.html)

## The problem, in short

Find the contiguous subarray with the largest product and return the product.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

A negative number turns the smallest product into the largest.

</details>

<details>
<summary>💡 Hint 2</summary>

Track both the maximum and the minimum product ending at each index.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each x, the new max is the largest of x, x × oldMax and x × oldMin; the new min is the smallest of the same three. Keep the best max seen.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            int a = x * max, b = x * min;   // use old values
            max = Math.max(x, Math.max(a, b));
            min = Math.min(x, Math.min(a, b));
            best = Math.max(best, max);
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

⚠️ Updating max first and then using the new max to compute min — save the old values first.

---

⬅️ [Previous: Maximum Subarray](./003-maximum-subarray.md) · [📋 Kadane, Dutch Flag & Moore's Voting list](./README.md) · [Next: Maximum Sum Circular Subarray](./005-maximum-sum-circular-subarray.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
