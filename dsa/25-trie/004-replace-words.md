# 4. Replace Words

**LeetCode 648** · 🟡 Medium · Pattern: **Shortest root in a trie**
🔗 Solve it here: [https://leetcode.com/problems/replace-words/](https://leetcode.com/problems/replace-words/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/25-trie/004-replace-words.html](https://amitxaidev.github.io/dsa/25-trie/004-replace-words.html)

## The problem, in short

Given a list of roots and a sentence, replace every word that starts with a root by the shortest such root.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Insert all roots into a trie.

</details>

<details>
<summary>💡 Hint 2</summary>

For each word, walk the trie and stop at the first node that ends a root.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Build the trie. For each word, walk character by character; if a root ends, use the prefix up to there; if the path breaks, keep the word.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    private static class Node {
        Node[] next = new Node[26];
        boolean end;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        for (String r : dictionary) {
            Node cur = root;
            for (char c : r.toCharArray()) {
                if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new Node();
                cur = cur.next[c - 'a'];
            }
            cur.end = true;
        }
        StringBuilder sb = new StringBuilder();
        for (String w : sentence.split(" ")) {
            if (sb.length() > 0) sb.append(' ');
            Node cur = root;
            int i = 0;
            while (i < w.length() && cur.next[w.charAt(i) - 'a'] != null && !cur.end) {
                cur = cur.next[w.charAt(i) - 'a'];
                i++;
            }
            sb.append(cur.end ? w.substring(0, i) : w);   // shortest root found, or keep the word
        }
        return sb.toString();
    }
}
```

</details>

## Complexity

- **Time:** O(total characters).
- **Space:** O(total root characters).

## Common mistake

⚠️ Checking every root against every word with startsWith — O(words × roots × length).

---

⬅️ [Previous: Search Suggestions System](./003-search-suggestions-system.md) · [📋 Trie list](./README.md) · [Next: Longest Word in Dictionary](./005-longest-word-in-dictionary.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
