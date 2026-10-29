# 1. Find the Highest Altitude

**LeetCode 1732** · 🟢 Easy · Pattern: **Running sum**

## The problem, in short

A biker starts at altitude 0. gain[i] is the change in altitude between point i and point i + 1. Return the highest altitude reached.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/find-the-highest-altitude/](https://leetcode.com/problems/find-the-highest-altitude/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/06-prefix-sum/001-find-the-highest-altitude.html](https://amitxaidev.github.io/dsa/06-prefix-sum/001-find-the-highest-altitude.html)

## Understanding

**Really asking:** the altitude after each step is a running total of the gains; what's the highest point?

**Why this works:** keep the running total and its maximum; the start (0) counts too.

**Example:** gain = [-5, 1, 5, 0, -7]
```text
altitudes: 0, -5, -4, 1, 1, -6
highest = 1
```

## Hints

<details>
<summary>💡 Hint 1</summary>

The altitude at each point is a prefix sum of the gains.

</details>

<details>
<summary>💡 Hint 2</summary>

Don't forget the starting altitude 0 is also a candidate.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep a running altitude and the maximum, starting both at 0.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int largestAltitude(int[] gain) {
        int alt = 0, best = 0;   // start point counts
        for (int g : gain) {
            alt += g;
            best = Math.max(best, alt);
        }
        return best;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Initialising the maximum to the first gain — if all gains are negative, the answer is 0.

---

[📋 Prefix Sum list](./README.md) · [Next: Range Sum Query - Immutable](./002-range-sum-query-immutable.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
