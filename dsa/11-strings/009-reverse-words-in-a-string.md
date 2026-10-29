# 9. Reverse Words in a String

**LeetCode 151** · 🟡 Medium · Pattern: **Split & rebuild**
🔗 Solve it here: [https://leetcode.com/problems/reverse-words-in-a-string/](https://leetcode.com/problems/reverse-words-in-a-string/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/11-strings/009-reverse-words-in-a-string.html](https://amitxaidev.github.io/dsa/11-strings/009-reverse-words-in-a-string.html)

## The problem, in short

Reverse the order of words in a string. Remove leading, trailing and repeated spaces.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

trim() then split on one or more spaces with "\\s+".

</details>

<details>
<summary>💡 Hint 2</summary>

Join the words from last to first with a single space.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Split into words, then append them in reverse order to a StringBuilder with single spaces in between. (A manual two-pointer scan from the end gives the same result without regex.)

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(' ');
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

⚠️ split(" ") on raw input produces empty strings for repeated spaces.

---

⬅️ [Previous: Group Anagrams](./008-group-anagrams.md) · [📋 Strings list](./README.md) · [Next: Longest Palindromic Substring](./010-longest-palindromic-substring.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
