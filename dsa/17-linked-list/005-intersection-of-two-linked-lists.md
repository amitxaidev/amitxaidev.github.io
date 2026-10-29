# 5. Intersection of Two Linked Lists

**LeetCode 160** · 🟢 Easy · Pattern: **Two pointers switching lists**
🔗 Solve it here: [https://leetcode.com/problems/intersection-of-two-linked-lists/](https://leetcode.com/problems/intersection-of-two-linked-lists/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/005-intersection-of-two-linked-lists.html](https://amitxaidev.github.io/dsa/17-linked-list/005-intersection-of-two-linked-lists.html)

## The problem, in short

Two singly linked lists may merge at some node and share their tail. Return that first shared node, or null.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

If the lists had equal length, you'd walk them together.

</details>

<details>
<summary>💡 Hint 2</summary>

When pointer A reaches the end, send it to the head of B, and vice versa.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Both pointers travel lenA + lenB steps in total, so they line up and meet at the intersection (or both reach null at the same time if there is none).

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class ListNode { int val; ListNode next; }  // provided by LeetCode
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;   // switch lists at the end
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
}
```

</details>

## Complexity

- **Time:** O(n + m).
- **Space:** O(1).

## Common mistake

⚠️ Comparing values instead of node references — different nodes can hold equal values.

---

⬅️ [Previous: Merge Two Sorted Lists](./004-merge-two-sorted-lists.md) · [📋 Linked List list](./README.md) · [Next: Palindrome Linked List](./006-palindrome-linked-list.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
