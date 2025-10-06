import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

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

      public static int maxDepth(TreeNode root) {
            if (root == null) return 0;

            int maxDepth = 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  maxDepth++;
                  int qSize = q.size();
                  for (int i = 0; i < qSize; i++) {
                        TreeNode currNode = q.remove();

                        if (currNode.left != null) {
                              q.offer(currNode.left);
                        }
                        if (currNode.right != null) {
                              q.offer(currNode.right);
                        }
                  }
            }

            return maxDepth;
      }
      public int maxDepthRecursive(TreeNode root) {
            if (root == null) return 0;

            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);

            return Math.max(leftDepth, rightDepth) + 1;
      }

      public static void main(String[] args) {
            // Level 0
            TreeNode root4 = new TreeNode(3);
            // Level 1
            root4.left = new TreeNode(9);
            root4.right = new TreeNode(20);
            // Level 2
            root4.right.left = new TreeNode(15);
            root4.right.right = new TreeNode(7);
            //root4.right.right = new TreeNode(6); // Right-most node on this level

            System.out.println(maxDepth(root4));
      }

}
