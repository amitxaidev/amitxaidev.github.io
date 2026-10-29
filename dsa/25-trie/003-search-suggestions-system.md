# 3. Search Suggestions System

**LeetCode 1268** · 🟡 Medium · Pattern: **Trie with top-3 lists**
🔗 Solve it here: [https://leetcode.com/problems/search-suggestions-system/](https://leetcode.com/problems/search-suggestions-system/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/25-trie/003-search-suggestions-system.html](https://amitxaidev.github.io/dsa/25-trie/003-search-suggestions-system.html)

## The problem, in short

As each character of searchWord is typed, return up to three product names (alphabetically smallest) that start with the typed prefix.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Sort the products first.

</details>

<details>
<summary>💡 Hint 2</summary>

Insert them into a trie in sorted order; each node keeps the first three words that pass through it.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Build the trie from sorted products, appending each word to a node's list while the list has fewer than 3 entries. Then walk searchWord; once a character has no child, every later answer is empty.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    private static class Node {
        Node[] next = new Node[26];
        List<String> top = new ArrayList<>();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Node root = new Node();
        for (String p : products) {
            Node cur = root;
            for (char c : p.toCharArray()) {
                if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new Node();
                cur = cur.next[c - 'a'];
                if (cur.top.size() < 3) cur.top.add(p);   // sorted order: first 3 are smallest
            }
        }
        List<List<String>> res = new ArrayList<>();
        Node cur = root;
        for (char c : searchWord.toCharArray()) {
            cur = (cur == null) ? null : cur.next[c - 'a'];
            res.add(cur == null ? new ArrayList<>() : cur.top);
        }
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(total characters + m log m) for sorting.
- **Space:** O(total characters).

## Common mistake

⚠️ Forgetting to keep adding empty lists after the prefix stops matching.

---

⬅️ [Previous: Design Add and Search Words Data Structure](./002-design-add-and-search-words-data-structure.md) · [📋 Trie list](./README.md) · [Next: Replace Words](./004-replace-words.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
