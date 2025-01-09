import java.util.Objects;

public class RootToLeafPathSumToK {

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

      static Boolean path_sum(BinaryTreeNode root, Integer k) {
            // Write your code here.
            if (root == null) {
                  return false;
            }

            if (root.left == null && root.right == null) {
                  System.out.println(root.value);
                  //return Objects.equals(root.value, k);
                  return root.value == (long) k;
            }

            long newTargetSum = k - root.value;
            return path_sum(root.left, (int) newTargetSum) || path_sum(root.right, (int) newTargetSum) ;
      }

      public static void main(String[] args) {
            /*
            BinaryTreeNode root = new BinaryTreeNode(0);
            root.left = new BinaryTreeNode(1);
            root.right = new BinaryTreeNode(2);
            root.left.left = new BinaryTreeNode(3);
            root.left.right = new BinaryTreeNode(4);

            int k = 4;

             */

            BinaryTreeNode root = new BinaryTreeNode(1);
            root.right = new BinaryTreeNode(2);
            root.right.right = new BinaryTreeNode(3);
            root.right.right.right = new BinaryTreeNode(100000);

            int k = 100006;

            System.out.println(path_sum(root, k));
      }

}
