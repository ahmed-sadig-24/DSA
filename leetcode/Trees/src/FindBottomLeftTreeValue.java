import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

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

      public static int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            Integer levelFirstNode = null;
            while (!q.isEmpty()) {
                  levelFirstNode = null;
                  int qSize = q.size();
                  for (int i = 0; i < qSize; i++) {
                        TreeNode node = q.poll();
                        
                        if (levelFirstNode == null) levelFirstNode = node.val;
                        
                        if (node.left != null) {
                              q.offer(node.left);
                        }
                        if (node.right != null) {
                              q.offer(node.right);
                        }
                  }
            }

            return levelFirstNode;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.right.left = new TreeNode(5);
            root.right.right = new TreeNode(6);
            //root.right.left.left = new TreeNode(7);
            root.right.right.right = new TreeNode(7);

            System.out.println(findBottomLeftValue(root));

      }

}
