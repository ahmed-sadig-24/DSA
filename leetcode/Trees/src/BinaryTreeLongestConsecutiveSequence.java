public class BinaryTreeLongestConsecutiveSequence {

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

      private static int result = 0;
      public static int longestConsecutive(TreeNode root) {
            if (root == null) return 0;

            helper(root, 0, 0);

            return result;
      }

      private static void helper(TreeNode node, int prevNum, int currLongest) {
            if (node.val == prevNum + 1) {
                  currLongest++;
            } else {
                  currLongest = 1;
            }
            result = Math.max(result, currLongest);

            if (node.left != null) {
                  helper(node.left, node.val, currLongest);
            }
            if (node.right != null) {
                  helper(node.right, node.val, currLongest);
            }
      }

      public static void main(String[] args) {
            TreeNode root4 = new TreeNode(1);
            root4.right = new TreeNode(3);
            root4.right.left = new TreeNode(2);
            root4.right.right = new TreeNode(4);
            root4.right.right.right = new TreeNode(5);

            TreeNode root = new TreeNode(1);

            System.out.println(longestConsecutive(root4));
            //System.out.println(longestConsecutive(root));
      }
}
