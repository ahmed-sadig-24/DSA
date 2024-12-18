import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {

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

      public static List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            dfs(root, result);

            return result;
      }

      private static void dfs(TreeNode root, List<Integer> result) {
            if (root == null) return;

            dfs(root.left, result);

            dfs(root.right, result);

            result.add(root.val);
      }

      public static void main(String[] args) {
            TreeNode myNode = new TreeNode(1);
            myNode.right = new TreeNode(2);
            myNode.right.left = new TreeNode(3);

            System.out.println(postorderTraversal(myNode));
      }

}
