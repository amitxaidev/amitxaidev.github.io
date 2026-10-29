# 2. My Calendar I

**LeetCode 729** · 🟡 Medium · Pattern: **Ordered map (floor / ceiling)**
🔗 Solve it here: [https://leetcode.com/problems/my-calendar-i/](https://leetcode.com/problems/my-calendar-i/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/26-segment-fenwick/002-my-calendar-i.html](https://amitxaidev.github.io/dsa/26-segment-fenwick/002-my-calendar-i.html)

## The problem, in short

Book half-open time intervals [start, end). Reject a booking if it overlaps any existing one.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Keep bookings sorted by start in a TreeMap.

</details>

<details>
<summary>💡 Hint 2</summary>

Only the closest booking before and after the new start can overlap it.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

floorEntry(start) must end at or before start; ceilingKey(start) must be at or after end. If both hold, insert.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

class MyCalendar {
    private final TreeMap<Integer, Integer> bookings = new TreeMap<>();   // start -> end

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> before = bookings.floorEntry(start);
        Integer after = bookings.ceilingKey(start);
        if (before != null && before.getValue() > start) return false;   // previous one runs into us
        if (after != null && after < end) return false;                  // next one starts too early
        bookings.put(start, end);
        return true;
    }
}
```

</details>

## Complexity

- **Time:** O(log n) per booking.
- **Space:** O(n).

## Common mistake

⚠️ Scanning every booking — O(n) per call, O(n²) overall. (A segment tree is the heavier tool for the harder versions.)

---

⬅️ [Previous: Range Sum Query - Mutable](./001-range-sum-query-mutable.md) · [📋 Segment Tree, Fenwick & Sparse Table list](./README.md) · [Next: Count of Range Sum](./003-count-of-range-sum.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
