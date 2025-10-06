import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {

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

      public static TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) {
                  return new TreeNode(val, root, null);
            }

            int level = 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  level++;
                  
                  int qSize = q.size();
                  for (int i = 0; i < qSize; i++) {
                        TreeNode currNode = q.poll();

                        if (level == depth - 1) {
                              TreeNode newLeftNode = new TreeNode(val);
                              TreeNode newRightNode = new TreeNode(val);
                              newLeftNode.left = currNode.left;
                              newRightNode.right = currNode.right;
                              currNode.left = newLeftNode;
                              currNode.right = newRightNode;

                              break;
                        }

                        if (currNode.left != null) {
                              q.offer(currNode.left);
                        }
                        if (currNode.right != null) {
                              q.offer(currNode.right);
                        }

                  }
            }

            return root;
      }

      public static void main(String[] args) {
            TreeNode root4 = new TreeNode(4);
            // Level 1
            root4.left = new TreeNode(2);
            root4.right = new TreeNode(6);
            // Level 2
            root4.left.left = new TreeNode(3);
            root4.left.right = new TreeNode(1);
            root4.right.left = new TreeNode(5); // Right-most node on this level

            //System.out.println(addOneRow(root4, 1, 2));
            addOneRow(root4, 1,2);
            System.out.println(root4.left.left.val);
      }
}
