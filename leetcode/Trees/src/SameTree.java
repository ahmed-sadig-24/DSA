import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

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

      public static boolean isSameTree(TreeNode p, TreeNode q) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(p);
            queue.add(q);

            while (!queue.isEmpty()) {
                  TreeNode first = queue.poll();
                  TreeNode second = queue.poll();

                  if (first == null && second == null) {
                        continue;
                  } else if (first == null || second == null || first.val != second.val) {
                        return false;
                  }

                  queue.add(first.left);
                  queue.add(second.left);
                  queue.add(first.right);
                  queue.add(second.right);
            }

            return true;
      }

      public static boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;

            if (p == null || q == null) return false;

            if (p.val != q.val) return false;

            return isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);
      }

}
