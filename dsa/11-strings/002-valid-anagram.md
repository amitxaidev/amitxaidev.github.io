# 2. Valid Anagram

**LeetCode 242** · 🟢 Easy · Pattern: **Frequency count**
🔗 Solve it here: [https://leetcode.com/problems/valid-anagram/](https://leetcode.com/problems/valid-anagram/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/11-strings/002-valid-anagram.html](https://amitxaidev.github.io/dsa/11-strings/002-valid-anagram.html)

## The problem, in short

Decide whether t is a rearrangement of s.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Anagrams have the same length and the same count of every letter.

</details>

<details>
<summary>💡 Hint 2</summary>

One int[26]: add for s, subtract for t.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

If lengths differ return false. Count up for s and down for t; every count must end at 0.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) if (c != 0) return false;
        return true;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(26).

## Common mistake

⚠️ Sorting both strings — works, but O(n log n) instead of O(n).

---

⬅️ [Previous: Longest Common Prefix](./001-longest-common-prefix.md) · [📋 Strings list](./README.md) · [Next: First Unique Character in a String](./003-first-unique-character-in-a-string.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
