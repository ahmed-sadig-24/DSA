public class BalancedBinaryTree {

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


      private static boolean result = true;
      public static boolean isBalanced(TreeNode root) {
            if (root == null) return true;

            dfs(root);

            return result;
      }

      private static int dfs(TreeNode node) {
            if (node == null || !result) return 0;

            int leftHeight = dfs(node.left);
            int rightHeight = dfs(node.right);

            if (Math.abs(leftHeight - rightHeight) > 1) {
                  result = false;
            }

            return Math.max(leftHeight, rightHeight) + 1;
      }


      public static void main(String[] args) {
            // Level 0
            TreeNode root4 = new TreeNode(3);
            // Level 1
            root4.left = new TreeNode(9);
            root4.right = new TreeNode(20);
            // Level 2
            root4.right.right = new TreeNode(7); // Right-most node on this level
            root4.right.left = new TreeNode(15);
            //root4.right.right.right = new TreeNode(100);

            System.out.println(isBalanced(root4));
      }

}
