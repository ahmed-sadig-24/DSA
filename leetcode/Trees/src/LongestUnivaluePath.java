public class LongestUnivaluePath {

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

      private static int maxPath = 0;

      public static int longestUnivaluePath(TreeNode root) {
            dfs(root);

            return maxPath;
      }

      private static int dfs(TreeNode node) {
            if (node == null) return 0;

            int left = dfs(node.left);
            int right = dfs(node.right);

            int leftPath = 0;
            int rightPath = 0;
            if (node.left != null && node.left.val == node.val) leftPath = left + 1;
            if (node.right != null && node.right.val == node.val) rightPath = right + 1;

            maxPath = Math.max(maxPath, leftPath + rightPath);

            return Math.max(leftPath, rightPath);
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(5);
            // Level 1
            root.left = new TreeNode(4);
            root.right = new TreeNode(5);
            // Level 2
            root.left.right = new TreeNode(1);
            root.left.left = new TreeNode(1);
            root.right.right = new TreeNode(5);
            //root.right.right = new TreeNode(6); // Right-most node on this level

            System.out.println(longestUnivaluePath(root));
      }

}
