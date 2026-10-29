# 18. Permutation Sequence

**LeetCode 60** · 🔴 Hard · Pattern: **Factorial number system**
🔗 Solve it here: [https://leetcode.com/problems/permutation-sequence/](https://leetcode.com/problems/permutation-sequence/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/15-recursion-backtracking/018-permutation-sequence.html](https://amitxaidev.github.io/dsa/15-recursion-backtracking/018-permutation-sequence.html)

## The problem, in short

The permutations of 1..n are listed in sorted order. Return the k-th one as a string.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Generating all permutations is n! — far too many.

</details>

<details>
<summary>💡 Hint 2</summary>

With n numbers, each choice of first digit covers (n−1)! permutations.

</details>

<details>
<summary>💡 Hint 3</summary>

(k − 1) / (n − 1)! tells you which remaining number comes first.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep a list of unused numbers and use k − 1 (0-based). For each position, idx = k / fact(remaining − 1); take that number out of the list; k %= fact(remaining − 1).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            nums.add(i);
        }
        k--;                                   // 0-based
        StringBuilder sb = new StringBuilder();
        for (int left = n; left >= 1; left--) {
            int idx = k / fact[left - 1];      // which block we're in
            sb.append(nums.remove(idx));
            k %= fact[left - 1];
        }
        return sb.toString();
    }
}
```

</details>

## Complexity

- **Time:** O(n²) because of list removals (n ≤ 9).
- **Space:** O(n).

## Common mistake

⚠️ Using 1-based k directly, which is off by one at block boundaries.

---

⬅️ [Previous: Sudoku Solver](./017-sudoku-solver.md) · [📋 Recursion & Backtracking list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
