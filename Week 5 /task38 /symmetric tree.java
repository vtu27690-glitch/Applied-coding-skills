class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {

        // Both nodes are null
        if (left == null && right == null) {
            return true;
        }

        // One node is null
        if (left == null || right == null) {
            return false;
        }

        // Values are different
        if (left.val != right.val) {
            return false;
        }

        // Compare opposite sides
        return isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}

Input
root =
[1,2,2,3,4,4,3]
Output
true
Expected
true
