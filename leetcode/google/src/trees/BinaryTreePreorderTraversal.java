package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

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

      public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) return result;

            dfs(root, result);

            return result;
      }

      private void dfs(TreeNode node, List<Integer> result) {
            if (node == null) return;

            result.add(node.val);
            dfs(node.left, result);
            dfs(node.right, result);
      }


      public List<Integer> preorderTraversalMorris(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            TreeNode curr = root;

            while (curr != null) {
                  if (curr.left == null) {
                        // Preorder: visit before going right
                        result.add(curr.val);
                        curr = curr.right;
                  } else {
                        // Find predecessor (rightmost node in left subtree)
                        TreeNode pred = curr.left;
                        while (pred.right != null && pred.right != curr) {
                              pred = pred.right;
                        }

                        if (pred.right == null) {
                              // Preorder: visit BEFORE creating thread
                              result.add(curr.val);

                              pred.right = curr;   // create thread
                              curr = curr.left;
                        } else {
                              // Thread exists → remove it and move right
                              pred.right = null;
                              curr = curr.right;
                        }
                  }
            }

            return result;
      }


}
