# 7. Merge Sorted Array

**LeetCode 88** · 🟢 Easy · Pattern: **Merge from the back**
🔗 Solve it here: [https://leetcode.com/problems/merge-sorted-array/](https://leetcode.com/problems/merge-sorted-array/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/05-arrays/007-merge-sorted-array.html](https://amitxaidev.github.io/dsa/05-arrays/007-merge-sorted-array.html)

## The problem, in short

nums1 has m sorted values followed by n empty slots; nums2 has n sorted values. Merge nums2 into nums1 so the result is sorted, in place.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Filling from the front overwrites values you still need.

</details>

<details>
<summary>💡 Hint 2</summary>

The back of nums1 is empty — fill from the largest value down.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Three pointers: i at the end of nums1's data, j at the end of nums2, k at the very end. Put the larger of nums1[i] and nums2[j] at k and move left. When nums2 runs out, the rest of nums1 is already in place.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {   // once nums2 is used up we're done
            if (i >= 0 && nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
    }
}
```

</details>

## Complexity

- **Time:** O(m + n).
- **Space:** O(1).

## Common mistake

⚠️ Stopping when i runs out — leftover nums2 values still need copying.

---

⬅️ [Previous: Plus One](./006-plus-one.md) · [📋 Arrays list](./README.md) · [Next: Rotate Array](./008-rotate-array.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
