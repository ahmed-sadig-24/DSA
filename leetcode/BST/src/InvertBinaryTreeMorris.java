public class InvertBinaryTreeMorris {

      public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int val) {
                  this.val = val;
            }
      }

      public static TreeNode invertTree(TreeNode root) {
            TreeNode current = root;

            while (current != null) {
                  // Find the rightmost node in the left subtree
                  TreeNode rightmost = current.left;
                  while (rightmost != null && rightmost.right != null) {
                        rightmost = rightmost.right;
                  }

                  // If there's no right child in the left subtree, invert the left child
                  if (rightmost == null) {
                        current.left = invert(current.left);
                        current = current.right;
                  } else {
                        // Swap the left and right children
                        TreeNode temp = rightmost.right;
                        rightmost.right = current.left;
                        current.left = temp;
                        current = current.right;
                  }
            }

            return root;
      }

      private static TreeNode invert(TreeNode node) {
            if (node == null) {
                  return null;
            }

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            return node;
      }


      // Helper function to print the tree in inorder traversal
      public static void inorderTraversal(TreeNode root) {
            if (root == null) {
                  return;
            }
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
      }

      public static void main(String[] args) {
            InvertBinaryTreeMorris tree = new InvertBinaryTreeMorris();

            // Construct the binary tree
            /*
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            /
             */

            TreeNode root = new TreeNode(2);
            root.left = new TreeNode(1);
            root.right = new TreeNode(3);

            System.out.println("Inorder traversal before inversion:");
            tree.inorderTraversal(root);

            // Invert the binary tree using Morris traversal
            tree.invertTree(root);

            System.out.println("\nInorder traversal after inversion:");
            tree.inorderTraversal(root);
      }
}
