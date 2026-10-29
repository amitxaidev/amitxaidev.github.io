# 4. Left and Right Sum Differences

**LeetCode 2574** · 🟢 Easy · Pattern: **Prefix & suffix**
🔗 Solve it here: [https://leetcode.com/problems/left-and-right-sum-differences/](https://leetcode.com/problems/left-and-right-sum-differences/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/06-prefix-sum/004-left-and-right-sum-differences.html](https://amitxaidev.github.io/dsa/06-prefix-sum/004-left-and-right-sum-differences.html)

## The problem, in short

For every index, return the absolute difference between the sum of elements to its left and the sum of elements to its right.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Same idea as pivot index: right = total - left - nums[i].

</details>

<details>
<summary>💡 Hint 2</summary>

You don't need separate prefix and suffix arrays.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Compute the total, then sweep once keeping the left sum and filling |left - right| for each index.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;
        int[] ans = new int[nums.length];
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int right = total - left - nums[i];
            ans[i] = Math.abs(left - right);
            left += nums[i];
        }
        return ans;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1) extra besides the output.

## Common mistake

⚠️ Including nums[i] in either side.

---

⬅️ [Previous: Find Pivot Index](./003-find-pivot-index.md) · [📋 Prefix Sum list](./README.md) · [Next: Product of Array Except Self](./005-product-of-array-except-self.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
