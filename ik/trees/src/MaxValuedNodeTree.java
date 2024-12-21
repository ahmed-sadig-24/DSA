public class MaxValuedNodeTree {
      //For your reference:
      static class BinaryTreeNode {
            Integer value;
            BinaryTreeNode left;
            BinaryTreeNode right;

            BinaryTreeNode(Integer value) {
                  this.value = value;
                  this.left = null;
                  this.right = null;
            }
      }

      static Integer get_maximum_value(BinaryTreeNode root) {
            // Write your code here.
            while (root != null && root.right != null) {
                  root = root.right;
            }
            return root.value;
      }

      public static void main(String[] args) {
            BinaryTreeNode myNode = new BinaryTreeNode(2);
            myNode.left = new BinaryTreeNode(1);
            myNode.right = new BinaryTreeNode(5);
            myNode.right.right = new BinaryTreeNode(6);
            myNode.right.left = new BinaryTreeNode(4);

            System.out.println(get_maximum_value(myNode));
      }

}
