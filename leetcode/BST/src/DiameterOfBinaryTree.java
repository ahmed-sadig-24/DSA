public class DiameterOfBinaryTree {
      //Definition for a binary tree node.
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
            calculateHeight(root);

            return diameter;
      }

      private static int calculateHeight(TreeNode currentNode) {
            if (currentNode == null) {
                  return 0;
            }

            int leftHeight = calculateHeight(currentNode.left);
            int rightHeight = calculateHeight(currentNode.right);

            diameter = Math.max(diameter, leftHeight + rightHeight);

            return Math.max(leftHeight, rightHeight) + 1;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            System.out.println(diameterOfBinaryTree(root));
      }
}
