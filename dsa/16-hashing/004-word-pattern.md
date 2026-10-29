# 4. Word Pattern

**LeetCode 290** · 🟢 Easy · Pattern: **Two-way HashMap**

## The problem, in short

Decide whether a sentence follows a pattern of letters, where each letter maps to exactly one word and each word to exactly one letter.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/word-pattern/](https://leetcode.com/problems/word-pattern/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/16-hashing/004-word-pattern.html](https://amitxaidev.github.io/dsa/16-hashing/004-word-pattern.html)

## Understanding

**Really asking:** does each letter stand for exactly one word, and each word for one letter?

**Why this works:** two maps, one per direction; any conflict fails.

**Example:** "abba" and "dog cat cat dog"
```text
a→dog, b→cat, b→cat ✓, a→dog ✓ → true
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Split the sentence; the word count must equal the pattern length.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep char → word and word → char maps, and check both.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each position, if either map has a conflicting entry, return false; otherwise store both directions.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Character, String> cw = new HashMap<>();
        Map<String, Character> wc = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (cw.containsKey(c) && !cw.get(c).equals(w)) return false;
            if (wc.containsKey(w) && wc.get(w) != c) return false;
            cw.put(c, w);
            wc.put(w, c);
        }
        return true;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Checking only char → word, so "abba" with "dog dog dog dog" passes wrongly.

---

⬅️ [Previous: Intersection of Two Arrays](./003-intersection-of-two-arrays.md) · [📋 Hashing list](./README.md) · [Next: Unique Number of Occurrences](./005-unique-number-of-occurrences.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
