# 4. Roman to Integer

**LeetCode 13** · 🟢 Easy · Pattern: **Look-ahead**
🔗 Solve it here: [https://leetcode.com/problems/roman-to-integer/](https://leetcode.com/problems/roman-to-integer/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/11-strings/004-roman-to-integer.html](https://amitxaidev.github.io/dsa/11-strings/004-roman-to-integer.html)

## The problem, in short

Convert a Roman numeral (I, V, X, L, C, D, M with subtractive pairs like IV and CM) to an integer.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Usually you add each symbol's value.

</details>

<details>
<summary>💡 Hint 2</summary>

If a symbol is smaller than the one after it, subtract it instead.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Map each symbol to its value. Walk left to right: subtract when the next symbol is larger, otherwise add.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int romanToInt(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = value(s.charAt(i));
            if (i + 1 < s.length() && v < value(s.charAt(i + 1))) total -= v;   // e.g. the I in IV
            else total += v;
        }
        return total;
    }

    private int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            default:  return 1000;
        }
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Hard-coding all six subtractive pairs with many if-statements — the "smaller before larger" rule covers them all.

---

⬅️ [Previous: First Unique Character in a String](./003-first-unique-character-in-a-string.md) · [📋 Strings list](./README.md) · [Next: Isomorphic Strings](./005-isomorphic-strings.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
