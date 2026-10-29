# 5. Unique Number of Occurrences

**LeetCode 1207** · 🟢 Easy · Pattern: **HashMap + HashSet**
🔗 Solve it here: [https://leetcode.com/problems/unique-number-of-occurrences/](https://leetcode.com/problems/unique-number-of-occurrences/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/16-hashing/005-unique-number-of-occurrences.html](https://amitxaidev.github.io/dsa/16-hashing/005-unique-number-of-occurrences.html)

## The problem, in short

Return true if every distinct value in the array appears a different number of times.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Count each value with a HashMap.

</details>

<details>
<summary>💡 Hint 2</summary>

Put the counts in a HashSet; if a count repeats, return false.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Count frequencies, then check that the set of counts has the same size as the map.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) freq.merge(x, 1, Integer::sum);
        return new HashSet<>(freq.values()).size() == freq.size();
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Comparing Integer counts with == — values above 127 aren't cached and compare by reference. A set avoids that.

---

⬅️ [Previous: Word Pattern](./004-word-pattern.md) · [📋 Hashing list](./README.md) · [Next: Happy Number](./006-happy-number.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
