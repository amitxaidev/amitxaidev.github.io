# 6. Longest Duplicate Substring

**LeetCode 1044** · 🔴 Hard · Pattern: **Binary search + Rabin-Karp**

## The problem, in short

Return any longest substring that appears at least twice in s (occurrences may overlap), or "" if none.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/longest-duplicate-substring/](https://leetcode.com/problems/longest-duplicate-substring/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/12-string-matching/006-longest-duplicate-substring.html](https://amitxaidev.github.io/dsa/12-string-matching/006-longest-duplicate-substring.html)

## Understanding

**Really asking:** the longest piece that appears at least twice.

**Why this works:** if a length-L duplicate exists, shorter ones do too, so binary search L. For each L, rolling hashes find repeated windows quickly.

**Example:** "banana"
```text
L=3: "ana" appears at 1 and 3 ✓
L=4: "bana","anan","nana" all different ✗
answer "ana"
```

## Hints

<details>
<summary>💡 Hint 1</summary>

If a duplicate of length L exists, a duplicate of every shorter length exists too — binary search on L.

</details>

<details>
<summary>💡 Hint 2</summary>

To test a length L, hash every substring of length L with a rolling hash and look for a repeat.

</details>

<details>
<summary>💡 Hint 3</summary>

Confirm a hash hit by comparing the actual substrings, to rule out collisions.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Binary search L. For each L, compute Rabin-Karp hashes with a large modulus, store hash → list of start indexes, and on a hit compare characters with regionMatches. Keep the start of the longest found.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007L, BASE = 131;

    public String longestDupSubstring(String s) {
        int lo = 1, hi = s.length() - 1, bestStart = -1, bestLen = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int start = find(s, mid);
            if (start >= 0) {
                bestStart = start;
                bestLen = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return bestStart < 0 ? "" : s.substring(bestStart, bestStart + bestLen);
    }

    // returns a start index of a substring of length len that repeats, or -1
    private int find(String s, int len) {
        long hash = 0, power = 1;
        for (int i = 0; i < len; i++) {
            hash = (hash * BASE + s.charAt(i)) % MOD;
            power = power * BASE % MOD;
        }
        Map<Long, List<Integer>> seen = new HashMap<>();
        seen.computeIfAbsent(hash, k -> new ArrayList<>()).add(0);
        for (int i = len; i < s.length(); i++) {
            hash = (hash * BASE + s.charAt(i)) % MOD;
            hash = (hash - s.charAt(i - len) * power % MOD + MOD) % MOD;   // drop the old char
            int start = i - len + 1;
            List<Integer> list = seen.computeIfAbsent(hash, k -> new ArrayList<>());
            for (int other : list) {
                if (s.regionMatches(other, s, start, len)) return start;     // real match
            }
            list.add(start);
        }
        return -1;
    }
}
```

</details>

## Complexity

- **Time:** O(n log n) on average.
- **Space:** O(n).

## Common mistake

⚠️ Trusting hashes without verifying — collisions give wrong answers on big tests.

---

⬅️ [Previous: Shortest Palindrome](./005-shortest-palindrome.md) · [📋 String Pattern Matching list](./README.md) · [Next: Sum of Scores of Built Strings](./007-sum-of-scores-of-built-strings.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
