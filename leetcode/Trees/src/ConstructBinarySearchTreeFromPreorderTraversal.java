public class ConstructBinarySearchTreeFromPreorderTraversal {

      // Definition for a binary tree node.
      public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                  this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                  this.val = val;
                  this.left = left;
                  this.right = right;
            }
      }

      private static int preIndex = 0;

      public static TreeNode bstFromPreorder(int[] preorder) {
            return buildTree(preorder, Integer.MAX_VALUE);
      }

      private static TreeNode buildTree(int[] preorder, int bound) {
            if (preIndex == preorder.length || preorder[preIndex] > bound) {
                  return null;
            }

            //
            int rootVal = preorder[preIndex++];
            TreeNode root = new TreeNode(rootVal);

            buildTree(preorder, rootVal);
            buildTree(preorder, bound);

            return root;
      }

      public static void main(String[] args) {
            int[] preorder = {8,5,1,7,10,12};

            System.out.println(bstFromPreorder(preorder).val);
      }

}
