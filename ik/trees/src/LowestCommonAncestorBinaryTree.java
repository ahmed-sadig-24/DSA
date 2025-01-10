public class LowestCommonAncestorBinaryTree {

      //      For your reference:
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

      static Integer lca(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
            // Write your code here.
            if (root == null) {
                  return -1;
            }
            if (root == a || root == b) {
                  return root.value;
            }

            int left = lca(root.left, a, b);
            int right = lca(root.right, a, b);

            if (left == -1) {
                  return right;
            } else if (right == -1) {
                  return left;
            } else {
                  return root.value;
            }
      }

      public static void main(String[] args) {
            BinaryTreeNode root = new BinaryTreeNode(3);
            root.left = new BinaryTreeNode(5);
            root.right = new BinaryTreeNode(1);
            root.left.left = new BinaryTreeNode(6);
            root.left.right = new BinaryTreeNode(2);
            root.right.left = new BinaryTreeNode(0);
            root.right.right = new BinaryTreeNode(8);
            root.left.right.left = new BinaryTreeNode(7);
            root.left.right.right = new BinaryTreeNode(4);

            System.out.println(lca(root, root.left, root.right).intValue());
      }

}
