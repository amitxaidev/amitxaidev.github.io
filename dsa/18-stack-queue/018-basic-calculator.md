# 18. Basic Calculator

**LeetCode 224** · 🔴 Hard · Pattern: **Stack for parentheses and signs**

## The problem, in short

Evaluate a string expression with integers, + and -, unary minus, parentheses and spaces. No eval allowed.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/basic-calculator/](https://leetcode.com/problems/basic-calculator/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/18-stack-queue/018-basic-calculator.html](https://amitxaidev.github.io/dsa/18-stack-queue/018-basic-calculator.html)

## Understanding

**Really asking:** evaluate + and - with brackets.

**Why this works:** keep a running result and a sign. On '(' save them on the stack and start fresh; on ')' combine with the saved values.

**Example:** "1 - (2 + 3)"
```text
result 1, sign -
'(' saves (1, -) → inner 5
')' → 1 + (-1 × 5) = -4
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Without parentheses you only need a running result and the current sign.

</details>

<details>
<summary>💡 Hint 2</summary>

On '(' push the result and sign so far, then start fresh inside.

</details>

<details>
<summary>💡 Hint 3</summary>

On ')' finish the inner result, multiply by the saved sign and add the saved result.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Scan characters: build multi-digit numbers; on +/- add sign × number to result and set the new sign; on '(' push result and sign, reset; on ')' close the number, then result = savedResult + savedSign × result.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class Solution {
    public int calculate(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        int result = 0, sign = 1, num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                result += sign * num;
                num = 0;
                sign = (c == '+') ? 1 : -1;
            } else if (c == '(') {
                st.push(result);        // save the outer state
                st.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                result = st.pop() * result + st.pop();   // saved sign, then saved result
            }
        }
        return result + sign * num;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(n) for nested parentheses.

## Common mistake

⚠️ Forgetting to add the last number after the loop ends.

---

⬅️ [Previous: Sliding Window Maximum](./017-sliding-window-maximum.md) · [📋 Stack & Queue list](./README.md)

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
