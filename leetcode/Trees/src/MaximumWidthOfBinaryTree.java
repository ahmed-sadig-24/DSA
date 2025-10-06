import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

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

      public static class NodePair{
            TreeNode node;
            int id;

            NodePair(TreeNode node, int id) {
                  this.node = node;
                  this.id = id;
            }
      }

      public static int widthOfBinaryTree(TreeNode root) {
            int maxWidth = 0;

            Queue<NodePair> q = new LinkedList<>();
            q.offer(new NodePair(root, 0));
            while (!q.isEmpty()) {
                  int leftID = -1;
                  int rightID = -1;

                  int qSize = q.size();
                  for (int i = 0; i < qSize; i++) {
                        NodePair currNode = q.poll();
                        if (leftID == -1) leftID = currNode.id;
                        if (i == qSize - 1) rightID = currNode.id;

                        if (currNode.node.left != null) {
                              q.offer(new NodePair(currNode.node.left, 2 * currNode.id));
                        }
                        if (currNode.node.right != null) {
                              q.offer(new NodePair(currNode.node.right, 2 * currNode.id + 1));
                        }
                  }

                  maxWidth = Math.max(maxWidth, rightID - leftID + 1);
            }


            return maxWidth;
      }

      public static void main(String[] args) {
            TreeNode root4 = new TreeNode(1);
            // Level 1
            root4.left = new TreeNode(3);
            root4.right = new TreeNode(2);
            // Level 2
            root4.left.left = new TreeNode(5);
            root4.left.right = new TreeNode(3);
            root4.right.right = new TreeNode(9); // Right-most node on this level

            System.out.println(widthOfBinaryTree(root4));
      }

}
