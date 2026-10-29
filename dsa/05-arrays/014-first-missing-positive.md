# 14. First Missing Positive

**LeetCode 41** · 🔴 Hard · Pattern: **Cyclic sort**
🔗 Solve it here: [https://leetcode.com/problems/first-missing-positive/](https://leetcode.com/problems/first-missing-positive/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/05-arrays/014-first-missing-positive.html](https://amitxaidev.github.io/dsa/05-arrays/014-first-missing-positive.html)

## The problem, in short

Return the smallest positive integer that is not in an unsorted array, in O(n) time and O(1) extra space.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The answer is always between 1 and n + 1.

</details>

<details>
<summary>💡 Hint 2</summary>

Try to put each value v (1 ≤ v ≤ n) at index v - 1 by swapping.

</details>

<details>
<summary>💡 Hint 3</summary>

After placing, the first index i where nums[i] != i + 1 gives the answer.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Cyclic sort: for each index, while its value is in range and not already at its home (and the home doesn't already hold the same value), swap it home. Each swap places one value correctly, so total work is O(n). Then scan for the first mismatch.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int home = nums[i] - 1;   // send value to its home index
                int t = nums[home];
                nums[home] = nums[i];
                nums[i] = t;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Swapping when nums[v - 1] already equals v (a duplicate) — that loops forever. Compare with the home slot, not with i + 1.

---

⬅️ [Previous: H-Index](./013-h-index.md) · [📋 Arrays list](./README.md)

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
