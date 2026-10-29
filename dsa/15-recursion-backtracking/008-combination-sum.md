# 8. Combination Sum

**LeetCode 39** · 🟡 Medium · Pattern: **Backtracking with reuse**

## The problem, in short

Return all unique combinations of candidates (distinct numbers, each usable unlimited times) that sum to target.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/combination-sum/](https://leetcode.com/problems/combination-sum/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/008-combination-sum.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/008-combination-sum.html)

## Understanding

**Really asking:** combinations that add to target, reusing numbers allowed.

**Why this works:** recurse with the same index to allow reuse; stop when a candidate is bigger than what's left.

**Example:** [2, 3, 6, 7], target 7
```text
2+2+3 = 7 ✓
7 = 7 ✓
```

## Hints

<details>
<summary>💡 Hint 1</summary>

To allow reuse, recurse with the same index i, not i + 1.

</details>

<details>
<summary>💡 Hint 2</summary>

Sort the candidates so you can stop as soon as one is bigger than what's left.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

backtrack(start, remaining): if remaining is 0, record. Loop i from start; break if candidates[i] > remaining; otherwise add it and recurse with (i, remaining − candidates[i]).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] c, int start, int remaining, List<Integer> path, List<List<Integer>> res) {
        if (remaining == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < c.length && c[i] <= remaining; i++) {
            path.add(c[i]);
            backtrack(c, i, remaining - c[i], path, res);   // i, not i+1: reuse allowed
            path.remove(path.size() - 1);
        }
    }
}
```

</details>

## Complexity

- **Time:** Exponential — bounded by the number of combinations explored.
- **Space:** O(target / min) recursion depth.

## Common mistake

⚠️ Recursing with start = 0 each time, which produces the same combination in different orders.

---

⬅️ [Previous: Combinations](./007-combinations.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: Combination Sum II](./009-combination-sum-ii.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
