# 12. Remove K Digits

**LeetCode 402** · 🟡 Medium · Pattern: **Monotonic increasing stack**
🔗 Solve it here: [https://leetcode.com/problems/remove-k-digits/](https://leetcode.com/problems/remove-k-digits/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/012-remove-k-digits.html](https://amitxaidev.github.io/dsa/18-stack-queue/012-remove-k-digits.html)

## The problem, in short

Remove k digits from a number string to make the smallest possible number. Return it without leading zeros ("0" if empty).

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

A digit followed by a smaller digit should be removed — that makes an earlier position smaller.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep the kept digits increasing using a stack.

</details>

<details>
<summary>💡 Hint 3</summary>

If removals are left at the end, remove from the tail.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

For each digit, while k > 0 and the last kept digit is bigger, pop it and decrement k. Append the digit. Trim k more from the end, strip leading zeros, return "0" if nothing is left.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder st = new StringBuilder();   // used as a stack
        for (char c : num.toCharArray()) {
            while (k > 0 && st.length() > 0 && st.charAt(st.length() - 1) > c) {
                st.deleteCharAt(st.length() - 1);   // bigger digit before a smaller one: remove it
                k--;
            }
            st.append(c);
        }
        st.setLength(st.length() - k);            // leftover removals from the end
        int i = 0;
        while (i < st.length() && st.charAt(i) == '0') i++;
        String res = st.substring(i);
        return res.isEmpty() ? "0" : res;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n).

## Common mistake

⚠️ Forgetting leading zeros or the "0" for an empty result.

---

⬅️ [Previous: Asteroid Collision](./011-asteroid-collision.md) · [📋 Stack & Queue list](./README.md) · [Next: Sum of Subarray Minimums](./013-sum-of-subarray-minimums.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
