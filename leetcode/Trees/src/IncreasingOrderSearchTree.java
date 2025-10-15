public class IncreasingOrderSearchTree {

      // Definition for a binary tree node.
      public static class TreeNode {
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

      private static TreeNode current;

      public static TreeNode increasingBST(TreeNode root) {
            TreeNode sentinel = new TreeNode(-1);
            current = sentinel;

            dfs(root);

            return sentinel.right;
      }

      private static void dfs(TreeNode node) {
            if (node == null) return;

            dfs(node.left);

            node.left = null;
            current.right = node;
            current = node;

            dfs(node.right);
      }

}
