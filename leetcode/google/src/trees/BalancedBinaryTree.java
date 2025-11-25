package trees;

public class BalancedBinaryTree {
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

      private boolean isBST;

      public boolean isBalanced(TreeNode root) {
            isBST = true;
            dfs(root);

            return isBST;
      }

      private int dfs(TreeNode node) {
            if (node == null) return 0;

            int leftHeight = dfs(node.left);
            int rightHeight = dfs(node.right);

            if (Math.abs(leftHeight - rightHeight) > 1) {
                  isBST = false;
            }

            return Math.max(leftHeight, rightHeight) + 1;
      }

}
