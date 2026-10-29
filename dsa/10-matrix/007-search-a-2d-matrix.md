# 7. Search a 2D Matrix

**LeetCode 74** · 🟡 Medium · Pattern: **Binary search on flattened index**

## The problem, in short

Each row is sorted and each row starts with a value larger than the previous row's last value. Decide if target is in the matrix in O(log(m·n)).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/search-a-2d-matrix/](https://leetcode.com/problems/search-a-2d-matrix/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/10-matrix/007-search-a-2d-matrix.html](https://amitxaidev.github.io/dsa/10-matrix/007-search-a-2d-matrix.html)

## Understanding

**Really asking:** find a value in a matrix that is sorted row after row.

**Why this works:** read row by row it's one sorted list, so binary search over index k = r·n + c.

**Example:** target 3 in [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
```text
mid index 5 → (1,1) = 11 > 3 → left
mid index 2 → (0,2) = 5 > 3 → left
mid index 0 → 1 < 3 → right; index 1 → 3 ✓
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Read row by row, the matrix is one sorted list of m·n numbers.

</details>

<details>
<summary>💡 Hint 2</summary>

Index k in that list is matrix[k / n][k % n].

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Binary search over 0..m·n−1, converting each mid to row and column.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int v = matrix[mid / n][mid % n];   // flattened index -> cell
            if (v == target) return true;
            if (v < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}
```

</details>

## Complexity

- **Time:** O(log(m·n)).
- **Space:** O(1).

## Common mistake

⚠️ Using k / m and k % m — divide by the number of columns, n.

---

⬅️ [Previous: Set Matrix Zeroes](./006-set-matrix-zeroes.md) · [📋 2D Arrays & Matrix list](./README.md) · [Next: Search a 2D Matrix II](./008-search-a-2d-matrix-ii.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
