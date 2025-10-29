public class BinaryTreeTilt {

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
      public static int findTilt(TreeNode root) {
            if (root == null) return 0;
            
            dfs(root);
            
            return result;
      }

      private static int dfs(TreeNode node) {
            if (node == null) return 0;

            int left = dfs(node.left);
            int right = dfs(node.right);
            //bottom-up postorder DFS
            int localTilt = Math.abs(left - right);
            result += localTilt;
            
            return left + right + node.val;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(4);

            root.left = new TreeNode(2);
            root.right = new TreeNode(9);

            root.left.left = new TreeNode(3);
            root.left.right = new TreeNode(5);
            root.right.right = new TreeNode(7);

            System.out.println(findTilt(root));

      }

}
