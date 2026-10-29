# 7. Remove Duplicates from Sorted List

**LeetCode 83** · 🟢 Easy · Pattern: **In-place unlink**
🔗 Solve it here: [https://leetcode.com/problems/remove-duplicates-from-sorted-list/](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/007-remove-duplicates-from-sorted-list.html](https://amitxaidev.github.io/dsa/17-linked-list/007-remove-duplicates-from-sorted-list.html)

## The problem, in short

Delete duplicate nodes from a sorted linked list so each value appears once.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Duplicates are adjacent.

</details>

<details>
<summary>💡 Hint 2</summary>

If cur.next has the same value, skip it by pointing cur.next past it — and don't move cur yet.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Walk with cur; while cur.next has the same value, unlink it. Otherwise move cur forward.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class ListNode { int val; ListNode next; }  // provided by LeetCode
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) cur.next = cur.next.next;   // stay on cur
            else cur = cur.next;
        }
        return head;
    }
}
```

</details>

## Complexity

- **Time:** O(n).
- **Space:** O(1).

## Common mistake

⚠️ Moving cur forward after unlinking, which misses a third copy.

---

⬅️ [Previous: Palindrome Linked List](./006-palindrome-linked-list.md) · [📋 Linked List list](./README.md) · [Next: Remove Nth Node From End of List](./008-remove-nth-node-from-end-of-list.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
