# 1. Majority Element

**LeetCode 169** · 🟢 Easy · Pattern: **Moore's voting**
🔗 Solve it here: [https://leetcode.com/problems/majority-element/](https://leetcode.com/problems/majority-element/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/001-majority-element.html](https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/001-majority-element.html)

## The problem, in short

One value appears more than n/2 times. Return it, ideally in O(n) time and O(1) space.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Pair each majority vote against a different vote. Who survives?

</details>

<details>
<summary>💡 Hint 2</summary>

Keep a candidate and a counter: same value +1, different value −1, counter 0 → new candidate.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Boyer–Moore voting. Because the majority has more than half the votes, it can't be cancelled out completely, so the final candidate is the answer (guaranteed to exist here).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int x : nums) {
            if (count == 0) candidate = x;   // start a new vote
            count += (x == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Sorting and taking the middle — correct, but O(n log n). Interviewers expect the voting trick.

---

[📋 Kadane, Dutch Flag & Moore's Voting list](./README.md) · [Next: Sort Array By Parity](./002-sort-array-by-parity.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
