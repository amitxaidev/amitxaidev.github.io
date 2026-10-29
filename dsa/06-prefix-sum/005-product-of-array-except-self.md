# 5. Product of Array Except Self

**LeetCode 238** · 🟡 Medium · Pattern: **Prefix & suffix products**

## The problem, in short

Return an array where each position holds the product of all other elements, without using division, in O(n).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/product-of-array-except-self/](https://leetcode.com/problems/product-of-array-except-self/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/06-prefix-sum/005-product-of-array-except-self.html](https://amitxaidev.github.io/dsa/06-prefix-sum/005-product-of-array-except-self.html)

## Understanding

**Really asking:** for each index, the product of all the other numbers, without division.

**Why this works:** product of everything else = (product of everything on the left) × (product of everything on the right). Two passes build both.

**Example:** [1, 2, 3, 4]
```text
left products:  [1, 1, 2, 6]
right products: [24, 12, 4, 1]
multiply:       [24, 12, 8, 6]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The answer at i = (product of everything left of i) × (product of everything right of i).

</details>

<details>
<summary>💡 Hint 2</summary>

Fill the left products into the output first, then multiply in the right products with a single running variable going backwards.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Pass 1 (left to right): ans[i] = product of nums[0..i-1]. Pass 2 (right to left): keep a running product of nums[i+1..] and multiply it into ans[i]. Only the output array is used.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) ans[i] = ans[i - 1] * nums[i - 1];   // left products
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= right;          // times product of everything to the right
            right *= nums[i];
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

⚠️ Dividing the total product by nums[i] — it's not allowed and fails when the array has a zero.

---

⬅️ [Previous: Left and Right Sum Differences](./004-left-and-right-sum-differences.md) · [📋 Prefix Sum list](./README.md) · [Next: Range Sum Query 2D - Immutable](./006-range-sum-query-2d-immutable.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
