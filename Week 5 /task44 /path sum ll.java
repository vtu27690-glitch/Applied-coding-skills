import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);

        return result;
    }

    private void dfs(TreeNode root, int targetSum,
                     List<Integer> path,
                     List<List<Integer>> result) {

        // Empty node
        if (root == null) {
            return;
        }

        // Add current node to path
        path.add(root.val);

        // Check if it is a leaf
        if (root.left == null && root.right == null) {

            // Check whether path sum equals target
            if (root.val == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }

        // Go to left subtree
        dfs(root.left, targetSum - root.val, path, result);

        // Go to right subtree
        dfs(root.right, targetSum - root.val, path, result);

        // Backtrack
        path.remove(path.size() - 1);
    }
}


Input
root =
[5,4,8,11,null,13,4,7,2,null,null,5,1]
targetSum =
22
Output
[[5,4,11,2],[5,8,4,5]]
Expected
[[5,4,11,2],[5,8,4,5]]
Con
