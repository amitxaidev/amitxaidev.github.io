# 9. Combination Sum II

**LeetCode 40** · 🟡 Medium · Pattern: **Backtracking, use once, skip duplicates**
🔗 Solve it here: [https://leetcode.com/problems/combination-sum-ii/](https://leetcode.com/problems/combination-sum-ii/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/009-combination-sum-ii.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/009-combination-sum-ii.html)

## The problem, in short

Each candidate may be used at most once and the list may contain duplicates. Return all unique combinations that sum to target.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Recurse with i + 1 because each number is used once.

</details>

<details>
<summary>💡 Hint 2</summary>

Sort, and skip equal values at the same level (i > start).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Same template as Subsets II with a target: sort, skip duplicates at each level, break when the candidate exceeds the remaining sum.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > start && c[i] == c[i - 1]) continue;   // skip duplicate at this level
            path.add(c[i]);
            backtrack(c, i + 1, remaining - c[i], path, res);
            path.remove(path.size() - 1);
        }
    }
}
```

</details>

## Complexity

- **Time:** O(2^n) worst case.
- **Space:** O(n).

## Common mistake

⚠️ Using a HashSet of lists to de-duplicate — slow, and it hides the clean skip rule.

---

⬅️ [Previous: Combination Sum](./008-combination-sum.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: Letter Combinations of a Phone Number](./010-letter-combinations-of-a-phone-number.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
