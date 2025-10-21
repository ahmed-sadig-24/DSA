import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

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

      public static boolean isSymmetric(TreeNode root) {
            if (root == null) return true;

            Queue<TreeNode> leftTreeQ = new LinkedList<>();
            Queue<TreeNode> rightTreeQ = new LinkedList<>();

            leftTreeQ.offer(root.left);
            rightTreeQ.offer(root.right);
            while (!leftTreeQ.isEmpty() && rightTreeQ.isEmpty()) {
                  TreeNode leftNode = leftTreeQ.poll();
                  TreeNode rightNode = rightTreeQ.poll();

                  if (leftNode == null && rightNode == null) continue;

                  if (leftNode == null || rightNode == null) return false;

                  if (leftNode.val != rightNode.val) return false;

                  leftTreeQ.offer(leftNode.left);
                  leftTreeQ.offer(leftNode.right);

                  rightTreeQ.offer(rightNode.right);
                  rightTreeQ.offer(rightNode.left);
            }

            return true;
      }

      public static boolean isSymmetricRecursive(TreeNode root) {
            if (root == null) return true;

            return helper(root.left, root.right);
      }

      private static boolean helper(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) return true;

            if (t1 == null || t2 == null) return false;

            return (t1.val == t2.val) && helper(t1.left, t2.right) && helper(t1.right, t2.right);
      }
}
