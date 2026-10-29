# 8. Find Minimum in Rotated Sorted Array

**LeetCode 153** · 🟡 Medium · Pattern: **Compare with the right end**
🔗 Solve it here: [https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/008-find-minimum-in-rotated-sorted-array.html](https://amitxaidev.github.io/dsa/13-binary-search/008-find-minimum-in-rotated-sorted-array.html)

## The problem, in short

A sorted array of distinct values was rotated. Return its smallest element in O(log n).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Compare nums[mid] with nums[hi].

</details>

<details>
<summary>💡 Hint 2</summary>

If nums[mid] > nums[hi], the drop (and the minimum) is to the right of mid.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

While lo &lt; hi: if nums[mid] > nums[hi], lo = mid + 1; else hi = mid (mid may be the minimum). lo ends on the minimum.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] > nums[hi]) lo = mid + 1;   // minimum is right of mid
            else hi = mid;
        }
        return nums[lo];
    }
}
```

</details>

## Complexity

- **Time:** O(log n).
- **Space:** O(1).

## Common mistake

⚠️ Comparing with nums[lo] — for an unrotated array that sends you the wrong way.

---

⬅️ [Previous: Search in Rotated Sorted Array](./007-search-in-rotated-sorted-array.md) · [📋 Binary Search list](./README.md) · [Next: Find Peak Element](./009-find-peak-element.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
