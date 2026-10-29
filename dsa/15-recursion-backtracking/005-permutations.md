# 5. Permutations

**LeetCode 46** · 🟡 Medium · Pattern: **Backtracking with used[]**
🔗 Solve it here: [https://leetcode.com/problems/permutations/](https://leetcode.com/problems/permutations/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/005-permutations.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/005-permutations.html)

## The problem, in short

Return all orderings of an array of distinct integers.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Build the permutation one position at a time.

</details>

<details>
<summary>💡 Hint 2</summary>

Track which elements are already used.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

At each level try every unused element, mark it used, recurse, then unmark. When the path has n elements, record a copy.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, path, res);
            path.remove(path.size() - 1);
            used[i] = false;                   // undo
        }
    }
}
```

</details>

## Complexity

- **Time:** O(n · n!).
- **Space:** O(n).

## Common mistake

⚠️ Forgetting to unmark used[i] after the recursive call.

---

⬅️ [Previous: Subsets II](./004-subsets-ii.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: Permutations II](./006-permutations-ii.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
