public class DiameterOfBinaryTree {

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

      private static int diameter = 0;

      public static int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;

            calcualteHeight(root);

            return diameter;
      }

      private static int calcualteHeight(TreeNode node) {
            if (node == null) return 0;

            int leftHeight = calcualteHeight(node.left);
            int rightHeight = calcualteHeight(node.right);

            diameter = Math.max(diameter, leftHeight + rightHeight);

            return Math.max(leftHeight, rightHeight) + 1;
      }

}
