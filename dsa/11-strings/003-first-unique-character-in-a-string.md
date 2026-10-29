# 3. First Unique Character in a String

**LeetCode 387** · 🟢 Easy · Pattern: **Frequency count**

## The problem, in short

Return the index of the first character that appears exactly once in the string, or -1.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/first-unique-character-in-a-string/](https://leetcode.com/problems/first-unique-character-in-a-string/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/11-strings/003-first-unique-character-in-a-string.html](https://amitxaidev.github.io/dsa/11-strings/003-first-unique-character-in-a-string.html)

## Understanding

**Really asking:** the first letter that appears exactly once.

**Why this works:** count all letters first, then scan in order for a count of 1.

**Example:** "loveleetcode"
```text
counts: l2 o2 v1 e4 …
first with count 1: 'v' at index 2
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Count every letter first.

</details>

<details>
<summary>💡 Hint 2</summary>

Then scan again in order and return the first index whose count is 1.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Two passes: frequency array, then the first position with frequency 1.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(26).

## Common mistake

⚠️ Scanning the count array in alphabetical order — you need the first by position in the string.

---

⬅️ [Previous: Valid Anagram](./002-valid-anagram.md) · [📋 Strings list](./README.md) · [Next: Roman to Integer](./004-roman-to-integer.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
