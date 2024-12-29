import java.util.LinkedList;
import java.util.Queue;

public class UnivaluedBinaryTree {
       //Definition for a binary tree node.
        public static class TreeNode {
            int val;
            TreeNode left;
           TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
           }
        }
      public static boolean isUnivalTree(TreeNode root) {
            if (root == null) return true;

            int targetValue = root.val;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  TreeNode currentNode = q.poll();

                  if (currentNode.val != targetValue) {
                        return false;
                  }

                  if (currentNode.left != null) {
                        q.offer(currentNode.left);
                  }
                  if (currentNode.right != null) {
                        q.offer(currentNode.right);
                  }
            }

            return true;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(1);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(1);
            root.right.left = new TreeNode(1);

            System.out.println(isUnivalTree(root));
      }
}
