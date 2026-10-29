# 11. Partition Labels

**LeetCode 763** · 🟡 Medium · Pattern: **Last occurrence**

## The problem, in short

Split a string into as many parts as possible so each letter appears in at most one part. Return the part sizes.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/partition-labels/](https://leetcode.com/problems/partition-labels/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/22-greedy/011-partition-labels.html](https://amitxaidev.github.io/dsa/22-greedy/011-partition-labels.html)

## Understanding

**Really asking:** cut the string into as many parts as possible with no letter in two parts.

**Why this works:** a part must reach the last occurrence of every letter inside it; cut when the scan reaches that point.

**Example:** "ababcbacadefegdehijhklij"
```text
first part ends at last 'a' (index 8) → 9
then "defegde" → 7, then "hijhklij" → 8
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Record the last index of every letter.

</details>

<details>
<summary>💡 Hint 2</summary>

While scanning, a part must extend at least to the last index of every letter in it.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep end = max last-index seen in the current part. When i reaches end, close the part and start a new one.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) last[s.charAt(i) - 'a'] = i;
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {            // everything in the part ends here
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(26).

## Common mistake

⚠️ Closing a part at the last index of only its first letter.

---

⬅️ [Previous: Insert Interval](./010-insert-interval.md) · [📋 Greedy list](./README.md) · [Next: Valid Parenthesis String](./012-valid-parenthesis-string.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
