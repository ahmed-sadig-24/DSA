import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

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

      public static List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) return result;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  int size = q.size();
                  for (int i = 0; i < size; i++) {
                        TreeNode currNode = q.remove();

                        if (i == size - 1) {
                              result.add(currNode.val);
                        }

                        if (currNode.left != null) {
                              q.offer(currNode.left);
                        }
                        if (currNode.right != null) {
                              q.offer(currNode.right);
                        }
                  }
            }

            return result;
      }

      public static void main(String[] args) {
            // Level 0
            TreeNode root4 = new TreeNode(1);
            // Level 1
            root4.left = new TreeNode(2);
            root4.right = new TreeNode(3);
            // Level 2
            root4.left.left = new TreeNode(4);
            root4.left.left.left = new TreeNode(5);
            //root4.right.right = new TreeNode(6); // Right-most node on this level

            System.out.println(rightSideView(root4));
      }
}
