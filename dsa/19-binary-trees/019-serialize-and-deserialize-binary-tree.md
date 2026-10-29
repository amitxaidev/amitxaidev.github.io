# 19. Serialize and Deserialize Binary Tree

**LeetCode 297** · 🔴 Hard · Pattern: **Preorder with null markers**
🔗 Solve it here: [https://leetcode.com/problems/serialize-and-deserialize-binary-tree/](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)  
🌐 Interactive version (progress tracking, hints one by one): [https://amitxaidev.github.io/dsa/19-binary-trees/019-serialize-and-deserialize-binary-tree.html](https://amitxaidev.github.io/dsa/19-binary-trees/019-serialize-and-deserialize-binary-tree.html)

## The problem, in short

Design an encoder that turns a binary tree into a string and a decoder that rebuilds the exact same tree from it.

> This is our own short summary. Read the full statement and examples on LeetCode, then try it yourself before opening the hints.

## Hints

<details>
<summary>💡 Hint 1</summary>

Preorder alone is ambiguous, but preorder with explicit null markers is not.

</details>

<details>
<summary>💡 Hint 2</summary>

Write values separated by commas and "#" for null.

</details>

<details>
<summary>💡 Hint 3</summary>

Rebuild with recursion that reads tokens in the same order.

</details>

## Approach

<details>
<summary>🧠 Show the approach</summary>

serialize: preorder, append value or "#". deserialize: split into tokens, keep a pointer; build(): read a token, "#" → null, else create a node and build its left then right.

</details>

## Java solution

<details>
<summary>✅ Show the answer</summary>

```java
import java.util.*;

/**
 * class TreeNode { int val; TreeNode left, right; TreeNode(int x) { val = x; } }  // provided by LeetCode
 */
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        write(root, sb);
        return sb.toString();
    }

    private void write(TreeNode n, StringBuilder sb) {
        if (n == null) {
            sb.append("#,");          // null marker keeps the shape
            return;
        }
        sb.append(n.val).append(',');
        write(n.left, sb);
        write(n.right, sb);
    }

    public TreeNode deserialize(String data) {
        Deque<String> tokens = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return read(tokens);
    }

    private TreeNode read(Deque<String> tokens) {
        String t = tokens.poll();
        if (t.equals("#")) return null;
        TreeNode n = new TreeNode(Integer.parseInt(t));
        n.left = read(tokens);
        n.right = read(tokens);
        return n;
    }
}
```

</details>

## Complexity

- **Time:** O(n) both ways.
- **Space:** O(n).

## Common mistake

⚠️ Forgetting the null markers, so different trees produce the same string.

---

⬅️ [Previous: Binary Tree Maximum Path Sum](./018-binary-tree-maximum-path-sum.md) · [📋 Binary Trees list](./README.md) · [Next: Vertical Order Traversal of a Binary Tree](./020-vertical-order-traversal-of-a-binary-tree.md) ➡️

---

Made by **Compiled Canvas** · [YouTube @compiledcanvas](https://www.youtube.com/@compiledcanvas) · [Instagram @compiledcanvas](https://www.instagram.com/compiledcanvas)  
▶️ Watch the full DSA series in order: https://www.youtube.com/playlist?list=PLUDfZ2cL52Lg
