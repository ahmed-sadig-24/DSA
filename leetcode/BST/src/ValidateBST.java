import java.util.LinkedList;
import java.util.List;

public class ValidateBST {

      public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
      }

      public static boolean isValidBST(TreeNode root) {
            List<Integer> inOrderList = new LinkedList<>();
            //Fill the list
            helper(root, inOrderList);
            System.out.println("aa");

            int prev = inOrderList.get(0);
            for (int i = 1; i < inOrderList.size(); i++) {
                  if (inOrderList.get(i) <= prev) {
                        return false;
                  }
            }

            return true;
      }

      private static void helper(TreeNode myNode, List<Integer> inOrderList) {
                  if (myNode == null) return;
            //System.out.println("dd" + myNode.val);
                  helper(myNode.left, inOrderList);
                  inOrderList.add(myNode.val);
                  helper(myNode.right, inOrderList);
      }

  }

      public static void testBalancedBST() {
            //System.out.println("\n----- Test: Balanced BST -----\n");
            BinarySearchTree bst = new BinarySearchTree();
            //bst.insert(10);
            //bst.insert(5);
            //bst.insert(15);
            //bst.insert(2);
            //bst.insert(7);
            //bst.insert(12);
            //bst.insert(18);

            bst.insert(2);
            bst.insert(1);
            bst.insert(3);
            bst.insert(4);

            //is

            //bst.insert(5);
            //bst.insert(1);
            //bst.insert(4);
            //bst.insert(0);
            //bst.insert(3);
            //bst.insert(6);

            printIsValidBST(bst);

            //TreeNode t = new TreeNode(1);
            //t.left = new TreeNode(2);
            //t.right = new TreeNode(3);


            //printIsValidBST(t.);
            //printIsValidBST(bst);
            //testBalancedBST();

      }

      public static void printIsValidBST(BinarySearchTree bst) {
            //bst.isValidBST();
            System.out.println("Is valid BST: " + bst.isValidBST());
            //bst.is
            //bs
      }

      public static void main(String[] args) {
            //bst.
            //System.out.println(testBalancedBST());
            //isValidBS
            //isValidBST
            //bst.

      }

}
