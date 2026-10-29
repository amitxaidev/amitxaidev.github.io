# 2. Max Consecutive Ones

**LeetCode 485** · 🟢 Easy · Pattern: **Running counter**
🔗 Solve it here: [https://leetcode.com/problems/max-consecutive-ones/](https://leetcode.com/problems/max-consecutive-ones/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/05-arrays/002-max-consecutive-ones.html](https://amitxaidev.github.io/dsa/05-arrays/002-max-consecutive-ones.html)

## The problem, in short

In a binary array, return the length of the longest run of consecutive 1s.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Keep a counter of the current run.

</details>

<details>
<summary>💡 Hint 2</summary>

Reset it to 0 when you see a 0, and update the best each step.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

One pass with a current-run counter and a best-so-far value.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int best = 0, run = 0;
        for (int x : nums) {
            run = (x == 1) ? run + 1 : 0;
            best = Math.max(best, run);   // update every step, not only on a 0
        }
        return best;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Updating the best only when a 0 appears, which misses a run that ends at the last element.

---

⬅️ [Previous: Build Array from Permutation](./001-build-array-from-permutation.md) · [📋 Arrays list](./README.md) · [Next: Check if Array Is Sorted and Rotated](./003-check-if-array-is-sorted-and-rotated.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
