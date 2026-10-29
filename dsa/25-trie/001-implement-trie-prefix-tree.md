# 1. Implement Trie (Prefix Tree)

**LeetCode 208** · 🟡 Medium · Pattern: **Trie basics**

## The problem, in short

Build a trie with insert(word), search(word) (exact word) and startsWith(prefix).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/implement-trie-prefix-tree/](https://leetcode.com/problems/implement-trie-prefix-tree/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/25-trie/001-implement-trie-prefix-tree.html](https://amitxaidev.github.io/dsa/25-trie/001-implement-trie-prefix-tree.html)

## Understanding

**Really asking:** build insert, search and startsWith.

**Why this works:** walk one node per letter; search also needs the end flag, startsWith doesn't.

**Example:** insert "apple"
```text
search "app" → path exists, but no end flag → false
startsWith "app" → true
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Each node has up to 26 children and a flag saying "a word ends here".

</details>

<details>
<summary>💡 Hint 2</summary>

search and startsWith walk the same way; they differ only in whether the end flag is required.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Node with TrieNode[26] children and boolean end. insert creates missing children along the path and sets end. A shared walk(s) helper returns the node reached, or null.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Trie {
    private static class Node {
        Node[] next = new Node[26];
        boolean end;
    }

    private final Node root = new Node();

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.next[i] == null) cur.next[i] = new Node();
            cur = cur.next[i];
        }
        cur.end = true;   // a whole word ends here
    }

    public boolean search(String word) {
        Node n = walk(word);
        return n != null && n.end;
    }

    public boolean startsWith(String prefix) {
        return walk(prefix) != null;
    }

    private Node walk(String s) {
        Node cur = root;
        for (char c : s.toCharArray()) {
            cur = cur.next[c - 'a'];
            if (cur == null) return null;
        }
        return cur;
    }
}
```

</details>

## Complexity

- **Time:** O(L) per operation.
- **Space:** O(total characters inserted).

## Common mistake

⚠️ Returning true from search when the word is only a prefix of an inserted word — check the end flag.

---

[📋 Trie list](./README.md) · [Next: Design Add and Search Words Data Structure](./002-design-add-and-search-words-data-structure.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
