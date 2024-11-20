import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
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

            Queue<TreeNode> leftTreeQueue = new LinkedList();
            Queue<TreeNode> rightTreeQueue = new LinkedList<>();

            leftTreeQueue.add(root.left);
            rightTreeQueue.add(root.right);

            while (!leftTreeQueue.isEmpty() && !rightTreeQueue.isEmpty()) {
                  TreeNode leftNode = leftTreeQueue.poll();
                  TreeNode rightNode = rightTreeQueue.poll();

                  if (leftNode == null && rightNode == null) continue;

                  if (leftNode == null || rightNode == null) return false;

                  if (leftNode.val != rightNode.val) return false;

                  leftTreeQueue.add(leftNode.left);
                  leftTreeQueue.add(leftNode.right);

                  rightTreeQueue.add(rightNode.right);
                  rightTreeQueue.add(rightNode.left);
            }

            return true;
      }
}
