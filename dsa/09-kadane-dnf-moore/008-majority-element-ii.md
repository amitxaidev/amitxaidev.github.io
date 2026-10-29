# 8. Majority Element II

**LeetCode 229** · 🟡 Medium · Pattern: **Extended Moore's voting**
🔗 Solve it here: [https://leetcode.com/problems/majority-element-ii/](https://leetcode.com/problems/majority-element-ii/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/008-majority-element-ii.html](https://amitxaidev.github.io/dsa/09-kadane-dnf-moore/008-majority-element-ii.html)

## The problem, in short

Return every value that appears more than n/3 times.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

At most two values can appear more than n/3 times.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep two candidates and two counters; a third value decrements both.

</details>

<details>
<summary>💡 Hint 3</summary>

Candidates aren't guaranteed — verify them with a second pass.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Voting with two slots. If x matches a candidate, increment its count; else if a count is 0, take that slot; else decrement both. Then count the two candidates for real and keep those above n/3.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0, c2 = 1, n1 = 0, n2 = 0;   // different starting candidates
        for (int x : nums) {
            if (x == c1) n1++;
            else if (x == c2) n2++;
            else if (n1 == 0) { c1 = x; n1 = 1; }
            else if (n2 == 0) { c2 = x; n2 = 1; }
            else { n1--; n2--; }
        }
        n1 = 0; n2 = 0;
        for (int x : nums) {
            if (x == c1) n1++;
            else if (x == c2) n2++;
        }
        List<Integer> res = new ArrayList<>();
        if (n1 > nums.length / 3) res.add(c1);
        if (n2 > nums.length / 3) res.add(c2);
        return res;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Skipping the verification pass; a candidate can survive voting without being a real majority.

---

⬅️ [Previous: Sort Colors](./007-sort-colors.md) · [📋 Kadane, Dutch Flag & Moore's Voting list](./README.md) · [Next: Maximum Subarray Sum with One Deletion](./009-maximum-subarray-sum-with-one-deletion.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
