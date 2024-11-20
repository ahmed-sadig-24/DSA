public class CountCompleteTreeNodes {
      public class TreeNode {
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

      public static int countNodes(TreeNode root) {
            int leftDepth = leftDepth(root.left);
            int rightDepth = rightDepth(root.right);

            if (leftDepth == rightDepth) {
                  return (int) (Math.pow(2, leftDepth) - 1);
            } else {
                  return 1 + countNodes(root.left) + countNodes(root.right);
            }
      }

      private static int leftDepth(TreeNode root) {
            int depth = 0;

            while (root != null) {
                  root = root.left;
                  depth++;
            }

            return depth;
      }

      private static int rightDepth(TreeNode root) {
            int depth = 0;

            while (root != null) {
                  root = root.right;
                  depth++;
            }

            return depth;
      }
}
