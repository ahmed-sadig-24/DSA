public class MinimumAbsoluteDifferenceInBST {
      // Definition for a binary tree TreeNode.
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

      public static int getMinimumDifference(TreeNode root) {
            dfs(root);

            return minDiff;
      }

      private static void dfs(TreeNode TreeNode) {
            if (TreeNode == null) return;

            dfs(TreeNode.left);

            if (prev != null)  minDiff = Math.min(minDiff, TreeNode.val - prev);
            
            prev = TreeNode.val;

            dfs(TreeNode.right);
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.right = new TreeNode(6);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);

            System.out.println(getMinimumDifference(root));

      }
}
