# 5. Find All Numbers Disappeared in an Array

**LeetCode 448** · 🟢 Easy · Pattern: **Index marking**
🔗 Solve it here: [https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/05-arrays/005-find-all-numbers-disappeared-in-an-array.html](https://amitxaidev.github.io/dsa/05-arrays/005-find-all-numbers-disappeared-in-an-array.html)

## The problem, in short

An array of n numbers has values in 1..n, some repeated. Return all values in 1..n that never appear, using no extra space besides the output.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Every value v can point to an index: v - 1.

</details>

<details>
<summary>💡 Hint 2</summary>

Mark "v was seen" by making nums[v - 1] negative.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each value, negate the slot it points to (if not already negative). Afterwards, every index i that is still positive means i + 1 was never seen.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) nums[idx] = -nums[idx];   // mark idx+1 as seen
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) ans.add(i + 1);
        }
        return ans;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1) extra.

## Common mistake

⚠️ Using nums[i] - 1 as the index after it was negated. Use Math.abs(nums[i]).

---

⬅️ [Previous: Best Time to Buy and Sell Stock](./004-best-time-to-buy-and-sell-stock.md) · [📋 Arrays list](./README.md) · [Next: Plus One](./006-plus-one.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
