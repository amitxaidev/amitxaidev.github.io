# 1. Remove Duplicates from Sorted Array

**LeetCode 26** · 🟢 Easy · Pattern: **Read/write pointers**
🔗 Solve it here: [https://leetcode.com/problems/remove-duplicates-from-sorted-array/](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/07-two-pointers/001-remove-duplicates-from-sorted-array.html](https://amitxaidev.github.io/dsa/07-two-pointers/001-remove-duplicates-from-sorted-array.html)

## The problem, in short

In a sorted array, keep only one copy of each value at the front (in order) and return how many unique values there are. Do it in place.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Duplicates sit next to each other in a sorted array.

</details>

<details>
<summary>💡 Hint 2</summary>

Use a slow "write" pointer and a fast "read" pointer.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

write starts at 1. For each read index, if the value differs from the last written value, copy it to write and advance write. write is the new length.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int write = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[write - 1]) {
                nums[write++] = nums[read];   // new unique value
            }
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

⚠️ Comparing nums[read] with nums[read - 1] after you've started overwriting — compare with nums[write - 1] to be safe.

---

[📋 Two Pointers list](./README.md) · [Next: Remove Element](./002-remove-element.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
