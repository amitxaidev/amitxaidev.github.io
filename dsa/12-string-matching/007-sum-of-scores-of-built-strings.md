# 7. Sum of Scores of Built Strings

**LeetCode 2223** · 🔴 Hard · Pattern: **Z-algorithm**

## The problem, in short

The string is built by adding characters to the front one at a time. Each intermediate string's score is the length of the longest common prefix it shares with the final string. Return the sum of all scores.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/sum-of-scores-of-built-strings/](https://leetcode.com/problems/sum-of-scores-of-built-strings/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/12-string-matching/007-sum-of-scores-of-built-strings.html](https://amitxaidev.github.io/dsa/12-string-matching/007-sum-of-scores-of-built-strings.html)

## Understanding

**Really asking:** for every suffix, how long a prefix of the full string does it start with? Add those up.

**Why this works:** that's exactly the Z-array, which the Z-algorithm builds in O(n) by reusing the furthest match window.

**Example:** "babab"
```text
z = [5, 0, 3, 0, 1]
sum = 9
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Each intermediate string is a suffix of the final string.

</details>

<details>
<summary>💡 Hint 2</summary>

The score of the suffix starting at i is exactly z[i] from the Z-algorithm.

</details>

<details>
<summary>💡 Hint 3</summary>

The full string itself scores n.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Compute the Z-array in O(n) using the [l, r] window of the rightmost match found so far. Sum z[1..n-1] plus n, using a long.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public long sumScores(String s) {
        int n = s.length();
        int[] z = new int[n];
        long total = n;                      // the whole string scores n
        for (int i = 1, l = 0, r = 0; i < n; i++) {
            if (i < r) z[i] = Math.min(r - i, z[i - l]);   // reuse the known window
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) z[i]++;
            if (i + z[i] > r) {
                l = i;
                r = i + z[i];
            }
            total += z[i];
        }
        return total;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Using int for the sum — it can reach about n²/2 and overflow.

---

⬅️ [Previous: Longest Duplicate Substring](./006-longest-duplicate-substring.md) · [📋 String Pattern Matching list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
