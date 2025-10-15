public class LargestBSTSubtree {

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

      private static class Info {
            boolean isBST;
            int size;
            int min;
            int max;

            Info(boolean isBST, int size, int min, int max) {
                  this.isBST = isBST;
                  this.size = size;
                  this.min = min;
                  this.max = max;
            }
      }

      private static int maxSize = 0;

      public static int largestBSTSubtree(TreeNode root) {
            dfs(root);

            return maxSize;
      }

      private static Info dfs(TreeNode node) {
            if (node == null) return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

            Info left = dfs(node.left);
            Info right = dfs(node.right);

            if (left.isBST && right.isBST && node.val > left.max && node.val < right.min) {
                  int currSize = left.size + right.size + 1;
                  maxSize = Math.max(maxSize, currSize);

                  return new Info(true, currSize, Math.min(node.val, left.min), Math.max(node.val, right.max));
            }

            return new Info(false, Math.max(left.size, right.size),0,0);
      }

}
