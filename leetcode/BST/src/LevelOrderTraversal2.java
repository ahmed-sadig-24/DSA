import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal2 {
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

      public static List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null) return result;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  int size = q.size();
                  List<Integer> currentLevelNodes = new ArrayList<>();
                  for (int i = 0; i < size; i++) {
                        TreeNode currentNode = q.poll();
                        currentLevelNodes.add(currentNode.val);

                        if (currentNode.left != null) {
                              q.offer(currentNode.left);
                        }
                        if (currentNode.right != null) {
                              q.offer(currentNode.right);
                        }
                  }

                  result.addFirst(currentLevelNodes);
            }

            return result;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);

            System.out.println(levelOrderBottom(root));
      }
}
