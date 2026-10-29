# 4. Merge Two Sorted Lists

**LeetCode 21** · 🟢 Easy · Pattern: **Dummy head merge**

## The problem, in short

Merge two sorted linked lists into one sorted list by splicing their nodes together.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/merge-two-sorted-lists/](https://leetcode.com/problems/merge-two-sorted-lists/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/004-merge-two-sorted-lists.html](https://amitxaidev.github.io/dsa/17-linked-list/004-merge-two-sorted-lists.html)

## Understanding

**Really asking:** zip two sorted lists into one sorted list.

**Why this works:** the next node is always the smaller of the two heads; a dummy node holds the start.

**Example:** 1→2→4 and 1→3→4
```text
1, 1, 2, 3, 4, 4
```

## Hints

<details>
<summary>💡 Hint 1</summary>

A dummy node in front of the result avoids special-casing the head.

</details>

<details>
<summary>💡 Hint 2</summary>

Attach the smaller of the two current nodes, then move on in that list.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

tail starts at a dummy node. While both lists have nodes, link the smaller one after tail. Attach whatever is left at the end.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }  // provided by LeetCode
 */
class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) { tail.next = a; a = a.next; }
            else { tail.next = b; b = b.next; }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;   // leftovers are already sorted
        return dummy.next;
    }
}
```

</details>

## Complexity

- **Time:** O(n + m).
- **Space:** O(1).

## Common mistake

⚠️ Forgetting to attach the leftover list after the loop.

---

⬅️ [Previous: Linked List Cycle](./003-linked-list-cycle.md) · [📋 Linked List list](./README.md) · [Next: Intersection of Two Linked Lists](./005-intersection-of-two-linked-lists.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
