# 3. Move Zeroes

**LeetCode 283** · 🟢 Easy · Pattern: **Read/write pointers**
🔗 Solve it here: [https://leetcode.com/problems/move-zeroes/](https://leetcode.com/problems/move-zeroes/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/07-two-pointers/003-move-zeroes.html](https://amitxaidev.github.io/dsa/07-two-pointers/003-move-zeroes.html)

## The problem, in short

Move all zeros to the end of the array in place, keeping the order of the non-zero elements.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

First compact the non-zero values to the front.

</details>

<details>
<summary>💡 Hint 2</summary>

Or swap each non-zero element with the first zero position as you go.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep write = position for the next non-zero. When you see a non-zero at read, swap it with nums[write] and advance write. Zeros drift to the end and the non-zero order is kept.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int write = 0;
        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != 0) {
                int t = nums[write];
                nums[write++] = nums[read];
                nums[read] = t;
            }
        }
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Swapping zeros toward the end with bubble-like passes — O(n²).

---

⬅️ [Previous: Remove Element](./002-remove-element.md) · [📋 Two Pointers list](./README.md) · [Next: Valid Palindrome](./004-valid-palindrome.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
