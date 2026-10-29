# 8. Rotate Array

**LeetCode 189** · 🟡 Medium · Pattern: **Reversal trick**

## The problem, in short

Rotate an array to the right by k steps in place.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/rotate-array/](https://leetcode.com/problems/rotate-array/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/05-arrays/008-rotate-array.html](https://amitxaidev.github.io/dsa/05-arrays/008-rotate-array.html)

## Understanding

**Really asking:** shift every element k steps to the right, wrapping around.

**Why this works:** rotating = moving the last k elements to the front. Reversing everything, then reversing the two parts, achieves exactly that with no extra array.

**Example:** [1, 2, 3, 4, 5, 6, 7], k = 3
```text
reverse all:   7 6 5 4 3 2 1
reverse first 3: 5 6 7 4 3 2 1
reverse rest:  5 6 7 1 2 3 4
```

## Hints

<details>
<summary>💡 Hint 1</summary>

k can be larger than n — use k % n.

</details>

<details>
<summary>💡 Hint 2</summary>

Rotating right by k = moving the last k elements to the front.

</details>

<details>
<summary>💡 Hint 3</summary>

Reverse the whole array, then reverse the first k and the remaining n - k separately.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Three reversals: whole array, first k, rest. Each element ends at (i + k) % n with O(1) extra space.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] a, int l, int r) {
        while (l < r) {
            int t = a[l];
            a[l++] = a[r];
            a[r--] = t;
        }
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Shifting one step at a time k times — O(n·k), which times out.

---

⬅️ [Previous: Merge Sorted Array](./007-merge-sorted-array.md) · [📋 Arrays list](./README.md) · [Next: Next Permutation](./009-next-permutation.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
