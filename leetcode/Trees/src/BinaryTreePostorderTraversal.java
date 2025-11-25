import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

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

      private static void dfs(TreeNode node, List<Integer> result) {
            if (node == null) return;

            dfs(node.left, result);

            dfs(node.right, result);

            result.add(node.val);
      }

      public static List<Integer> postorderTraversalIterative(TreeNode root) {
            List<Integer> result = new LinkedList<>();

            if (root == null) return result;

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                  TreeNode node = stack.pop();
                  //System.out.println(node.val);
                  result.addFirst(node.val);

                  if (node.left != null) stack.push(node.left);
                  if (node.right != null) stack.push(node.right);
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

            System.out.println(postorderTraversal(root));
            System.out.println(postorderTraversalIterative(root));
      }

}
