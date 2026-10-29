# 19. Word Break

**LeetCode 139** · 🟡 Medium · Pattern: **Prefix DP**
🔗 Solve it here: [https://leetcode.com/problems/word-break/](https://leetcode.com/problems/word-break/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/019-word-break.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/019-word-break.html)

## The problem, in short

Decide whether a string can be split into a sequence of words from a dictionary (words can be reused).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

ok[i] = the first i characters can be split.

</details>

<details>
<summary>💡 Hint 2</summary>

ok[i] is true if some j &lt; i has ok[j] and s[j..i) is a dictionary word.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Put the words in a HashSet. ok[0] = true. For each i, try j from i − 1 down to max(0, i − longestWord), stopping on the first success.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int maxLen = 0;
        for (String w : wordDict) maxLen = Math.max(maxLen, w.length());
        boolean[] ok = new boolean[s.length() + 1];
        ok[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxLen); j--) {
                if (ok[j] && dict.contains(s.substring(j, i))) {   // prefix ok + one more word
                    ok[i] = true;
                    break;
                }
            }
        }
        return ok[s.length()];
    }
}
```

</details>

## Complexity

- **Time:** O(n · L) substring checks, L = longest word.
- **Space:** O(n).

## Common mistake

⚠️ Greedy matching of the longest word first — it can block a valid split.

---

⬅️ [Previous: Best Time to Buy and Sell Stock with Transaction Fee](./018-best-time-to-buy-and-sell-stock-with-transaction-fee.md) · [📋 Dynamic Programming list](./README.md) · [Next: House Robber III](./020-house-robber-iii.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
