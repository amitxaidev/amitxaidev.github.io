# 1. Running Sum of 1d Array

**LeetCode 1480** · 🟢 Easy · Pattern: **Single pass**

## The problem, in short

Given an array, return a new array where each position holds the total of all elements from index 0 up to that position.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/running-sum-of-1d-array/](https://leetcode.com/problems/running-sum-of-1d-array/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/01-complexity/001-running-sum-of-1d-array.html](https://amitxaidev.github.io/dsa/01-complexity/001-running-sum-of-1d-array.html)

## Understanding

**Really asking:** for each position, what is the total of everything up to here? The answer for one position is just the answer for the position before it plus one more number.

**Why this works:** we reuse the total we already have instead of adding everything again. That turns O(n²) into O(n).

**Example:** nums = [1, 2, 3, 4]
```text
i=0: total = 1                → [1, 2, 3, 4]
i=1: total = 1 + 2 = 3        → [1, 3, 3, 4]
i=2: total = 3 + 3 = 6        → [1, 3, 6, 4]
i=3: total = 6 + 4 = 10       → [1, 3, 6, 10]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The answer at index i is just the answer at index i-1 plus nums[i].

</details>

<details>
<summary>💡 Hint 2</summary>

You can overwrite the input array as you walk through it, so no extra array is needed.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Walk left to right and keep adding the previous value into the current one. One loop, constant work per element, so the whole thing is O(n). A nested loop that re-adds everything for each index would be O(n²) — this is the classic example of reusing work you already did.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] runningSum(int[] nums) {
        // each element becomes "itself + everything before it"
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
```

</details>

## Complexity

- **Time:** O(n) — one pass.
- **Space:** O(1) extra — we update the input in place.

## Common mistake

⚠️ Starting the loop at i = 0 and reading nums[-1]. Start at i = 1.

---

[📋 Time & Space Complexity list](./README.md) · [Next: Richest Customer Wealth](./002-richest-customer-wealth.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
