# 2. Design Add and Search Words Data Structure

**LeetCode 211** · 🟡 Medium · Pattern: **Trie + DFS for wildcards**
🔗 Solve it here: [https://leetcode.com/problems/design-add-and-search-words-data-structure/](https://leetcode.com/problems/design-add-and-search-words-data-structure/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/25-trie/002-design-add-and-search-words-data-structure.html](https://amitxaidev.github.io/dsa/25-trie/002-design-add-and-search-words-data-structure.html)

## The problem, in short

Support addWord(word) and search(pattern), where '.' in the pattern matches any one letter.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Store words in a trie.

</details>

<details>
<summary>💡 Hint 2</summary>

For '.', try every existing child — that's a DFS.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Same trie as before. search(pattern, i, node): at the end return node.end; for a letter go to that child; for '.', return true if any child succeeds.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class WordDictionary {
    private static class Node {
        Node[] next = new Node[26];
        boolean end;
    }

    private final Node root = new Node();

    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new Node();
            cur = cur.next[c - 'a'];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String w, int i, Node node) {
        if (node == null) return false;
        if (i == w.length()) return node.end;
        char c = w.charAt(i);
        if (c != '.') return dfs(w, i + 1, node.next[c - 'a']);
        for (Node child : node.next) {           // '.' tries every branch
            if (dfs(w, i + 1, child)) return true;
        }
        return false;
    }
}
```

</details>

## Complexity

- **Time:** O(L) to add; search is O(L) without dots, up to O(26^d · L) with d dots.
- **Space:** O(total characters).

## Common mistake

⚠️ Storing words in a list and regex-matching each one on every search.

---

⬅️ [Previous: Implement Trie (Prefix Tree)](./001-implement-trie-prefix-tree.md) · [📋 Trie list](./README.md) · [Next: Search Suggestions System](./003-search-suggestions-system.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
