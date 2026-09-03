import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            // Go as far left as possible
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Take the top node
            current = stack.pop();

            // Visit the node
            result.add(current.val);

            // Move to the right subtree
            current = current.right;
        }

        return result;
    }
}


Input
root =
[1,null,2,3]
Output
[1,3,2]
Expected
[1,3,2]
