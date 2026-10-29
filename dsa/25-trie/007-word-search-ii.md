# 7. Word Search II

**LeetCode 212** · 🔴 Hard · Pattern: **Trie-guided grid DFS**
🔗 Solve it here: [https://leetcode.com/problems/word-search-ii/](https://leetcode.com/problems/word-search-ii/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/25-trie/007-word-search-ii.html](https://amitxaidev.github.io/dsa/25-trie/007-word-search-ii.html)

## The problem, in short

Find every word from a list that can be traced in a letter grid by adjacent moves without reusing a cell.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Running Word Search once per word is too slow.

</details>

<details>
<summary>💡 Hint 2</summary>

Put all words in a trie and DFS the grid once, following trie edges.

</details>

<details>
<summary>💡 Hint 3</summary>

Remove found words from the trie (or clear the word) so you don't report them twice, and prune empty branches.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Build a trie storing the full word at its end node. DFS from every cell: move into the child for the cell's letter; if the node holds a word, record it and clear it. Mark cells while on the path and restore after.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    private static class Node {
        Node[] next = new Node[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for (String w : words) {
            Node cur = root;
            for (char c : w.toCharArray()) {
                if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new Node();
                cur = cur.next[c - 'a'];
            }
            cur.word = w;
        }
        List<String> res = new ArrayList<>();
        for (int r = 0; r < board.length; r++)
            for (int c = 0; c < board[0].length; c++)
                dfs(board, r, c, root, res);
        return res;
    }

    private void dfs(char[][] b, int r, int c, Node parent, List<String> res) {
        if (r < 0 || c < 0 || r >= b.length || c >= b[0].length || b[r][c] == '#') return;
        char ch = b[r][c];
        Node node = parent.next[ch - 'a'];
        if (node == null) return;                  // no word continues this way
        if (node.word != null) {
            res.add(node.word);
            node.word = null;                      // report once
        }
        b[r][c] = '#';
        dfs(b, r + 1, c, node, res);
        dfs(b, r - 1, c, node, res);
        dfs(b, r, c + 1, node, res);
        dfs(b, r, c - 1, node, res);
        b[r][c] = ch;
    }
}
```

</details>

## Complexity

- **Time:** O(m·n·4·3^(L−1)) worst case, much faster with pruning.
- **Space:** O(total characters in words).

## Common mistake

⚠️ Adding the same word several times when it can be traced in more than one way.

---

⬅️ [Previous: Maximum XOR of Two Numbers in an Array](./006-maximum-xor-of-two-numbers-in-an-array.md) · [📋 Trie list](./README.md) · [Next: Maximum XOR With an Element From Array](./008-maximum-xor-with-an-element-from-array.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
