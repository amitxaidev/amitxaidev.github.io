# 3. Subsets

**LeetCode 78** · 🟡 Medium · Pattern: **Backtracking (pick / not pick)**
🔗 Solve it here: [https://leetcode.com/problems/subsets/](https://leetcode.com/problems/subsets/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/003-subsets.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/003-subsets.html)

## The problem, in short

Return every possible subset of an array of distinct integers.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

For each element decide: include it or not.

</details>

<details>
<summary>💡 Hint 2</summary>

Or: at each step, the current list is itself a subset — record it, then try adding each later element.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Backtracking: record a copy of the current path, then for i from start to n−1 add nums[i], recurse with start = i + 1, and remove it.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));            // every node is a subset
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1, path, res);
            path.remove(path.size() - 1);          // undo the choice
        }
    }
}
```

</details>

## Complexity

- **Time:** O(n · 2^n).
- **Space:** O(n) recursion besides the output.

## Common mistake

⚠️ Adding the path itself instead of new ArrayList&lt;>(path) — every stored subset ends up as the same empty list.

---

⬅️ [Previous: Sum of All Subset XOR Totals](./002-sum-of-all-subset-xor-totals.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: Subsets II](./004-subsets-ii.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
