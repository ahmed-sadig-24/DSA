public class UpsideDownBT {

       // Definition for a binary tree node.
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

      public static TreeNode upsideDownBinaryTree(TreeNode root) {
              if (root == null || root.left == null) {
                    return root;
              }

              TreeNode newRoot = upsideDownBinaryTree(root.left);

              root.left.left = root.right;
              root.left.right = root;

              root.left = null;
              root.right = null;

              return newRoot;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            System.out.println(upsideDownBinaryTree(root).val);

      }

}
