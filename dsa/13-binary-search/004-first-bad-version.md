# 4. First Bad Version

**LeetCode 278** · 🟢 Easy · Pattern: **First true**

## The problem, in short

Versions 1..n are good up to some point and bad after it. Using an isBadVersion(v) API, find the first bad version with as few calls as possible.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/first-bad-version/](https://leetcode.com/problems/first-bad-version/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/13-binary-search/004-first-bad-version.html](https://amitxaidev.github.io/dsa/13-binary-search/004-first-bad-version.html)

## Understanding

**Really asking:** versions go good, good, …, bad, bad. Find the first bad.

**Why this works:** if mid is bad, the answer is mid or before; if good, it's after.

**Example:** n = 5, first bad = 4
```text
mid 3 good → lo 4
mid 4 bad → hi 4 → answer 4
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The answers look like F F F T T T. Find the first T.

</details>

<details>
<summary>💡 Hint 2</summary>

If mid is bad, the answer is mid or earlier. If good, it's after mid.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Binary search with lo &lt; hi: bad mid → hi = mid, good mid → lo = mid + 1. When lo == hi, that's the first bad version.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/* The isBadVersion API is defined in the parent class VersionControl. */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) hi = mid;   // mid could be the first bad one
            else lo = mid + 1;
        }
        return lo;
    }
}
```

</details>

## Complexity

- **Time:** O(log n).
- **Space:** O(1).

## Common mistake

⚠️ (lo + hi) / 2 overflows when n is close to 2^31.

---

⬅️ [Previous: Sqrt(x)](./003-sqrtx.md) · [📋 Binary Search list](./README.md) · [Next: Kth Missing Positive Number](./005-kth-missing-positive-number.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
