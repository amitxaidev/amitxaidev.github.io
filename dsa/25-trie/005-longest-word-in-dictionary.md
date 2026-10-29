# 5. Longest Word in Dictionary

**LeetCode 720** · 🟡 Medium · Pattern: **Trie walk through complete words**

## The problem, in short

Return the longest word that can be built one letter at a time where every prefix along the way is also a word in the list. On ties, return the alphabetically smallest.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/longest-word-in-dictionary/](https://leetcode.com/problems/longest-word-in-dictionary/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/25-trie/005-longest-word-in-dictionary.html](https://amitxaidev.github.io/dsa/25-trie/005-longest-word-in-dictionary.html)

## Understanding

**Really asking:** the longest word that can be built one letter at a time from other words.

**Why this works:** in the trie, only walk through nodes that end a word; every prefix is then also a word.

**Example:** ["w","wo","wor","worl","world"]
```text
w → wo → wor → worl → world ✓
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Insert every word into a trie.

</details>

<details>
<summary>💡 Hint 2</summary>

DFS only through nodes that end a word.

</details>

<details>
<summary>💡 Hint 3</summary>

Visit children in alphabetical order and only replace the answer with strictly longer words.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Build the trie storing the full word at its end node. DFS from the root, moving only into children marked as word ends; keep the longest word seen (first found wins ties, which is the smallest alphabetically).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    private static class Node {
        Node[] next = new Node[26];
        String word;   // set when a word ends here
    }

    private String best = "";

    public String longestWord(String[] words) {
        Node root = new Node();
        for (String w : words) {
            Node cur = root;
            for (char c : w.toCharArray()) {
                if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new Node();
                cur = cur.next[c - 'a'];
            }
            cur.word = w;
        }
        dfs(root);
        return best;
    }

    private void dfs(Node node) {
        for (Node child : node.next) {               // a..z order
            if (child == null || child.word == null) continue;   // prefix must be a word
            if (child.word.length() > best.length()) best = child.word;
            dfs(child);
        }
    }
}
```

</details>

## Complexity

- **Time:** O(total characters).
- **Space:** O(total characters).

## Common mistake

⚠️ Checking only that the full word exists, not every prefix.

---

⬅️ [Previous: Replace Words](./004-replace-words.md) · [📋 Trie list](./README.md) · [Next: Maximum XOR of Two Numbers in an Array](./006-maximum-xor-of-two-numbers-in-an-array.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
