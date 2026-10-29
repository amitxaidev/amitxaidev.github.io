# 2. Remove Element

**LeetCode 27** · 🟢 Easy · Pattern: **Read/write pointers**
🔗 Solve it here: [https://leetcode.com/problems/remove-element/](https://leetcode.com/problems/remove-element/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/07-two-pointers/002-remove-element.html](https://amitxaidev.github.io/dsa/07-two-pointers/002-remove-element.html)

## The problem, in short

Remove every occurrence of val from the array in place and return how many elements are left. Order of the rest may change.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Copy every element that is not val to the next write position.

</details>

<details>
<summary>💡 Hint 2</summary>

Everything after the write position doesn't matter.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

One read pointer scans; a write pointer receives the elements to keep.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int write = 0;
        for (int x : nums) {
            if (x != val) nums[write++] = x;
        }
        return write;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Using list.remove in a loop on a converted list — it shifts elements and costs O(n²).

---

⬅️ [Previous: Remove Duplicates from Sorted Array](./001-remove-duplicates-from-sorted-array.md) · [📋 Two Pointers list](./README.md) · [Next: Move Zeroes](./003-move-zeroes.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
