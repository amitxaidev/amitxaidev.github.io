# 9. Find Peak Element

**LeetCode 162** · 🟡 Medium · Pattern: **Follow the slope**
🔗 Solve it here: [https://leetcode.com/problems/find-peak-element/](https://leetcode.com/problems/find-peak-element/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/009-find-peak-element.html](https://amitxaidev.github.io/dsa/13-binary-search/009-find-peak-element.html)

## The problem, in short

Return the index of any element that is strictly greater than its neighbours (outside the array counts as minus infinity), in O(log n).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

If nums[mid] &lt; nums[mid + 1], you're going uphill — a peak must exist to the right.

</details>

<details>
<summary>💡 Hint 2</summary>

Otherwise a peak exists at mid or to the left.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Binary search on the slope: uphill → lo = mid + 1, downhill → hi = mid. lo ends on a peak.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] < nums[mid + 1]) lo = mid + 1;   // climb uphill
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

⚠️ Thinking binary search needs a sorted array. It only needs a rule that tells you which half surely contains an answer.

---

⬅️ [Previous: Find Minimum in Rotated Sorted Array](./008-find-minimum-in-rotated-sorted-array.md) · [📋 Binary Search list](./README.md) · [Next: Single Element in a Sorted Array](./010-single-element-in-a-sorted-array.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
