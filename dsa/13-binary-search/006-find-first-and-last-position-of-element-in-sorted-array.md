# 6. Find First and Last Position of Element in Sorted Array

**LeetCode 34** · 🟡 Medium · Pattern: **Lower & upper bound**
🔗 Solve it here: [https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/006-find-first-and-last-position-of-element-in-sorted-array.html](https://amitxaidev.github.io/dsa/13-binary-search/006-find-first-and-last-position-of-element-in-sorted-array.html)

## The problem, in short

Return the first and last index of target in a sorted array, or [-1, -1], in O(log n).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Run binary search twice.

</details>

<details>
<summary>💡 Hint 2</summary>

First search: when you find target, keep going left. Second: keep going right.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Write one helper "first index with value >= x" (lower bound). first = lb(target), last = lb(target + 1) − 1. Check that first is in range and holds target.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);
        if (first == nums.length || nums[first] != target) return new int[]{-1, -1};
        int last = lowerBound(nums, target + 1) - 1;
        return new int[]{first, last};
    }

    // first index whose value is >= x (nums.length if none)
    private int lowerBound(int[] nums, int x) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] < x) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
```

</details>

## Complexity

- **Time:** O(log n).
- **Space:** O(1).

## Common mistake

⚠️ Finding one occurrence and then walking left/right linearly — O(n) when the value repeats a lot.

---

⬅️ [Previous: Kth Missing Positive Number](./005-kth-missing-positive-number.md) · [📋 Binary Search list](./README.md) · [Next: Search in Rotated Sorted Array](./007-search-in-rotated-sorted-array.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
