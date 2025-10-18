import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

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

      public static List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) return result;

            dfs(root, result);

            return result;
      }

      private static void dfs(TreeNode node, List<Integer> result) {
            if (node == null) return;

            dfs(node.left, result);

            result.add(node.val);

            dfs(node.right, result);
      }

      public static List<Integer> inorderTraversalIterative(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) return result;

            TreeNode curr = root;
            Stack<TreeNode> stack = new Stack<>();
            while (curr != null || !stack.isEmpty()) {
                  while (curr != null) {
                        stack.push(curr);
                        curr = curr.left;
                  }

                  curr = stack.pop();
                  result.add(curr.val);
                  curr = curr.right;
            }

            return result;
      }

      public static List<Integer> inorderTraversalMorris(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) return result;

            TreeNode curr = root;
            while (curr != null) {
                  if (curr.left == null) {
                        result.add(curr.val);
                        curr = curr.right;
                  } else {
                        TreeNode predecessor = curr.left;

                        while (predecessor.right != curr && predecessor.right != null) {
                              predecessor = predecessor.right;
                        }
                        if (predecessor.right == null) {
                              predecessor.right = curr;
                              curr = curr.left;
                        } else {
                              result.add(curr.val);
                              curr = curr.right;
                              predecessor.right = null;
                        }
                  }
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

            System.out.println(inorderTraversal(root));
            System.out.println(inorderTraversalIterative(root));
            System.out.println(inorderTraversalMorris(root));
      }
}
