import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBinaryTree {

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

      public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) return result;

            if (!isLeaf(root)) result.add(root.val);

            //Add left boundary
            TreeNode curr = root.left;
            while (curr != null) {
                  if (!isLeaf(curr)) result.add(curr.val);
                  curr = curr.left != null ? curr.left: curr.right;
            }
            //Add leaf nodes
            addLeaves(root, result);
            //Add right boundary
            Stack<Integer> stack = new Stack<>();
            curr = root.right;
            while (curr != null) {
                  if (!isLeaf(curr)) stack.push(curr.val);
                  curr = curr.right != null ? curr.right: curr.left;
            }
            while (!stack.isEmpty()) result.add(stack.pop());

            return result;
      }

      private static boolean isLeaf(TreeNode node) {
            return node.left == null && node.right == null;
      }

      private static void addLeaves(TreeNode node, List<Integer> result) {
            if (node == null) return;

            if (isLeaf(node)) {
                  result.add(node.val);
            } else {
                  addLeaves(node.left, result);
                  addLeaves(node.right, result);
            }
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(1);

            root.left = new TreeNode(2);
            root.right = new TreeNode(3);

            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);

            root.left.right.left = new TreeNode(7);
            root.left.right.right = new TreeNode(8);
            root.right.left.left = new TreeNode(9);
            root.right.left.right = new TreeNode(10);

            System.out.println(boundaryOfBinaryTree(root));
      }
}
