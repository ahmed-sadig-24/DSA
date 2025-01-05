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

            if (root == null) {
                  return paths;
            }

            findPaths(root, targetSum, new ArrayList<Integer>(), paths);

            return paths;
      }

      private static void findPaths(TreeNode root, int targetSum, ArrayList<Integer> current, List<List<Integer>> paths) {
            if (root == null) {
                  return;
            }

            current.add(root.val);
            if (root.left == null && root.right == null && root.val == targetSum) {
                  paths.add(current);
                  return;
            }

            int newTargetSum = targetSum - root.val;
            findPaths(root.left, newTargetSum, new ArrayList<>(current), paths);
            findPaths(root.right, newTargetSum, new ArrayList<>(current), paths);
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(4);
            root.right = new TreeNode(8);
            root.left.left = new TreeNode(11);
            root.right.left = new TreeNode(13);
            root.right.right = new TreeNode(4);
            root.left.left.left = new TreeNode(7);
            root.left.left.right = new TreeNode(2);
            root.right.right.left = new TreeNode(5);
            root.right.right.right = new TreeNode(1);

            System.out.println(pathSum(root, 22));
      }

}
