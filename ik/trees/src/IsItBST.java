import java.util.ArrayList;

public class IsItBST {

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

      static Boolean is_bst(BinaryTreeNode root) {
            // Write your code here.
            ArrayList<Integer> result = new ArrayList<>();

            helperInOrder(root, result);

            for (int i = 1; i < result.size(); i++) {
                  if (result.get(i) < result.get(i - 1)) {
                        return false;
                  }
            }

            return true;
      }

      private static void helperInOrder(BinaryTreeNode root, ArrayList<Integer> result) {
            // base case
            if (root == null) return;

            helperInOrder(root.left, result);
            result.add(root.value);
            helperInOrder(root.right, result);
      }

}
