# 11. Odd Even Linked List

**LeetCode 328** · 🟡 Medium · Pattern: **Two chains, then join**
🔗 Solve it here: [https://leetcode.com/problems/odd-even-linked-list/](https://leetcode.com/problems/odd-even-linked-list/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/011-odd-even-linked-list.html](https://amitxaidev.github.io/dsa/17-linked-list/011-odd-even-linked-list.html)

## The problem, in short

Reorder a linked list so all nodes at odd positions (1st, 3rd, …) come first, followed by nodes at even positions, keeping relative order. O(1) extra space.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Build two chains as you walk: odd and even.

</details>

<details>
<summary>💡 Hint 2</summary>

Remember the head of the even chain to attach it at the end.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

odd = head, even = head.next, evenHead = even. While even and even.next exist, link odd to even.next and even to odd.next. Finally odd.next = evenHead.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class ListNode { int val; ListNode next; }  // provided by LeetCode
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;   // odds first, then evens
        return head;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Losing the even chain's head, so it can't be attached at the end.

---

⬅️ [Previous: Add Two Numbers](./010-add-two-numbers.md) · [📋 Linked List list](./README.md) · [Next: Reorder List](./012-reorder-list.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
