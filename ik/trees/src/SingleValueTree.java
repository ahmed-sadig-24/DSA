public class SingleValueTree {

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

      static int count = 0;

      static boolean recursiveHelper(BinaryTreeNode node) {
            if (node == null)
                  return true;

            boolean is_left_unival = recursiveHelper(node.left);
            boolean is_right_unival = recursiveHelper(node.right);

            if ((node.left == null || (is_left_unival && Integer.valueOf(node.left.value).equals(node.value)))
                    && (node.right == null || (is_right_unival && Integer.valueOf(node.right.value).equals(node.value)))) {
                  count++;
                  return true;
            } else {
                  return false;
            }

      }

      static int find_single_value_trees(BinaryTreeNode root) {

            recursiveHelper(root);
            return count;
      }

}
