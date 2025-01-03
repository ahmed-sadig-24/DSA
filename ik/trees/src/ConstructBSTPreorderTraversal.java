import java.util.ArrayList;

public class ConstructBSTPreorderTraversal {

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

      static int index = 0;

      static BinaryTreeNode build_binary_search_tree(ArrayList<Integer> preorder) {
            // Write your code here.
            if (preorder == null || preorder.size() == 0) {
                  return null;
            }

            return constructBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
      }

      static BinaryTreeNode constructBST(ArrayList<Integer> preorder, int minValue, int maxValue) {
            if (index > preorder.size() - 1 || preorder.get(index) < minValue || preorder.get(index) > maxValue) {
                  return null;
            }

            int nodeValue = preorder.get(index++);
            BinaryTreeNode root = new BinaryTreeNode(nodeValue);

            root.left = constructBST(preorder, minValue, nodeValue);
            root.right = constructBST(preorder, nodeValue, maxValue);

            return root;
      }

      public static void main(String[] args) {
            int[] preorder1 = {8,5,1,7,10,12};
            //int[] preorder2 = {};

            //System.out.println(build_binary_search_tree(preorder1).left.val);
            //System.out.println(bstFromPreorder(preorder2).left);
      }

}
