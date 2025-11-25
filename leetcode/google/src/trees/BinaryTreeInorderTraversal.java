package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
      // Definition for a binary tree node.
      public class TreeNode {
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

      public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) return result;

            dfs(root, result);

            return result;
      }

      private void dfs(TreeNode node, List<Integer> result) {
            if (node == null) return;

            dfs(node.left, result);
            result.add(node.val);
            dfs(node.right, result);
      }

      public List<Integer> inorderTraversalMorris(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) return result;

            TreeNode curr = root;
            while (curr != null) {
                  if (curr.left == null) {
                        //
                        result.add(curr.val);
                        curr = curr.right;
                  } else {
                        TreeNode pred = curr.left;
                        while (pred.right != null && pred.right != curr) {
                              pred = pred.right;
                        }

                        if (pred.right == null) {
                              pred.right = curr;
                              curr = curr.left;
                        } else {
                              pred.right = null;
                              result.add(curr.val);
                              curr = curr.right;
                        }
                  }
            }

            return result;
      }

}
