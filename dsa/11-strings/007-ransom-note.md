# 7. Ransom Note

**LeetCode 383** · 🟢 Easy · Pattern: **Frequency count**
🔗 Solve it here: [https://leetcode.com/problems/ransom-note/](https://leetcode.com/problems/ransom-note/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/11-strings/007-ransom-note.html](https://amitxaidev.github.io/dsa/11-strings/007-ransom-note.html)

## The problem, in short

Decide whether the letters of magazine (each used at most once) are enough to write ransomNote.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Count the magazine's letters.

</details>

<details>
<summary>💡 Hint 2</summary>

Spend them on the note; if any count goes negative, it's impossible.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Frequency array from the magazine, then decrement for every note letter and fail on a negative.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) count[c - 'a']++;
        for (char c : ransomNote.toCharArray()) {
            if (--count[c - 'a'] < 0) return false;
        }
        return true;
    }
}
```

</details>

## Complexity

- **Time:** O(n + m).
- **Space:** O(26).

## Common mistake

⚠️ Using indexOf and replacing characters in strings — slow and messy.

---

⬅️ [Previous: Longest Palindrome](./006-longest-palindrome.md) · [📋 Strings list](./README.md) · [Next: Group Anagrams](./008-group-anagrams.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
