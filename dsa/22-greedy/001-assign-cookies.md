# 1. Assign Cookies

**LeetCode 455** · 🟢 Easy · Pattern: **Sort + match smallest**
🔗 Solve it here: [https://leetcode.com/problems/assign-cookies/](https://leetcode.com/problems/assign-cookies/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/22-greedy/001-assign-cookies.html](https://amitxaidev.github.io/dsa/22-greedy/001-assign-cookies.html)

## The problem, in short

Each child needs a cookie of at least their greed size; each cookie has a size and goes to at most one child. Maximise the number of content children.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Sort both arrays.

</details>

<details>
<summary>💡 Hint 2</summary>

Give each child the smallest cookie that satisfies them.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Two pointers over sorted greed and sizes: if the current cookie satisfies the current child, both move on; otherwise try the next (bigger) cookie.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        for (int cookie = 0; cookie < s.length && child < g.length; cookie++) {
            if (s[cookie] >= g[child]) child++;   // smallest cookie that fits
        }
        return child;
    }
}
```

</details>

## Complexity

- **Time:** O(n log n + m log m).
- **Space:** O(1) besides sorting.

## Common mistake

⚠️ Giving the biggest cookie to the first child — it might be needed for a greedier child.

---

[📋 Greedy list](./README.md) · [Next: Lemonade Change](./002-lemonade-change.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
