# 7. Kids With the Greatest Number of Candies

**LeetCode 1431** · 🟢 Easy · Pattern: **Array & List**

## The problem, in short

Each kid has some candies. For each kid, say whether giving them all the extra candies would make their count at least as large as every other kid's.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/](https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/02-java-basics/007-kids-with-the-greatest-number-of-candies.html](https://amitxaidev.github.io/dsa/02-java-basics/007-kids-with-the-greatest-number-of-candies.html)

## Understanding

**Really asking:** if we give a kid all the extra candies, do they reach the current maximum?

**Why this works:** find the maximum once, then each kid is one comparison. Ties count as "greatest".

**Example:** candies = [2, 3, 5, 1, 3], extra = 3, max = 5
```text
2+3=5 ≥ 5 true
3+3=6 true, 5+3=8 true
1+3=4 false, 3+3=6 true
[true, true, true, false, true]
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Find the current maximum first.

</details>

<details>
<summary>💡 Hint 2</summary>

Kid i qualifies if candies[i] + extra >= max.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

One pass to find the maximum, a second pass to build a List&lt;Boolean>. Two separate passes are still O(n).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int c : candies) max = Math.max(max, c);
        List<Boolean> ans = new ArrayList<>();
        for (int c : candies) ans.add(c + extraCandies >= max);   // autoboxing boolean -> Boolean
        return ans;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n) for the output.

## Common mistake

⚠️ Using > instead of >=; tying with the maximum counts as "greatest".

---

⬅️ [Previous: Maximum Number of Words Found in Sentences](./006-maximum-number-of-words-found-in-sentences.md) · [📋 Java Basics for DSA list](./README.md) · [Next: Shuffle String](./008-shuffle-string.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
