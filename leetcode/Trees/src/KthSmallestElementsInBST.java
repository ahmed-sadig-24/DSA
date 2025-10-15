public class KthSmallestElementsInBST {

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

      private static int count = 0;
      private static int result = -1;

      public static int kthSmallest(TreeNode root, int k) {
            dfs(root, k);

            return result;
      }

      private static void dfs(TreeNode node, int k) {
            if (node == null) return;

            dfs(node.left, k);

            //
            count++;
            if (count == k) {
                  result = node.val;
                  return;
            }

            dfs(node.right, k);
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(3);
            // Level 1
            root.left = new TreeNode(1);
            root.right = new TreeNode(4);

            root.left.right = new TreeNode(2);
            //root.right.right = new TreeNode(7);

            System.out.println(kthSmallest(root, 1)); //1
      }

}
