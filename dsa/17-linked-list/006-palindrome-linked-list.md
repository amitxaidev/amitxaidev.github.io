# 6. Palindrome Linked List

**LeetCode 234** · 🟢 Easy · Pattern: **Middle + reverse second half**

## The problem, in short

Decide whether a singly linked list reads the same forwards and backwards, ideally in O(1) extra space.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

🔗 **Solve it here:** [https://leetcode.com/problems/palindrome-linked-list/](https://leetcode.com/problems/palindrome-linked-list/)  
🌐 **Interactive version** (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/17-linked-list/006-palindrome-linked-list.html](https://amitxaidev.github.io/dsa/17-linked-list/006-palindrome-linked-list.html)

## Understanding

**Really asking:** does the list read the same backwards?

**Why this works:** find the middle, reverse the second half, compare the two halves node by node.

**Example:** 1 → 2 → 2 → 1
```text
second half reversed: 1 → 2
compare 1=1, 2=2 → true
```

## Hints

<details>
<summary>💡 Hint 1</summary>

Find the middle with slow/fast pointers.

</details>

<details>
<summary>💡 Hint 2</summary>

Reverse the second half, then compare it with the first half.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Find the middle, reverse from there, compare node by node until the reversed half ends. (Optionally reverse it back to restore the list.)

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
/**
 * class ListNode { int val; ListNode next; }  // provided by LeetCode
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverse(slow);    // second half reversed
        for (ListNode a = head, b = second; b != null; a = a.next, b = b.next) {
            if (a.val != b.val) return false;
        }
        return true;
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

⚠️ Copying values into an ArrayList — correct, but O(n) space.

---

⬅️ [Previous: Intersection of Two Linked Lists](./005-intersection-of-two-linked-lists.md) · [📋 Linked List list](./README.md) · [Next: Remove Duplicates from Sorted List](./007-remove-duplicates-from-sorted-list.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
