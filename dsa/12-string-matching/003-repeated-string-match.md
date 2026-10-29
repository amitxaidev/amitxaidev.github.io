# 3. Repeated String Match

**LeetCode 686** · 🟡 Medium · Pattern: **Repeat + KMP search**
🔗 Solve it here: [https://leetcode.com/problems/repeated-string-match/](https://leetcode.com/problems/repeated-string-match/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/12-string-matching/003-repeated-string-match.html](https://amitxaidev.github.io/dsa/12-string-matching/003-repeated-string-match.html)

## The problem, in short

Return the fewest times you must repeat string a so that b becomes a substring of the result, or -1 if it's impossible.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

You need at least ceil(|b| / |a|) copies to be long enough.

</details>

<details>
<summary>💡 Hint 2</summary>

One more copy covers every possible starting offset. If b isn't found with that many, it never will be.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Repeat a until its length is at least |b|, check for b; if not found, add one more copy and check again. Use KMP (or indexOf) for the check.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        if (indexOf(sb.toString(), b) >= 0) return count;
        if (indexOf(sb.append(a).toString(), b) >= 0) return count + 1;   // one extra for the offset
        return -1;
    }

    // KMP search
    private int indexOf(String text, String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        for (int i = 1, len = 0; i < m; ) {
            if (pat.charAt(i) == pat.charAt(len)) lps[i++] = ++len;
            else if (len > 0) len = lps[len - 1];
            else lps[i++] = 0;
        }
        for (int i = 0, j = 0; i < text.length(); ) {
            if (text.charAt(i) == pat.charAt(j)) {
                i++;
                if (++j == m) return i - m;
            } else if (j > 0) j = lps[j - 1];
            else i++;
        }
        return -1;
    }
}
```

</details>

## Complexity

- **Time:** O(n + m) with KMP.
- **Space:** O(n + m).

## Common mistake

⚠️ Stopping at ceil(|b| / |a|) copies — b may start in the middle of a copy and need one extra.

---

⬅️ [Previous: Repeated Substring Pattern](./002-repeated-substring-pattern.md) · [📋 String Pattern Matching list](./README.md) · [Next: Longest Happy Prefix](./004-longest-happy-prefix.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
