# 1. Matrix Diagonal Sum

**LeetCode 1572** · 🟢 Easy · Pattern: **Index patterns**

## The problem, in short

Sum the primary and secondary diagonals of a square matrix, counting the centre only once when n is odd.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/matrix-diagonal-sum/](https://leetcode.com/problems/matrix-diagonal-sum/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/10-matrix/001-matrix-diagonal-sum.html](https://amitxaidev.github.io/dsa/10-matrix/001-matrix-diagonal-sum.html)

## Understanding

**Really asking:** add both diagonals, counting the centre once.

**Why this works:** one loop reads mat[i][i] and mat[i][n-1-i]; for odd n they meet in the middle.

**Example:** [[1,2,3],[4,5,6],[7,8,9]]
```text
primary 1+5+9 = 15, secondary 3+5+7 = 15
30 - 5 (centre twice) = 25
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Primary diagonal: mat[i][i]. Secondary: mat[i][n - 1 - i].

</details>

<details>
<summary>💡 Hint 2</summary>

They overlap only when i == n - 1 - i.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

One loop over i adding both diagonal cells, then subtract the centre once if n is odd.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i] + mat[i][n - 1 - i];
        }
        if (n % 2 == 1) sum -= mat[n / 2][n / 2];   // centre counted twice
        return sum;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Looping over all n² cells checking conditions — works, but O(n²).

---

[📋 2D Arrays & Matrix list](./README.md) · [Next: Transpose Matrix](./002-transpose-matrix.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
