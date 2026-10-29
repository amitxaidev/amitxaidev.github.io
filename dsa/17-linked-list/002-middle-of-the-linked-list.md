# 2. Middle of the Linked List

**LeetCode 876** · 🟢 Easy · Pattern: **Fast & slow pointers**

## The problem, in short

Return the middle node of a linked list; for an even number of nodes, return the second of the two middle nodes.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/middle-of-the-linked-list/](https://leetcode.com/problems/middle-of-the-linked-list/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/002-middle-of-the-linked-list.html](https://amitxaidev.github.io/dsa/17-linked-list/002-middle-of-the-linked-list.html)

## Understanding

**Really asking:** the middle node (second middle for even length).

**Why this works:** fast moves 2 steps while slow moves 1; when fast reaches the end, slow is halfway.

**Example:** 1 → 2 → 3 → 4 → 5
```text
slow 1, fast 1 → slow 2, fast 3 → slow 3, fast 5 → stop
middle 3
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Move one pointer one step and another two steps at a time.

</details>

<details>
<summary>💡 Hint 2</summary>

When the fast one reaches the end, the slow one is in the middle.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

slow = fast = head; while fast and fast.next exist, advance slow by one and fast by two. Return slow.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class ListNode { int val; ListNode next; }  // provided by LeetCode
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Using the loop condition fast.next.next != null, which returns the first middle for even lengths.

---

⬅️ [Previous: Reverse Linked List](./001-reverse-linked-list.md) · [📋 Linked List list](./README.md) · [Next: Linked List Cycle](./003-linked-list-cycle.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
