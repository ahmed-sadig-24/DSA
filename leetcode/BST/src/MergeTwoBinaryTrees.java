public class MergeTwoBinaryTrees {
      //Definition for a binary tree node.
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

      public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                  return root2;
            }

            if (root2 == null) {
                  return root1;
            }

            root1.val += root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);

            return root1;
      }

      public static void main(String[] args) {
            TreeNode roo1 = new TreeNode(1);
            roo1.left = new TreeNode(3);
            roo1.right = new TreeNode(2);
            roo1.left.left = new TreeNode(5);

            TreeNode root2 = new TreeNode(2);
            root2.left = new TreeNode(1);
            root2.right = new TreeNode(3);
            root2.left.right = new TreeNode(4);
            root2.right.right = new TreeNode(7);

            mergeTrees(roo1, root2);

            System.out.println(roo1.val);
            System.out.println(roo1.left.left.val);
      }

}
