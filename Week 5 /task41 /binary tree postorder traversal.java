import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {

            TreeNode current = stack1.pop();
            stack2.push(current);

            // Push left first
            if (current.left != null) {
                stack1.push(current.left);
            }

            // Push right second
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        // Take nodes from stack2
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }
}


Input
root =
[1,null,2,3]
Output
[3,2,1]
Expected
[3,2,1]
