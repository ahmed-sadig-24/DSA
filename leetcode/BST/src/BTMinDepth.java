import java.util.LinkedList;
import java.util.Queue;

public class BTMinDepth {
      public class TreeNode {
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

      public int minDepth(TreeNode root) {
            if (root == null) return 0;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            int depth = 1;

            for(int i = 0; i < q.size(); i++) {
                  TreeNode element = q.poll();

                  if (element.left == null && element.right == null) {
                        return depth;
                  }

                  if (element.left != null) {
                        q.add(element.left);
                  }

                  if (element.right != null) {
                        q.offer(element.right);
                  }
                  depth++;
            }

            return depth;
      }
}
