# 19. Word Ladder

**LeetCode 127** · 🔴 Hard · Pattern: **BFS on implicit graph**
🔗 Solve it here: [https://leetcode.com/problems/word-ladder/](https://leetcode.com/problems/word-ladder/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/23-graphs/019-word-ladder.html](https://amitxaidev.github.io/dsa/23-graphs/019-word-ladder.html)

## The problem, in short

Transform beginWord into endWord by changing one letter at a time, where every intermediate word must be in wordList. Return the number of words in the shortest such sequence, or 0.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Words are nodes; an edge joins words that differ by one letter. Shortest path → BFS.

</details>

<details>
<summary>💡 Hint 2</summary>

Generate neighbours by trying all 26 letters at each position and checking a HashSet.

</details>

<details>
<summary>💡 Hint 3</summary>

Remove words from the set when you enqueue them to mark them visited.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

BFS level by level from beginWord. For each word, try every one-letter change; if it's endWord, return level + 1; if it's in the set, remove it and enqueue it.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int level = 1;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                char[] w = q.poll().toCharArray();
                for (int p = 0; p < w.length; p++) {
                    char orig = w[p];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == orig) continue;
                        w[p] = c;
                        String next = new String(w);
                        if (next.equals(endWord)) return level + 1;
                        if (words.remove(next)) q.offer(next);   // remove = mark visited
                    }
                    w[p] = orig;
                }
            }
            level++;
        }
        return 0;
    }
}
```

</details>

## Complexity

- **Time:** O(N · L · 26), N = words, L = word length.
- **Space:** O(N · L).

## Common mistake

⚠️ Comparing every pair of words to build edges — O(N² · L).

---

⬅️ [Previous: Accounts Merge](./018-accounts-merge.md) · [📋 Graphs list](./README.md) · [Next: Critical Connections in a Network](./020-critical-connections-in-a-network.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
