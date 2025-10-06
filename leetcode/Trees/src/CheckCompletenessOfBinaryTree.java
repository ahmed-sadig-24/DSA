import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBinaryTree {

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

      public static boolean isCompleteTree(TreeNode root) {
            boolean gapFlag = false;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  int qSize = q.size();
                  for (int i = 0; i < qSize; i++) {
                        TreeNode currNode = q.poll();

                        if (currNode.left != null) {
                              if (gapFlag) return false;
                              q.offer(currNode.left);
                        } else {
                              gapFlag = true;
                        }
                        if (currNode.right != null) {
                              if (gapFlag) return false;
                              q.offer(currNode.right);
                        } else {
                              gapFlag = true;
                        }
                  }
            }

            return true;
      }

      public static void main(String[] args) {
            TreeNode root4 = new TreeNode(1);
            // Level 1
            root4.left = new TreeNode(2);
            root4.right = new TreeNode(3);
            // Level 2
            root4.left.left = new TreeNode(4);
            root4.left.right = new TreeNode(5);
            root4.right.right = new TreeNode(7); // Right-most node on this level

            System.out.println(isCompleteTree(root4));
      }

}
