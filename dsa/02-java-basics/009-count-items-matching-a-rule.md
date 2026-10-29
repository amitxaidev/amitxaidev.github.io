# 9. Count Items Matching a Rule

**LeetCode 1773** · 🟢 Easy · Pattern: **List of lists**
🔗 Solve it here: [https://leetcode.com/problems/count-items-matching-a-rule/](https://leetcode.com/problems/count-items-matching-a-rule/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/02-java-basics/009-count-items-matching-a-rule.html](https://amitxaidev.github.io/dsa/02-java-basics/009-count-items-matching-a-rule.html)

## The problem, in short

Each item is a list [type, color, name]. Given a rule key ("type", "color" or "name") and a value, count items whose matching field equals the value.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Map the rule key to an index 0, 1 or 2 once, before the loop.

</details>

<details>
<summary>💡 Hint 2</summary>

Compare strings with equals(), not ==.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Convert ruleKey to a column index, then loop over the items and compare item.get(index) with ruleValue.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int idx = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        int count = 0;
        for (List<String> item : items) {
            if (item.get(idx).equals(ruleValue)) count++;
        }
        return count;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Using == on Strings, which compares references and can fail even when the text matches.

---

⬅️ [Previous: Shuffle String](./008-shuffle-string.md) · [📋 Java Basics for DSA list](./README.md) · [Next: Insert Delete GetRandom O(1)](./010-insert-delete-getrandom-o1.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
