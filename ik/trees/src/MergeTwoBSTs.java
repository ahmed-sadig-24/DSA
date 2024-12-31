public class MergeTwoBSTs {

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

      static BinaryTreeNode merge_two_binary_search_trees(BinaryTreeNode root1, BinaryTreeNode root2) {
            // Write your code here.
            if (root1 == null) {
                  return root2;
            }

            if (root2 == null) {
                  return root1;
            }

            root1.value += root2.value;
            root1.left = merge_two_binary_search_trees(root1.left, root2.left);
            root1.right = merge_two_binary_search_trees(root1.right, root2.right);

            return root1;
      }

      public static void main(String[] args) {
            BinaryTreeNode roo1 = new BinaryTreeNode(1);
            roo1.left = new BinaryTreeNode(3);
            roo1.right = new BinaryTreeNode(2);
            roo1.left.left = new BinaryTreeNode(5);

            BinaryTreeNode root2 = new BinaryTreeNode(2);
            root2.left = new BinaryTreeNode(1);
            root2.right = new BinaryTreeNode(3);
            root2.left.right = new BinaryTreeNode(4);
            root2.right.right = new BinaryTreeNode(7);

            merge_two_binary_search_trees(roo1, root2);

            System.out.println(roo1.value);
            System.out.println(roo1.left.left.value);
      }

}
