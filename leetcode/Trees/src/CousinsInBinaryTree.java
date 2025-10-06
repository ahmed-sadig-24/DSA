import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {

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

      public static boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) return false;

            int level = -1;
            int xLevel = -1;
            int yLevel = -1;
            int xParent = -1;
            int yParent = -1;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  level++;
                  int qSize = q.size();
                  for (int i = 0; i < qSize; i++) {
                        TreeNode currNode = q.poll();
                        if (currNode.val == x) xLevel = level;
                        if (currNode.val == y) yLevel = level;

                        if (currNode.left != null) {
                              if (currNode.left.val == x) xParent = currNode.val;
                              if (currNode.left.val == y) yParent = currNode.val;
                              q.offer(currNode.left);
                        }
                        if (currNode.right != null) {
                              if (currNode.right.val == x) xParent = currNode.val;
                              if (currNode.right.val == y) yParent = currNode.val;
                              q.offer(currNode.right);
                        }
                  }
            }

            return xLevel == yLevel && xParent != yParent;
      }

      public static void main(String[] args) {
            TreeNode root4 = new TreeNode(1);
            // Level 1
            root4.left = new TreeNode(2);
            root4.right = new TreeNode(3);
            // Level 2
            root4.left.right = new TreeNode(4);
            root4.right.right = new TreeNode(5);
            //root4.right.right = new TreeNode(6); // Right-most node on this level

            System.out.println(isCousins(root4, 5, 4));
      }

}
