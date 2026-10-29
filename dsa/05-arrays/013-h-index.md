# 13. H-Index

**LeetCode 274** · 🟡 Medium · Pattern: **Counting sort**
🔗 Solve it here: [https://leetcode.com/problems/h-index/](https://leetcode.com/problems/h-index/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/05-arrays/013-h-index.html](https://amitxaidev.github.io/dsa/05-arrays/013-h-index.html)

## The problem, in short

citations[i] is how many citations paper i has. The h-index is the largest h such that at least h papers have h or more citations each. Return it.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

The answer is between 0 and n, so citation counts above n can be treated as n.

</details>

<details>
<summary>💡 Hint 2</summary>

Bucket papers by citation count, then walk from high to low, accumulating how many papers have at least that many citations.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Count papers per citation value (capped at n). Scan h from n down to 0 keeping a running total of papers with ≥ h citations; the first h where the total reaches h is the answer.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n + 1];
        for (int c : citations) bucket[Math.min(c, n)]++;
        int papers = 0;
        for (int h = n; h >= 0; h--) {
            papers += bucket[h];          // papers with at least h citations
            if (papers >= h) return h;
        }
        return 0;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Off-by-one when sorting: after sorting ascending, the check is citations[i] >= n - i, not > .

---

⬅️ [Previous: Find the Duplicate Number](./012-find-the-duplicate-number.md) · [📋 Arrays list](./README.md) · [Next: First Missing Positive](./014-first-missing-positive.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
