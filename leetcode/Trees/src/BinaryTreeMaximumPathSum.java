public class BinaryTreeMaximumPathSum {
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

      private static int maxSum = Integer.MIN_VALUE;

      public static int maxPathSum(TreeNode root) {
            dfs(root);

            return maxSum;
      }

      private static int dfs(TreeNode node) {
            if (node == null) return 0;

            int left = Math.max(dfs(node.left), 0);
            int right = Math.max(dfs(node.right), 0);

            int currPathSum = left + right + node.val;

            maxSum = Math.max(maxSum, currPathSum);

            return Math.max(left, right) + node.val;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(-10);
            // Level 1
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);

            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);

            System.out.println(maxPathSum(root));
      }

}
