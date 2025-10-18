import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

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

      public static List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) {
                  return result;
            }

            dfs(root, result);

            return result;
      }

      private static void dfs(TreeNode node, List<Integer> result) {
            if (node == null) return;

            result.add(node.val);

            dfs(node.left, result);

            dfs(node.right, result);
      }

      public static List<Integer> preorderTraversalIterative(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) return result;

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                  TreeNode node  = stack.pop();
                  result.add(node.val);

                  if (node.right != null) stack.push(node.right);
                  if (node.left != null) stack.push(node.left);
            }

            return result;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            //root.left = new TreeNode(3);
            root.right = new TreeNode(2);
            //root.left.left = new TreeNode(1);
            //root.left.right = new TreeNode(2);
            root.right.left = new TreeNode(3);

            System.out.println(preorderTraversal(root));
            System.out.println(preorderTraversalIterative(root));
      }
}
