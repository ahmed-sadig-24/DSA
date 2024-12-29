public class DiameterOfBinaryTree {

      //      For your reference:
      class BinaryTreeNode {
            Integer value;
            BinaryTreeNode left;
            BinaryTreeNode right;

            BinaryTreeNode(Integer value) {
                  this.value = value;
                  this.left = null;
                  this.right = null;
            }
      }

      private static int diameter = 0;

      static Integer binary_tree_diameter(BinaryTreeNode root) {
            // Write your code here.
            calculateHeight(root);

            return diameter;
      }

      private static int calculateHeight(BinaryTreeNode currentNode) {
            if (currentNode == null) {
                  return 0;
            }

            int leftHeight = calculateHeight(currentNode.left);
            int rightHeight = calculateHeight(currentNode.right);

            diameter = Math.max(diameter, leftHeight + rightHeight);

            return Math.max(leftHeight, rightHeight) + 1;
      }
}
