import java.util.*;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode current = stack.pop();

            // Visit root
            result.add(current.val);

            // Push right first
            if (current.right != null) {
                stack.push(current.right);
            }

            // Push left second
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return result;
    }
}


import java.util.*;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode current = stack.pop();

            // Visit root
            result.add(current.val);

            // Push right first
            if (current.right != null) {
                stack.push(current.right);
            }

            // Push left second
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return result;
    }
}
