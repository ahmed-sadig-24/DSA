import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfBinaryTree {

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

      public static int maxLevelSum(TreeNode root) {
            if (root == null) return 0;
            
            int maxSum = Integer.MIN_VALUE;
            int maxLevel = 0;
            int level = 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  level++;
                  int levelSum = 0;
                  int qSize = q.size();
                  for (int i = 0; i < qSize; i++) {
                        TreeNode currNode = q.remove();
                        levelSum += currNode.val;
                        
                        if (currNode.left != null) {
                              q.offer(currNode.left);
                        }
                        if (currNode.right != null) {
                              q.offer(currNode.right);
                        }
                  }

                  if (levelSum > maxSum) {
                        maxSum = levelSum;
                        maxLevel = level;
                  }
            }
            
            return maxLevel;
      }

      public static void main(String[] args) {
            // Level 0
            TreeNode root4 = new TreeNode(1);
            // Level 1
            root4.left = new TreeNode(7);
            root4.right = new TreeNode(0);
            // Level 2
            root4.right.left = new TreeNode(7);
            root4.right.right = new TreeNode(-8);
            //root4.right.right = new TreeNode(6); // Right-most node on this level

            System.out.println(maxLevelSum(root4));
      }

}
