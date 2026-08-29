import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                // Last node of each level
                if (i == size - 1) {
                    result.add(current.val);
                }

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return result;
    }
}


Input
root =
[1,2,3,null,5,null,4]
Output
[1,3,4]
Expected
[1,3,4]
