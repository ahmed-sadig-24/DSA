public class HeightOfBinaryTree {


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

      static Integer height_of_binary_tree(BinaryTreeNode root) {
            // Write your code here.
            if (root == null) {
                  return 0;
            }

            int leftHeight = height_of_binary_tree(root.left);
            int rightHeight = height_of_binary_tree(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
      }

}
