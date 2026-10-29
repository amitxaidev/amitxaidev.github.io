# 15. String Compression

**LeetCode 443** · 🟡 Medium · Pattern: **Read/write pointers**
🔗 Solve it here: [https://leetcode.com/problems/string-compression/](https://leetcode.com/problems/string-compression/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/11-strings/015-string-compression.html](https://amitxaidev.github.io/dsa/11-strings/015-string-compression.html)

## The problem, in short

Compress a char array in place: each run of a repeated character becomes the character followed by the run length (only if the length is more than 1). Return the new length.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Read runs with one pointer, write results with another.

</details>

<details>
<summary>💡 Hint 2</summary>

Run lengths of 10 or more take several characters — write each digit.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each run, write the character, then, if the run is longer than 1, write the digits of its length. The write pointer never passes the read pointer, so it's safe in place.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int compress(char[] chars) {
        int write = 0, read = 0;
        while (read < chars.length) {
            char c = chars[read];
            int start = read;
            while (read < chars.length && chars[read] == c) read++;
            chars[write++] = c;
            int len = read - start;
            if (len > 1) {
                for (char d : String.valueOf(len).toCharArray()) chars[write++] = d;   // every digit
            }
        }
        return write;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Writing the count as a single char (char) count, which breaks for runs of 10+.

---

⬅️ [Previous: Integer to Roman](./014-integer-to-roman.md) · [📋 Strings list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
