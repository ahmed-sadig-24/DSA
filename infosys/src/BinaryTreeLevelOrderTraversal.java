import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
      class TreeNode {
            int val;
            TreeNode left, right;
            TreeNode(int x) { val = x; }
      }

      public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null) return result;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  int qSize = q.size();
                  List<Integer> currLevel = new ArrayList<>();
                  for (int i = 0; i < qSize; i++) {
                        TreeNode node = q.poll();
                        currLevel.add(node.val);
                        if (node.left != null) q.offer(node.left);
                        if (node.right != null) q.offer(node.right);
                  }

                  result.add(currLevel);
            }

            return result;
      }
}
