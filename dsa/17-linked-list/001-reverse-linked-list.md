# 1. Reverse Linked List

**LeetCode 206** · 🟢 Easy · Pattern: **Iterative pointer reversal**
🔗 Solve it here: [https://leetcode.com/problems/reverse-linked-list/](https://leetcode.com/problems/reverse-linked-list/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/001-reverse-linked-list.html](https://amitxaidev.github.io/dsa/17-linked-list/001-reverse-linked-list.html)

## The problem, in short

Reverse a singly linked list and return the new head.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Walk the list and flip each next pointer to point backwards.

</details>

<details>
<summary>💡 Hint 2</summary>

Keep three references: prev, cur and the saved next.

</details>

<details>
<summary>💡 Hint 3</summary>

Recursive version: reverse the rest, then make head.next point back to head.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

prev = null, cur = head. Save next = cur.next, set cur.next = prev, then move prev and cur forward. prev ends as the new head.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * Definition for singly-linked list (provided by LeetCode):
 * class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;   // save before breaking the link
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1) iterative (O(n) stack for the recursive version).

## Common mistake

⚠️ Overwriting cur.next before saving it, which loses the rest of the list.

---

[📋 Linked List list](./README.md) · [Next: Middle of the Linked List](./002-middle-of-the-linked-list.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
