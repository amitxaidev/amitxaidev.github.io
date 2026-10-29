# 6. Largest Number

**LeetCode 179** · 🟡 Medium · Pattern: **Comparator on concatenation**
🔗 Solve it here: [https://leetcode.com/problems/largest-number/](https://leetcode.com/problems/largest-number/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/14-sorting/006-largest-number.html](https://amitxaidev.github.io/dsa/14-sorting/006-largest-number.html)

## The problem, in short

Arrange non-negative integers so that, written side by side, they form the largest possible number. Return it as a string.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Normal numeric sorting fails: 9 should come before 34, and 3 before 30.

</details>

<details>
<summary>💡 Hint 2</summary>

Put a before b if a + b (as strings) is bigger than b + a.

</details>

<details>
<summary>💡 Hint 3</summary>

If the biggest piece is "0", the answer is "0".

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Convert to strings, sort with comparator (x, y) -> (y + x).compareTo(x + y), join, and handle the all-zeros case.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) s[i] = String.valueOf(nums[i]);
        Arrays.sort(s, (x, y) -> (y + x).compareTo(x + y));   // larger concatenation first
        if (s[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String x : s) sb.append(x);
        return sb.toString();
    }
}
```

</details>

## Complexity

- **Time:** O(n log n · k), k = digits per number.
- **Space:** O(n · k).

## Common mistake

⚠️ Returning "000" for all-zero input instead of "0".

---

⬅️ [Previous: Sort List](./005-sort-list.md) · [📋 Sorting list](./README.md) · [Next: Merge Intervals](./007-merge-intervals.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
