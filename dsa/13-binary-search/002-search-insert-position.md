# 2. Search Insert Position

**LeetCode 35** · 🟢 Easy · Pattern: **Lower bound**
🔗 Solve it here: [https://leetcode.com/problems/search-insert-position/](https://leetcode.com/problems/search-insert-position/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/002-search-insert-position.html](https://amitxaidev.github.io/dsa/13-binary-search/002-search-insert-position.html)

## The problem, in short

In a sorted array of distinct values, return the index of target, or the index where it would be inserted to keep the order.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

You want the first index whose value is >= target.

</details>

<details>
<summary>💡 Hint 2</summary>

That's the "lower bound". When the loop ends, lo points to it.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Binary search with lo, hi = 0, n − 1. When the loop ends without a hit, lo is exactly the insert position.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;   // first index with value > target
    }
}
```

</details>

## Complexity

- **Time:** O(log n).
- **Space:** O(1).

## Common mistake

⚠️ Returning hi or mid at the end — it's lo.

---

⬅️ [Previous: Binary Search](./001-binary-search.md) · [📋 Binary Search list](./README.md) · [Next: Sqrt(x)](./003-sqrtx.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
