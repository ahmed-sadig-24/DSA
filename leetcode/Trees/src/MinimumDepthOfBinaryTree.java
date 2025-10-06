import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

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

      public static int minDepth(TreeNode root) {
            if (root == null) return 0;

            int depth = 1;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  int qSize = q.size();

                  for (int i = 0; i < qSize; i++) {
                        TreeNode currNode = q.remove();

                        if (currNode.left == null && currNode.right == null) {
                              return depth;
                        }

                        if (currNode.left != null) {
                              q.offer(currNode.left);
                        }
                        if (currNode.right != null) {
                              q.offer(currNode.right);
                        }
                  }
                  depth++;
            }

            return depth;
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

            System.out.println(minDepth(root4));
            System.out.println(minDepthRecursive(root4));
      }

      public static int minDepthRecursive(TreeNode root) {
            return dfs(root);
      }

      private static int dfs(TreeNode root) {
            if (root == null) return 0;

            if (root.left == null) {
                  return 1 + dfs(root.right);
            } else if (root.right == null) {
                  return 1 + dfs(root.left);
            }


            return 1 + Math.min(dfs(root.left), dfs(root.right));

      }

}
