# 4. Subsets II

**LeetCode 90** · 🟡 Medium · Pattern: **Backtracking with duplicate skip**
🔗 Solve it here: [https://leetcode.com/problems/subsets-ii/](https://leetcode.com/problems/subsets-ii/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/004-subsets-ii.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/004-subsets-ii.html)

## The problem, in short

Return all distinct subsets of an array that may contain duplicates.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Sort so equal values sit together.

</details>

<details>
<summary>💡 Hint 2</summary>

At the same recursion level, skip a value equal to the previous one.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Same as Subsets, but sort first and inside the loop skip i > start with nums[i] == nums[i − 1]. That stops two branches at the same level from starting with the same value.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;   // same value, same level
            path.add(nums[i]);
            backtrack(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
```

</details>

## Complexity

- **Time:** O(n · 2^n).
- **Space:** O(n).

## Common mistake

⚠️ Skipping with i > 0 instead of i > start, which also removes valid subsets like [2, 2].

---

⬅️ [Previous: Subsets](./003-subsets.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: Permutations](./005-permutations.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
