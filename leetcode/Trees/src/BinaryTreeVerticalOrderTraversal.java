import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

       // Definition for a binary tree node.
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

      public static class NodePair {
            TreeNode node;
            int val;

            NodePair(TreeNode node, int val) {
                  this.node = node;
                  this.val = val;
            }
      }

      public static List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;

            int minCol = 0, maxCol = 0;
            Map<Integer, List<Integer>> colMap = new HashMap<>();
            Queue<NodePair> q = new LinkedList<>();
            q.offer(new NodePair(root, 0));
            while (!q.isEmpty()) {
                  NodePair pair = q.poll();
                  TreeNode node = pair.node;
                  int col = pair.val;

                  colMap.computeIfAbsent(col, x -> new ArrayList<>()).add(node.val);

                  if (node.left != null) {
                        q.offer(new NodePair(node.left, col - 1));
                        minCol = Math.min(minCol, col - 1);
                  }
                  if (node.right != null) {
                        q.offer(new NodePair(node.right, col + 1));
                        maxCol = Math.max(maxCol, col + 1);
                  }
            }

            for (int i = minCol; i <= maxCol; i++) {
                  result.add(colMap.get(i));
            }

            return result;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(3);

            root.left = new TreeNode(9);
            root.right = new TreeNode(20);

            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);

            System.out.println(verticalOrder(root));
      }
}
