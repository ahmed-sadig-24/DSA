public class MinimumDistanceBetweenBSTNodes {

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

      private static int minDiff = Integer.MAX_VALUE;
      private static Integer prev = null;

      public static int minDiffInBST(TreeNode root) {
            dfs(root);

            return minDiff;
      }

      private static void dfs(TreeNode node) {
            if (node == null) return;

            dfs(node.left);

            if (prev != null) minDiff = Math.min(minDiff, node.val - prev);
            prev = node.val;

            dfs(node.right);
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.right = new TreeNode(6);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);

            System.out.println(minDiffInBST(root));

      }

}
