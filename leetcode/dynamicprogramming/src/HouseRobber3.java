public class HouseRobber3 {
      //Definition for a binary tree node.
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

      public static int rob(TreeNode root) {
            int[] options = traverse(root);

            return Math.max(options[0], options[1]);
      }

      private static int[] traverse(TreeNode root) {
            //base case
            if (root == null) {
                  return new int[2];
            }

            int[] leftNodeChoices = traverse(root.left);
            int[] rightNodeChoices = traverse(root.right);

            int[] options = new int[2];
            options[0] = root.val + leftNodeChoices[1] + rightNodeChoices[1];
            options[1] = Math.max(leftNodeChoices[0], leftNodeChoices[1]) + Math.max(rightNodeChoices[0], rightNodeChoices[1]);

            return options;
      }


      public static void main(String[] args) {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(4);
            root.right = new TreeNode(5);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);
            root.right.right = new TreeNode(1);

            System.out.println(rob(root));

      }
}
