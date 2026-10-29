# 3. Relative Sort Array

**LeetCode 1122** · 🟢 Easy · Pattern: **Counting sort**
🔗 Solve it here: [https://leetcode.com/problems/relative-sort-array/](https://leetcode.com/problems/relative-sort-array/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/14-sorting/003-relative-sort-array.html](https://amitxaidev.github.io/dsa/14-sorting/003-relative-sort-array.html)

## The problem, in short

Sort arr1 so its elements follow the order given by arr2. Elements not in arr2 go at the end in ascending order. Values are 0..1000.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Count every value in arr1.

</details>

<details>
<summary>💡 Hint 2</summary>

Emit values in arr2's order first, then the leftovers from 0 to 1000.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Counting sort with a custom order: first walk arr2 and write each value count times, then walk 0..1000 for the rest.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int x : arr1) count[x]++;
        int i = 0;
        for (int x : arr2) {
            while (count[x]-- > 0) arr1[i++] = x;   // arr2 order first
        }
        for (int x = 0; x <= 1000; x++) {
            while (count[x]-- > 0) arr1[i++] = x;   // leftovers ascending
        }
        return arr1;
    }
}
```

</details>

## Complexity

- **Time:** O(n + m + 1000).
- **Space:** O(1001).

## Common mistake

⚠️ Using a comparator with indexOf on arr2 for every comparison — O(m) per compare.

---

⬅️ [Previous: Sort Array by Increasing Frequency](./002-sort-array-by-increasing-frequency.md) · [📋 Sorting list](./README.md) · [Next: Sort an Array](./004-sort-an-array.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
