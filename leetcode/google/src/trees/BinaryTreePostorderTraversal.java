package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
      // Definition for a binary tree node.
      public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                  this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                  this.val = val;
                  this.left = left;
                  this.right = right;
            }
      }

      public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) return result;

            dfs(root, result);

            return result;
      }

      private void dfs(TreeNode node, List<Integer> result) {
            if (node == null) return;

            dfs(node.left, result);
            dfs(node.right, result);
            result.add(node.val);
      }

}
