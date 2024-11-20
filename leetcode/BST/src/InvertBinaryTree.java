import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
      public static class TreeNode {
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
      public static TreeNode invertTree(TreeNode root) {
            if(root == null) return null;

            invertTree(root.left);
            invertTree(root.right);

            root.left = root.right;
            root.right = root.left;

            return root;
      }

      public static TreeNode invertTree2(TreeNode root) {
            if (root == null) return null;

            final Queue<TreeNode> myQueue = new LinkedList<>();
            myQueue.add(root);

            while (!myQueue.isEmpty()) {
                  final TreeNode myNode = myQueue.poll();

                  //swap nodes
                  final TreeNode temp = myNode.left;
                  myNode.left = myNode.right;
                  myNode.right = temp;

                  // Add left and right of this node to the queue
                  if (myNode.left != null) myQueue.add(myNode.left);
                  if (myNode.right != null) myQueue.add(myNode.right);
            }

            return root;
      }

      public static void invertTreeMorris(TreeNode root) {
            TreeNode current = root;

            while (current != null) {
                  if (current.left == null) {
                        // No left subtree, move to the right subtree
                        current = current.right;
                  } else {
                        // Find the predecessor of current
                        TreeNode predecessor = current.left;
                        while (predecessor.right != null && predecessor.right != current) {
                              predecessor = predecessor.right;
                        }

                        if (predecessor.right == null) {
                              // Establish a temporary thread (predecessor's right pointer to current)
                              predecessor.right = current;

                              // Swap the left and right children to invert
                              TreeNode temp = current.left;
                              current.left = current.right;
                              current.right = temp;

                              // Move to the left subtree
                              current = current.left;
                        } else {
                              // Remove the thread and move to the right subtree
                              predecessor.right = null;
                              current = current.right;
                        }
                  }
            }
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

      public static TreeNode invertTreeRec(TreeNode root) {
            if (root == null) return null;

            TreeNode left = invertTreeRec(root.left);
            TreeNode right = invertTreeRec(root.right);

            root.left = right;
            root.right = left;

            return root;
      }

      public static TreeNode invertTreeIter(TreeNode root) {
            if (root == null) return null;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                  TreeNode myNode = q.poll();
                  //swap nodes
                  TreeNode temp = myNode.left;
                  myNode.left = myNode.right;
                  myNode.right = temp;

                  if (myNode.left != null) {
                        q.add(myNode.left);
                  }

                  if (myNode.right != null) {
                        q.add(myNode.right);
                  }
            }

            return root;
      }

      public static void main(String[] args) {
            InvertBinaryTree tree = new InvertBinaryTree();

            TreeNode root = new TreeNode(2);
            root.left = new TreeNode(1);
            root.right = new TreeNode(3);

            System.out.println(invertTreeRec(root));

            //invertTreeMorris(root);
            //System.out.println("Inorder traversal before inversion:");
            //tree.inorderTraversal(root);

            // Invert the binary tree using Morris traversal
            //tree.invertTreeMorris(root);

            System.out.println("\nInorder traversal after inversion:");
            //tree.inorderTraversal(root);

      }
}
