public class BTMaxDepthMorris {
      static class TreeNode {
            int val;
            TreeNode left, right;

            TreeNode(int x) {
                  val = x;
                  left = right = null;
            }
      }

            public static int maxDepth(TreeNode root) {
                  if (root == null) return 0;

                  int maxDepth = 0;
                  int currentDepth = 0;
                  TreeNode current = root;

                  while (current != null) {
                        if (current.left == null) {
                              // Visit the node and move to right
                              currentDepth++;  // We are going deeper
                              maxDepth = Math.max(maxDepth, currentDepth);
                              current = current.right;
                        } else {
                              // Find the inorder predecessor of current
                              TreeNode predecessor = current.left;
                              int steps = 1;  // To track how deep we are going left
                              while (predecessor.right != null && predecessor.right != current) {
                                    predecessor = predecessor.right;
                                    steps++;
                              }

                              if (predecessor.right == null) {
                                    // Make current as the right child of its inorder predecessor
                                    predecessor.right = current;
                                    currentDepth++;  // Going deeper
                                    current = current.left;
                              } else {
                                    // Revert the changes and move to right
                                    predecessor.right = null;
                                    currentDepth -= steps;  // Going back up
                                    current = current.right;
                              }
                        }
                  }
                  return maxDepth;
            }

            public static void main(String[] args) {
                  TreeNode root = new TreeNode(1);
                  root.left = new TreeNode(2);
                  root.right = new TreeNode(3);
                  root.left.left = new TreeNode(4);
                  root.left.right = new TreeNode(5);
                  //root.left.left.left = new TreeNode(6);

                  System.out.println("Max Depth: " + maxDepth(root));  // Output: 4
            }
}