import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ValidateBinarySearchTree {

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

      public static boolean isValidBST(TreeNode root) {
            List<Integer> inOrderList = new ArrayList<>();

            dfs(root, inOrderList);

            int prev = inOrderList.get(0);
            //boolean isBST = true;
            for (int i = 1; i < inOrderList.size(); i++) {
                  if (inOrderList.get(i) <= prev) return false;

                  prev = inOrderList.get(i);
            }
            return true;
      }

      private static void dfs(TreeNode node, List<Integer> inOrderList) {
            if (node == null) return;

            dfs(node.left, inOrderList);
            inOrderList.add(node.val);
            dfs(node.right, inOrderList);
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(2);
            // Level 1
            root.left = new TreeNode(1);
            root.right = new TreeNode(3);

            System.out.println(isValidBST(root));
            System.out.println(isValidBSTMorris(root));
      }

      public static boolean isValidBSTMorris(TreeNode root) {
            boolean isBST = true;
            int prev = Integer.MIN_VALUE;

            TreeNode curr = root;
            while (curr != null) {
                  if (curr.left == null) {
                        if (curr.val <= prev) return false;
                        prev = curr.val;

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
                              predecessor.right = null;
                              //
                              if (curr.val <= prev) return false;
                              prev = curr.val;

                              curr = curr.right;
                        }
                  }
            }

            return true;
      }
}
