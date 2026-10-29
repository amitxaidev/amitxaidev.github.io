# 7. Combinations

**LeetCode 77** · 🟡 Medium · Pattern: **Backtracking with pruning**

## The problem, in short

Return all ways to choose k numbers from 1..n (order doesn't matter).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/combinations/](https://leetcode.com/problems/combinations/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/007-combinations.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/007-combinations.html)

## Understanding

**Really asking:** all ways to choose k numbers from 1..n.

**Why this works:** pick in increasing order so each set appears once; stop early when not enough numbers remain.

**Example:** n = 4, k = 2
```text
[1,2] [1,3] [1,4] [2,3] [2,4] [3,4]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Pick numbers in increasing order so each combination is built once.

</details>

<details>
<summary>💡 Hint 2</summary>

Prune: if not enough numbers remain to reach size k, stop.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

backtrack(start): if the path has k numbers, record it. Otherwise try i from start up to n − (k − size) + 1, which is the last start that can still fill the path.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int n, int k, int start, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {   // enough numbers left?
            path.add(i);
            backtrack(n, k, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
```

</details>

## Complexity

- **Time:** O(k · C(n, k)).
- **Space:** O(k).

## Common mistake

⚠️ No pruning — still correct, but explores many dead branches.

---

⬅️ [Previous: Permutations II](./006-permutations-ii.md) · [📋 Recursion & Backtracking list](./README.md) · [Next: Combination Sum](./008-combination-sum.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
