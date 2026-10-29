# 8. Remove Nth Node From End of List

**LeetCode 19** · 🟡 Medium · Pattern: **Gap of n between two pointers**

## The problem, in short

Remove the n-th node from the end of a linked list in one pass and return the head.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/remove-nth-node-from-end-of-list/](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/008-remove-nth-node-from-end-of-list.html](https://amitxaidev.github.io/dsa/17-linked-list/008-remove-nth-node-from-end-of-list.html)

## Understanding

**Really asking:** delete the n-th node counted from the end, in one pass.

**Why this works:** move fast n steps ahead; then move both. When fast hits the end, slow sits right before the target.

**Example:** 1→2→3→4→5, n = 2
```text
fast ahead by 2
when fast is at 5, slow is at 3 → unlink 4 → 1→2→3→5
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Move a fast pointer n steps ahead first.

</details>

<details>
<summary>💡 Hint 2</summary>

Then move both until fast hits the last node; slow is just before the node to remove.

</details>

<details>
<summary>💡 Hint 3</summary>

A dummy node handles removing the head.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Start both at a dummy. Advance fast n times, then both together until fast.next is null. Unlink slow.next.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }  // provided by LeetCode
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i < n; i++) fast = fast.next;   // open a gap of n
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ No dummy node — removing the first node (n = length) crashes or returns the wrong head.

---

⬅️ [Previous: Remove Duplicates from Sorted List](./007-remove-duplicates-from-sorted-list.md) · [📋 Linked List list](./README.md) · [Next: Linked List Cycle II](./009-linked-list-cycle-ii.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
