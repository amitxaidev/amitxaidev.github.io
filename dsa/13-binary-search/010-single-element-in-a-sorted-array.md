# 10. Single Element in a Sorted Array

**LeetCode 540** · 🟡 Medium · Pattern: **Pair parity**
🔗 Solve it here: [https://leetcode.com/problems/single-element-in-a-sorted-array/](https://leetcode.com/problems/single-element-in-a-sorted-array/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/010-single-element-in-a-sorted-array.html](https://amitxaidev.github.io/dsa/13-binary-search/010-single-element-in-a-sorted-array.html)

## The problem, in short

In a sorted array every value appears twice except one. Find the single one in O(log n) time and O(1) space.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Before the single element, pairs start at even indexes. After it, pairs start at odd indexes.

</details>

<details>
<summary>💡 Hint 2</summary>

Make mid even, then check whether nums[mid] == nums[mid + 1].

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep mid even. If its pair is intact (nums[mid] == nums[mid + 1]), the single element is further right: lo = mid + 2. Otherwise hi = mid.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (mid % 2 == 1) mid--;                 // pairs start at even indexes
            if (nums[mid] == nums[mid + 1]) lo = mid + 2;
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

⚠️ XOR of everything — correct, but O(n), and the problem asks for O(log n).

---

⬅️ [Previous: Find Peak Element](./009-find-peak-element.md) · [📋 Binary Search list](./README.md) · [Next: Koko Eating Bananas](./011-koko-eating-bananas.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
