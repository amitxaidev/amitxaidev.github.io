# 11. Find All Duplicates in an Array

**LeetCode 442** · 🟡 Medium · Pattern: **Index marking**

## The problem, in short

Values are in 1..n and each appears once or twice. Return every value that appears twice, in O(n) time and O(1) extra space.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/find-all-duplicates-in-an-array/](https://leetcode.com/problems/find-all-duplicates-in-an-array/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/05-arrays/011-find-all-duplicates-in-an-array.html](https://amitxaidev.github.io/dsa/05-arrays/011-find-all-duplicates-in-an-array.html)

## Understanding

**Really asking:** values 1..n, some appear twice — list them.

**Why this works:** visiting value v flips nums[v-1] negative. If it's already negative, we've seen v before.

**Example:** [4, 3, 2, 7, 8, 2, 3, 1]
```text
4,3,2,7,8 mark their slots
2 again → slot 1 already negative → duplicate 2
3 again → slot 2 already negative → duplicate 3
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Same marking trick as "numbers disappeared": value v points to index v - 1.

</details>

<details>
<summary>💡 Hint 2</summary>

If the slot is already negative when you visit it, you've seen v before.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each value v = |nums[i]|, look at nums[v - 1]. If it's negative, v is a duplicate; otherwise negate it.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]);
            if (nums[v - 1] < 0) ans.add(v);   // second visit
            else nums[v - 1] = -nums[v - 1];
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

⚠️ Forgetting Math.abs when reading a value that was already negated.

---

⬅️ [Previous: Rearrange Array Elements by Sign](./010-rearrange-array-elements-by-sign.md) · [📋 Arrays list](./README.md) · [Next: Find the Duplicate Number](./012-find-the-duplicate-number.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
