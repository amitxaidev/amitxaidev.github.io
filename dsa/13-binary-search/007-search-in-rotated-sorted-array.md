# 7. Search in Rotated Sorted Array

**LeetCode 33** · 🟡 Medium · Pattern: **Find the sorted half**
🔗 Solve it here: [https://leetcode.com/problems/search-in-rotated-sorted-array/](https://leetcode.com/problems/search-in-rotated-sorted-array/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/007-search-in-rotated-sorted-array.html](https://amitxaidev.github.io/dsa/13-binary-search/007-search-in-rotated-sorted-array.html)

## The problem, in short

A sorted array of distinct values was rotated at an unknown point. Find target's index in O(log n), or -1.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

At any mid, at least one half (left or right) is fully sorted.

</details>

<details>
<summary>💡 Hint 2</summary>

Check whether target lies inside the sorted half's range; if so go there, otherwise go to the other half.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

If nums[lo] &lt;= nums[mid], the left half is sorted: go left when nums[lo] &lt;= target &lt; nums[mid]. Otherwise the right half is sorted: go right when nums[mid] &lt; target &lt;= nums[hi].

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] == target) return mid;
            if (nums[lo] <= nums[mid]) {                  // left half sorted
                if (nums[lo] <= target && target < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else {                                      // right half sorted
                if (nums[mid] < target && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }
}
```

</details>

## Complexity

- **Time:** O(log n).
- **Space:** O(1).

## Common mistake

⚠️ Using &lt; instead of &lt;= in nums[lo] &lt;= nums[mid]; when lo == mid the left "half" is one element and is sorted.

---

⬅️ [Previous: Find First and Last Position of Element in Sorted Array](./006-find-first-and-last-position-of-element-in-sorted-array.md) · [📋 Binary Search list](./README.md) · [Next: Find Minimum in Rotated Sorted Array](./008-find-minimum-in-rotated-sorted-array.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
