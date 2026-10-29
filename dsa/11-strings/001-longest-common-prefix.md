# 1. Longest Common Prefix

**LeetCode 14** · 🟢 Easy · Pattern: **Vertical scan**
🔗 Solve it here: [https://leetcode.com/problems/longest-common-prefix/](https://leetcode.com/problems/longest-common-prefix/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/11-strings/001-longest-common-prefix.html](https://amitxaidev.github.io/dsa/11-strings/001-longest-common-prefix.html)

## The problem, in short

Return the longest prefix shared by every string in the array, or "" if there is none.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Compare character by character, column by column.

</details>

<details>
<summary>💡 Hint 2</summary>

Stop at the first column where a string ends or differs.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Take the first string as reference. For each index i, check that every other string has the same character at i. The first failure gives the prefix length.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }
}
```

</details>

## Complexity

- **Time:** O(total characters).
- **Space:** O(1) besides the output.

## Common mistake

⚠️ Forgetting that a shorter string can end before a mismatch — check the length first.

---

[📋 Strings list](./README.md) · [Next: Valid Anagram](./002-valid-anagram.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
