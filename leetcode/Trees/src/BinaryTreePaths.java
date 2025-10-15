import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

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

      public static List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();

            if (root == null) return result;

            dfs(root, "", result);

            return result;
      }

      private static void dfs(TreeNode node, String path, List<String> result) {
            if (node == null) return;

            path += node.val;

            if (node.left == null && node.right == null) {
                  result.add(path);
            } else {
                  path += "->";
                  dfs(node.left, path, result);
                  dfs(node.right, path, result);
            }
      }

}
