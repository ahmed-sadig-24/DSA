//import java.lang.classfile.components.ClassPrinter;

public class BSTMinAbsoluteDiff {
      public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
            }
      }

      int minDiff = Integer.MAX_VALUE;
      Integer prev = null;

      public int getMinimumDifference(TreeNode root) {
            //Exit condition
            if (root == null) return minDiff;

            getMinimumDifference(root.left);

            if (prev != null) {
                  minDiff = Math.min(minDiff, root.val - prev);
            }

            if (root != null) {
                  prev = root.val;
            }

            getMinimumDifference(root.right);

            return minDiff;
      }

      public static void main(String[] args) {
            TreeNode root;
            //root.val = 1;

      }

      public int getMinimumAbsoluteDifference(TreeNode root) {
            int minDiff = Integer.MAX_VALUE;
            TreeNode prev = null;

            TreeNode curr = root;
            while (curr != null) {
                  if (curr.left == null) {
                        if (prev != null) {
                              minDiff = Math.min(minDiff, Math.abs(curr.val - prev.val));
                        }
                        prev = curr;
                        curr = curr.right;
                  } else {
                        TreeNode rightmost = curr.left;
                        while (rightmost.right != null && rightmost.right != curr) {
                              rightmost = rightmost.right;
                        }

                        if (rightmost.right == null) {
                              rightmost.right = curr;
                              curr = curr.left;
                        } else {
                              rightmost.right = null;
                              if (prev != null) {
                                    minDiff = Math.min(minDiff, Math.abs(curr.val - prev.val));
                              }
                              prev = curr;
                              curr = curr.right;
                        }
                  }
            }

            return minDiff;
      }

      public int getMinimumDifferenceMorris(TreeNode root) {
            int minDiff = Integer.MAX_VALUE;
            TreeNode prev = null;

            TreeNode current = root;

            while (current != null) {
                  if (current.left == null) {
                        //visit current
                        if (prev != null) {
                              minDiff = Math.min(minDiff, current.val - prev.val);
                              prev = current;
                        }
                        current = current.right;
                  } else {
                        TreeNode predecessor = current.left;

                        while (predecessor.right !=  current && predecessor.right != null) {
                              predecessor = predecessor.right;
                        }

                        if (predecessor.right == null) {
                              predecessor.right = current;
                              current = current.left;
                        } else {
                              predecessor.right = null;
                              // visit node
                              if (prev != null) {
                                    minDiff = Math.min(minDiff, current.val - prev.val);
                                    prev = current;
                              }
                              current = current.right;
                        }
                  }
            }

            return minDiff;
      }
}
