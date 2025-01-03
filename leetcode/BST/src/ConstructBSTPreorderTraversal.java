public class ConstructBSTPreorderTraversal {

       //Definition for a binary tree node.
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
        }

      private static int index = 0;

      public static TreeNode bstFromPreorder(int[] preorder) {
            if (preorder == null || preorder.length == 0) {
                  return null;
            }

            return constructBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
      }

      private static TreeNode constructBST(int[] preorder, int minValue, int maxValue) {
            if (index > preorder.length - 1 || preorder[index] < minValue || preorder[index] > maxValue) {
                  return null;
            }

            int nodeValue = preorder[index++];
            TreeNode root = new TreeNode(nodeValue);

            root.left = constructBST(preorder, minValue, nodeValue);
            root.right = constructBST(preorder, nodeValue, maxValue);

            return root;
      }


      public static void main(String[] args) {
            int[] preorder1 = {8,5,1,7,10,12};
            //int[] preorder2 = {};

            System.out.println(bstFromPreorder(preorder1).left.val);
            //System.out.println(bstFromPreorder(preorder2).left);
      }
}
