# 6. Permutations II

**LeetCode 47** · 🟡 Medium · Pattern: **Backtracking with duplicate skip**

## The problem, in short

Return all distinct orderings of an array that may contain duplicates.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/permutations-ii/](https://leetcode.com/problems/permutations-ii/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/006-permutations-ii.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/006-permutations-ii.html)

## Understanding

**Really asking:** distinct orderings when numbers repeat.

**Why this works:** sort, and only use a duplicate if its earlier twin is already used. That fixes the order of equal values, so each arrangement is built once.

**Example:** [1, 1, 2]
```text
[1, 1, 2], [1, 2, 1], [2, 1, 1]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Sort first.

</details>

<details>
<summary>💡 Hint 2</summary>

Use a duplicate value only if its previous equal copy is already used in the current path.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Like Permutations, plus: skip nums[i] when i > 0, nums[i] == nums[i − 1] and !used[i − 1]. This forces equal values to be placed in index order, so each distinct permutation is built once.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;   // keep equal values in order
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, path, res);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
```

</details>

## Complexity

- **Time:** O(n · n!).
- **Space:** O(n).

## Common mistake

⚠️ Collecting into a Set to remove duplicates — it works, but generates n! permutations anyway.

---

⬅️ [Previous: Permutations](./005-permutations.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: Combinations](./007-combinations.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
