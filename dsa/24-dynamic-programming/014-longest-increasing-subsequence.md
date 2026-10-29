# 14. Longest Increasing Subsequence

**LeetCode 300** · 🟡 Medium · Pattern: **Patience sorting + binary search**
🔗 Solve it here: [https://leetcode.com/problems/longest-increasing-subsequence/](https://leetcode.com/problems/longest-increasing-subsequence/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/24-dynamic-programming/014-longest-increasing-subsequence.html](https://amitxaidev.github.io/dsa/24-dynamic-programming/014-longest-increasing-subsequence.html)

## The problem, in short

Return the length of the longest strictly increasing subsequence.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

O(n²) DP: dp[i] = 1 + max dp[j] for j &lt; i with nums[j] &lt; nums[i].

</details>

<details>
<summary>💡 Hint 2</summary>

Faster: tails[k] = the smallest possible tail of an increasing subsequence of length k + 1.

</details>

<details>
<summary>💡 Hint 3</summary>

For each number, binary search the first tail >= it and replace it (or append).

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

Maintain the sorted tails array. Each number either extends the longest subsequence or improves (lowers) some tail. The array's length is the answer.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 0;
        for (int x : nums) {
            int lo = 0, hi = len;
            while (lo < hi) {                   // first tail >= x
                int mid = (lo + hi) >>> 1;
                if (tails[mid] < x) lo = mid + 1;
                else hi = mid;
            }
            tails[lo] = x;
            if (lo == len) len++;               // extended the longest one
        }
        return len;
    }
}
```

</details>

## Complexity

- **Time:** O(n log n).
- **Space:** O(n).

## Common mistake

⚠️ Thinking tails is an actual LIS — only its length is meaningful.

---

⬅️ [Previous: Longest Common Subsequence](./013-longest-common-subsequence.md) · [📋 Dynamic Programming list](./README.md) · [Next: Longest Palindromic Subsequence](./015-longest-palindromic-subsequence.md) ➡️

---

Developed and created by **Amit Singh** · **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
