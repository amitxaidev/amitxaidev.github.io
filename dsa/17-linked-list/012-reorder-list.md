# 12. Reorder List

**LeetCode 143** · 🟡 Medium · Pattern: **Middle + reverse + weave**
🔗 Solve it here: [https://leetcode.com/problems/reorder-list/](https://leetcode.com/problems/reorder-list/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/012-reorder-list.html](https://amitxaidev.github.io/dsa/17-linked-list/012-reorder-list.html)

## The problem, in short

Reorder L0 → L1 → … → Ln into L0 → Ln → L1 → Ln−1 → … in place.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Split the list at the middle.

</details>

<details>
<summary>💡 Hint 2</summary>

Reverse the second half.

</details>

<details>
<summary>💡 Hint 3</summary>

Weave the two halves together one node at a time.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Combine three basic routines: find middle (slow/fast), reverse the second half after cutting, then alternately link nodes from the first and the reversed second half.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class ListNode { int val; ListNode next; }  // provided by LeetCode
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverse(slow.next);
        slow.next = null;                          // cut
        ListNode first = head;
        while (second != null) {                   // weave
            ListNode n1 = first.next, n2 = second.next;
            first.next = second;
            second.next = n1;
            first = n1;
            second = n2;
        }
    }

    private ListNode reverse(ListNode cur) {
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
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
- **Space:** O(1).

## Common mistake

⚠️ Not cutting the first half (mid.next = null), which creates a cycle.

---

⬅️ [Previous: Odd Even Linked List](./011-odd-even-linked-list.md) · [📋 Linked List list](./README.md) · [Next: Reverse Linked List II](./013-reverse-linked-list-ii.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
