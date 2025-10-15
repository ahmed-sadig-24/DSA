public class CountUnivalueSubtrees {

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

      public static int countUnivalSubtrees(TreeNode root) {
            countHelper(root);
            
            return count;
      }

      private static boolean countHelper(TreeNode node) {
            if (node == null) return true;

            boolean leftUnival = countHelper(node.left);
            boolean rightUnival = countHelper(node.right);

            if (!leftUnival || !rightUnival) return false;

            if (node.left != null && node.left.val != node.val) return false;
            if (node.right != null && node.right.val != node.val) return false;

            count++;
            return true;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(5);
            // Level 1
            root.left = new TreeNode(1);
            root.right = new TreeNode(5);
            // Level 2
            root.left.right = new TreeNode(5);
            root.right.right = new TreeNode(5);
            root.left.left = new TreeNode(5);
            //root.right.right = new TreeNode(6); // Right-most node on this level

            System.out.println(countUnivalSubtrees(root));
      }
}
