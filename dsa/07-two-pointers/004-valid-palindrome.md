# 4. Valid Palindrome

**LeetCode 125** · 🟢 Easy · Pattern: **Opposite ends**

## The problem, in short

Ignoring case and every character that isn't a letter or digit, decide whether a string reads the same both ways.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/valid-palindrome/](https://leetcode.com/problems/valid-palindrome/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/07-two-pointers/004-valid-palindrome.html](https://amitxaidev.github.io/dsa/07-two-pointers/004-valid-palindrome.html)

## Understanding

**Really asking:** ignoring case and symbols, does it read the same both ways?

**Why this works:** compare from both ends, skipping anything that isn't a letter or digit.

**Example:** "A man, a plan, a canal: Panama"
```text
'a' vs 'a', 'm' vs 'm', 'a' vs 'a' …
all pairs match → true
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Use one pointer at each end.

</details>

<details>
<summary>💡 Hint 2</summary>

Skip characters that aren't letters or digits with Character.isLetterOrDigit.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Move the left and right pointers inward, skipping non-alphanumeric characters, and compare lowercase versions. Any mismatch means false.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Building a cleaned copy of the string — fine, but it uses O(n) extra space you don't need.

---

⬅️ [Previous: Move Zeroes](./003-move-zeroes.md) · [📋 Two Pointers list](./README.md) · [Next: Squares of a Sorted Array](./005-squares-of-a-sorted-array.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
