public class RecoverBinarySearchTree {

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

      private static TreeNode first = null;
      private static TreeNode second = null;
      private static TreeNode prev = new TreeNode(Integer.MIN_VALUE);

      public static void recoverTree(TreeNode root) {
            dfs(root);

            int temp = first.val;
            first.val = second.val;
            second.val = temp;
      }

      private static void dfs(TreeNode node) {
            if (node == null) return;

            dfs(node.left);

            if (first == null && prev.val > node.val) {
                  first = prev;
            }
            if (first != null && prev.val > node.val) {
                  second = node;
            }

            prev = node;

            dfs(node.right);
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(3);
            //root.right = new TreeNode(6);
            //root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(2);

            recoverTree(root);
            System.out.println(root.val);
      }

}
