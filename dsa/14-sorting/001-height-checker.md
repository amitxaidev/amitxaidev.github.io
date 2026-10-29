# 1. Height Checker

**LeetCode 1051** · 🟢 Easy · Pattern: **Counting sort**
🔗 Solve it here: [https://leetcode.com/problems/height-checker/](https://leetcode.com/problems/height-checker/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/14-sorting/001-height-checker.html](https://amitxaidev.github.io/dsa/14-sorting/001-height-checker.html)

## The problem, in short

Students stand in a line. Count how many positions differ from where they'd be if the line were sorted by height (heights are 1..100).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Compare the array with its sorted copy.

</details>

<details>
<summary>💡 Hint 2</summary>

With heights only up to 100, counting sort builds the sorted order in O(n).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Count each height, then walk heights from 1 to 100 producing the expected order on the fly, comparing with the actual line.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for (int h : heights) count[h]++;
        int mismatches = 0, h = 1;
        for (int actual : heights) {
            while (count[h] == 0) h++;    // next height in sorted order
            if (actual != h) mismatches++;
            count[h]--;
        }
        return mismatches;
    }
}
```

</details>

## Complexity

- **Time:** O(n + 100).
- **Space:** O(100).

## Common mistake

⚠️ Sorting the original array in place and then comparing it with itself.

---

[📋 Sorting list](./README.md) · [Next: Sort Array by Increasing Frequency](./002-sort-array-by-increasing-frequency.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
