# 8. Group Anagrams

**LeetCode 49** · 🟡 Medium · Pattern: **Canonical key + HashMap**
🔗 Solve it here: [https://leetcode.com/problems/group-anagrams/](https://leetcode.com/problems/group-anagrams/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/11-strings/008-group-anagrams.html](https://amitxaidev.github.io/dsa/11-strings/008-group-anagrams.html)

## The problem, in short

Group the strings so that anagrams end up in the same group.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

All anagrams share the same sorted form.

</details>

<details>
<summary>💡 Hint 2</summary>

Use that sorted form (or a letter-count signature) as a HashMap key.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each word, build a key (sorted characters) and add the word to map[key]. Return the map's values.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);   // same key for all anagrams
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(groups.values());
    }
}
```

</details>

## Complexity

- **Time:** O(n · k log k), k = max word length (O(n·k) with a count key).
- **Space:** O(n · k).

## Common mistake

⚠️ Using the char[] itself as a map key — arrays use identity equality. Convert to a String.

---

⬅️ [Previous: Ransom Note](./007-ransom-note.md) · [📋 Strings list](./README.md) · [Next: Reverse Words in a String](./009-reverse-words-in-a-string.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
