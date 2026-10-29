# 11. Remove Duplicates from Sorted Array II

**LeetCode 80** · 🟡 Medium · Pattern: **Read/write pointers**

## The problem, in short

In a sorted array, keep at most two copies of each value at the front, in place, and return the new length.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/07-two-pointers/011-remove-duplicates-from-sorted-array-ii.html](https://amitxaidev.github.io/dsa/07-two-pointers/011-remove-duplicates-from-sorted-array-ii.html)

## Understanding

**Really asking:** keep at most two copies of each value.

**Why this works:** a value may be written if it differs from the value two places behind the write pointer.

**Example:** [1, 1, 1, 2, 2, 3]
```text
write 1, 1
third 1 = nums[write-2] → skip
write 2, 2, 3 → [1, 1, 2, 2, 3]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Same write-pointer idea as the "one copy" version.

</details>

<details>
<summary>💡 Hint 2</summary>

A value can be written if it differs from the element two places behind the write position.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each value x, write it if write &lt; 2 or x != nums[write - 2]. Comparing with two slots back allows exactly two copies.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int write = 0;
        for (int x : nums) {
            if (write < 2 || x != nums[write - 2]) nums[write++] = x;
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

⚠️ Comparing with nums[read - 2] instead of nums[write - 2] — the read side still contains the extra copies.

---

⬅️ [Previous: Container With Most Water](./010-container-with-most-water.md) · [📋 Two Pointers list](./README.md) · [Next: Boats to Save People](./012-boats-to-save-people.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
