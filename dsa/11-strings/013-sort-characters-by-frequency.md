# 13. Sort Characters By Frequency

**LeetCode 451** · 🟡 Medium · Pattern: **Count + bucket**
🔗 Solve it here: [https://leetcode.com/problems/sort-characters-by-frequency/](https://leetcode.com/problems/sort-characters-by-frequency/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/11-strings/013-sort-characters-by-frequency.html](https://amitxaidev.github.io/dsa/11-strings/013-sort-characters-by-frequency.html)

## The problem, in short

Rearrange a string so characters appear in decreasing order of frequency (equal characters grouped together).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Count each character.

</details>

<details>
<summary>💡 Hint 2</summary>

Bucket characters by count (counts are at most n), then read buckets from high to low.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Frequency array, then a list of buckets indexed by count. Walk buckets from n down to 1 and append each character count times.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public String frequencySort(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) count[c]++;
        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) buckets.add(new ArrayList<>());
        for (int c = 0; c < 128; c++) if (count[c] > 0) buckets.get(count[c]).add((char) c);
        StringBuilder sb = new StringBuilder();
        for (int f = s.length(); f > 0; f--) {
            for (char c : buckets.get(f)) {
                for (int k = 0; k < f; k++) sb.append(c);
            }
        }
        return sb.toString();
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Sorting a Character[] with a comparator on the fly — works, but O(n log n) and easy to get the tie handling wrong.

---

⬅️ [Previous: Palindromic Substrings](./012-palindromic-substrings.md) · [📋 Strings list](./README.md) · [Next: Integer to Roman](./014-integer-to-roman.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
