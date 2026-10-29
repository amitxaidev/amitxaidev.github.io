# 5. Isomorphic Strings

**LeetCode 205** · 🟢 Easy · Pattern: **Two-way mapping**
🔗 Solve it here: [https://leetcode.com/problems/isomorphic-strings/](https://leetcode.com/problems/isomorphic-strings/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/11-strings/005-isomorphic-strings.html](https://amitxaidev.github.io/dsa/11-strings/005-isomorphic-strings.html)

## The problem, in short

Decide whether characters of s can be replaced one-to-one to get t (no two characters may map to the same character).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

A mapping s→t alone isn't enough: "ab" → "aa" would pass.

</details>

<details>
<summary>💡 Hint 2</summary>

Track the mapping in both directions.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Keep two arrays: s-char → t-char and t-char → s-char. For each position, if either existing mapping disagrees, return false; otherwise record both.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] st = new int[256], ts = new int[256];   // 0 = not mapped yet
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (st[a] == 0 && ts[b] == 0) {
                st[a] = b;
                ts[b] = a;
            } else if (st[a] != b || ts[b] != a) {
                return false;
            }
        }
        return true;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(charset).

## Common mistake

⚠️ Checking only one direction.

---

⬅️ [Previous: Roman to Integer](./004-roman-to-integer.md) · [📋 Strings list](./README.md) · [Next: Longest Palindrome](./006-longest-palindrome.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
