package dp;

public class HouseRobber3 {
      // Definition for a binary tree node.
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

      public int rob(TreeNode root) {
            int[] options = traverse(root);

            return Math.max(options[0], options[1]);
      }

      private int[] traverse(TreeNode root) {
            if (root == null) return new int[2];

            int[] leftNodesOptions = traverse(root.left);
            int[] rightNodesOptions = traverse(root.right);

            int[] options = new int[2];
            options[0] = root.val + leftNodesOptions[1] + rightNodesOptions[1];
            options[1] = Math.max(leftNodesOptions[0], leftNodesOptions[1]) + Math.max(rightNodesOptions[0], rightNodesOptions[1]);

            return options;
      }


}
