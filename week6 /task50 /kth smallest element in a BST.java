class Solution {
public int kthSmallest(TreeNode root, int k) {
java.util.Stack<TreeNode> stack = new java.util.Stack<>();
TreeNode current = root;

    while (true) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        current = stack.pop();
        k--;

        if (k == 0) {
            return current.val;
        }

        current = current.right;
    }
}


}




Input
root =
[3,1,4,null,2]
k =
1
Output
1
Expected
1
