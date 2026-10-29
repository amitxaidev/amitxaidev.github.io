# 3. Sqrt(x)

**LeetCode 69** · 🟢 Easy · Pattern: **Binary search on the answer**

## The problem, in short

Return the integer square root of x (rounded down) without using a built-in power or sqrt function.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/sqrtx/](https://leetcode.com/problems/sqrtx/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/003-sqrtx.html](https://amitxaidev.github.io/dsa/13-binary-search/003-sqrtx.html)

## Understanding

**Really asking:** the biggest r with r × r ≤ x.

**Why this works:** "r² ≤ x" is true then false as r grows, so binary search r. Compare mid ≤ x / mid to avoid overflow.

**Example:** x = 8
```text
mid 2: 2 ≤ 4 ✓ → ans 2, go right
mid 3: 3 ≤ 2 ✗ → go left
answer 2
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The answer is the largest r with r × r &lt;= x.

</details>

<details>
<summary>💡 Hint 2</summary>

Binary search r in [0, x]; compare r with x / r to avoid overflow.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Search the answer space. If mid &lt;= x / mid, mid is feasible — record it and go right; otherwise go left.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int lo = 1, hi = x / 2, ans = 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid <= x / mid) {   // mid*mid <= x, without overflow
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}
```

</details>

## Complexity

- **Time:** O(log x).
- **Space:** O(1).

## Common mistake

⚠️ Computing mid * mid in int, which overflows for x near 2^31.

---

⬅️ [Previous: Search Insert Position](./002-search-insert-position.md) · [📋 Binary Search list](./README.md) · [Next: First Bad Version](./004-first-bad-version.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
