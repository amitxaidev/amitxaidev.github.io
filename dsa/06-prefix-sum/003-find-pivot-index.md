# 3. Find Pivot Index

**LeetCode 724** · 🟢 Easy · Pattern: **Total minus left**
🔗 Solve it here: [https://leetcode.com/problems/find-pivot-index/](https://leetcode.com/problems/find-pivot-index/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/06-prefix-sum/003-find-pivot-index.html](https://amitxaidev.github.io/dsa/06-prefix-sum/003-find-pivot-index.html)

## The problem, in short

Find the leftmost index where the sum of everything to its left equals the sum of everything to its right. Return -1 if none.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Compute the total once.

</details>

<details>
<summary>💡 Hint 2</summary>

right sum = total - left sum - nums[i].

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Walk left to right keeping the left sum. At each index check whether leftSum equals total - leftSum - nums[i], then add nums[i] to leftSum.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left == total - left - nums[i]) return i;   // check before adding nums[i]
            left += nums[i];
        }
        return -1;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Adding nums[i] to the left sum before the check, which counts the pivot on the left side.

---

⬅️ [Previous: Range Sum Query - Immutable](./002-range-sum-query-immutable.md) · [📋 Prefix Sum list](./README.md) · [Next: Left and Right Sum Differences](./004-left-and-right-sum-differences.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
