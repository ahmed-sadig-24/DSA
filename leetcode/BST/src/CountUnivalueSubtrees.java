public class CountUnivalueSubtrees {
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

      private static int count = 0;

      public static int countUnivalSubtrees(TreeNode root) {
            countHelper(root);

            return count;
      }

      private static boolean countHelper(TreeNode currentNode) {
            if (currentNode == null) {
                  return true;
            }

            boolean leftUnival = countHelper(currentNode.left);
            boolean rightUnival = countHelper(currentNode.left);

            if (!leftUnival || !rightUnival) {
                  return false;
            }

            if (currentNode.left != null && currentNode.left.val != currentNode.val) {
                  return false;
            }
            if (currentNode.right != null && currentNode.right.val != currentNode.val) {
                  return false;
            }

            count++;
            return true;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(1);
            root.right = new TreeNode(5);
            root.left.left = new TreeNode(5);
            root.left.right = new TreeNode(5);
            root.right.right = new TreeNode(5);

            System.out.println(countUnivalSubtrees(root));
      }

}
