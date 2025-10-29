import java.util.NoSuchElementException;

public class BSTIterator {

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

      private TreeNode curr;

      public BSTIterator(TreeNode root) {
            //TreeNode sentinel = new TreeNode(Integer.MIN_VALUE, null, root);
            this.curr = root;
      }

      public int next() {
            while (curr != null) {
                  if (curr.left == null) {
                        int res = curr.val;
                        curr = curr.right;
                        return res;
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
                              //
                              int res = curr.val;
                              curr = curr.right;
                              return res;
                        }
                  }
            }
            throw new NoSuchElementException();
      }

      public boolean hasNext() {
            return curr != null;
      }

}
