# 8. Max Consecutive Ones III

**LeetCode 1004** · 🟡 Medium · Pattern: **Variable window with budget**

## The problem, in short

In a binary array you may flip at most k zeros to ones. Return the longest run of ones you can get.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/max-consecutive-ones-iii/](https://leetcode.com/problems/max-consecutive-ones-iii/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/08-sliding-window/008-max-consecutive-ones-iii.html](https://amitxaidev.github.io/dsa/08-sliding-window/008-max-consecutive-ones-iii.html)

## Understanding

**Really asking:** flip at most k zeros; longest run of ones?

**Why this works:** it's "longest window with at most k zeros". Count zeros in the window; shrink when there are too many.

**Example:** [1,1,1,0,0,0,1,1,1,1,0], k = 2
```text
window can hold two 0s
best window [0,0,1,1,1,1] after sliding → length 6
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Rephrase: the longest window containing at most k zeros.

</details>

<details>
<summary>💡 Hint 2</summary>

Count zeros in the window; shrink from the left when it exceeds k.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Expand right, counting zeros. While zeros > k, move left forward (decrementing zeros if a zero leaves). Track the window length.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, zeros = 0, best = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) zeros++;
            while (zeros > k) {
                if (nums[left] == 0) zeros--;
                left++;
            }
            best = Math.max(best, r - left + 1);
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

⚠️ Actually flipping values in the array and trying to undo them — counting is enough.

---

⬅️ [Previous: Minimum Size Subarray Sum](./007-minimum-size-subarray-sum.md) · [📋 Sliding Window list](./README.md) · [Next: Fruit Into Baskets](./009-fruit-into-baskets.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
