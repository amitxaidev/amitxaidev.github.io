# 6. Maximum Number of Words Found in Sentences

**LeetCode 2114** · 🟢 Easy · Pattern: **String scanning**
🔗 Solve it here: [https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/](https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/02-java-basics/006-maximum-number-of-words-found-in-sentences.html](https://amitxaidev.github.io/dsa/02-java-basics/006-maximum-number-of-words-found-in-sentences.html)

## The problem, in short

Each sentence is words separated by single spaces. Return the largest word count among all sentences.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Words = spaces + 1 when words are separated by exactly one space.

</details>

<details>
<summary>💡 Hint 2</summary>

Counting spaces avoids creating arrays with split().

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each sentence count the spaces, add one, and keep the maximum. split(" ").length also works but allocates a new array for every sentence.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int mostWordsFound(String[] sentences) {
        int best = 0;
        for (String s : sentences) {
            int words = 1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') words++;
            }
            best = Math.max(best, words);
        }
        return best;
    }
}
```

</details>

## Complexity

- **Time:** O(total characters).
- **Space:** O(1).

## Common mistake

⚠️ Forgetting the +1 — three words have only two spaces.

---

⬅️ [Previous: Defanging an IP Address](./005-defanging-an-ip-address.md) · [📋 Java Basics for DSA list](./README.md) · [Next: Kids With the Greatest Number of Candies](./007-kids-with-the-greatest-number-of-candies.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
