public class UpsideDown {


      // For your reference:
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

      static BinaryTreeNode flip_upside_down(BinaryTreeNode root) {
            // Write your code here.
            if (root == null || root.left == null) {
                  return root;
            }

            BinaryTreeNode newRoot = flip_upside_down(root.left);

            root.left.left = root.right;
            root.left.right = root;

            root.left = null;
            root.right = null;

            return newRoot;
      }

}
