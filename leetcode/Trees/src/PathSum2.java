import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
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

      public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> paths = new ArrayList<>();

            if (root == null) return paths;

            helper(root, targetSum, new ArrayList<>(), paths);

            return paths;
      }

      private static void helper(TreeNode node, int targetSum, List<Integer> current, List<List<Integer>> paths) {
            if (node == null) return;

            current.add(node.val);
            if (node.left == null && node.right == null && node.val == targetSum) {
                  paths.add(new ArrayList<>(current));
            } else {
                  helper(node.left, targetSum - node.val, current, paths);
                  helper(node.right, targetSum - node.val, current, paths);
            }

            current.remove(current.size() - 1);
      }

      public static void main(String[] args) {
            // Level 0
            TreeNode root4 = new TreeNode(5);
            // Level 1
            root4.left = new TreeNode(4);
            root4.right = new TreeNode(8);
            // Level 2
            root4.right.left = new TreeNode(13);
            root4.right.right = new TreeNode(4);
            root4.left.left = new TreeNode(11);
            //root4.right.right = new TreeNode(6); // Right-most node on this level
            // Level 3
            root4.left.left.left = new TreeNode(7);
            root4.left.left.right = new TreeNode(2);

            root4.right.right.right = new TreeNode(1);
            root4.right.right.left = new TreeNode(5);

            System.out.println(pathSum(root4, 22));
      }
}
