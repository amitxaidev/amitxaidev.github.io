# 10. Add Two Numbers

**LeetCode 2** · 🟡 Medium · Pattern: **Digit-by-digit with carry**
🔗 Solve it here: [https://leetcode.com/problems/add-two-numbers/](https://leetcode.com/problems/add-two-numbers/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/010-add-two-numbers.html](https://amitxaidev.github.io/dsa/17-linked-list/010-add-two-numbers.html)

## The problem, in short

Two non-negative numbers are stored as linked lists with digits in reverse order (ones digit first). Return their sum as a list in the same format.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Add like on paper, starting from the ones digit — which is already the head.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep going while either list has nodes or there's a carry left.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Dummy head and a carry. Each step: sum = carry + digits available; append sum % 10; carry = sum / 10.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }  // provided by LeetCode
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            carry = sum / 10;
        }
        return dummy.next;
    }
}
```

</details>

## Complexity

- **Time:** O(max(n, m)).
- **Space:** O(max(n, m)) for the output.

## Common mistake

⚠️ Stopping when both lists end and forgetting a final carry (e.g. 5 + 5 = 10 needs a new node).

---

⬅️ [Previous: Linked List Cycle II](./009-linked-list-cycle-ii.md) · [📋 Linked List list](./README.md) · [Next: Odd Even Linked List](./011-odd-even-linked-list.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
