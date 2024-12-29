import java.util.LinkedList;
import java.util.Queue;

public class BTMaxDepth {

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

      public int maxDepth(TreeNode root) {
            if (root == null) return 0;

            Queue<TreeNode> queueElement = new LinkedList<>();
            queueElement.add(root);

            int levelsCount = 0;

            while (true) {
                  int levelNodesCount = queueElement.size();
                  if (levelNodesCount == 0) {
                        return levelsCount;
                  }

                  while (levelNodesCount > 0) {
                        TreeNode element = queueElement.poll();

                        if (element.left != null) {
                              queueElement.add(element.left);
                        }
                        if (element.right != null) {
                              queueElement.add(element.right);
                        }

                        levelNodesCount--;
                  }

                  levelsCount++;
            }
      }

      public static int maxDepthMorris(TreeNode root) {
            if (root == null) return 0;

            int currentDepth = 0;
            int maxDepth = 0;
            TreeNode current = root;

            while (current != null) {
                  if (current.left == null) {
                        currentDepth++;
                        maxDepth = Math.max(maxDepth, currentDepth);
                        System.out.println(current.val);
                        current = current.right;
                  } else {
                        TreeNode predecessor = current.left;
                        int steps = 1;

                        while (predecessor.right != null && predecessor.right != current) {
                              predecessor = predecessor.right;
                              steps++;
                        }

                        if (predecessor.right == null) {
                              predecessor.right = current;
                              currentDepth++;
                              current = current.left;
                        } else  {
                              predecessor.right = null;
                              currentDepth -= steps;
                              System.out.println(current.val);
                              current = current.right;
                        }
                  }
            }

            return maxDepth;
      }

      public static void main (String[]args){
            /*
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.left.left.left = new TreeNode(6);

            System.out.println("Max Depth: " + maxDepthMorris2(root));  // Output: 4

             */
            TreeNode root = new TreeNode(0);
            root.left = new TreeNode(2);
            root.right = new TreeNode(4);
            root.left.left = new TreeNode(1);
            root.left.left.left = new TreeNode(5);
            root.left.left.right = new TreeNode(1);
            root.right.left = new TreeNode(3);
            root.right.left.right = new TreeNode(3);
            root.right.right = new TreeNode(-1);
            root.right.right.right = new TreeNode(8);

            System.out.println("Max Depth: " + maxDepthMorris2(root));  // Output: 4
      }

      public static int maxDepthMorris2(TreeNode root) {
            if(root == null) return 0;

            TreeNode current = root;
            int currDepth = 0;
            int maxDepth = 0;

            while (current != null) {
                  if(current.left == null) {
                        currDepth++;
                        maxDepth = Math.max(maxDepth, currDepth);
                        //System.out.println(current.val);
                        current = current.right;
                  } else {
                        System.out.println("here: " + current.left.val);
                        TreeNode predecessor = current.left;

                        while (predecessor.right != null && predecessor.right != current) {
                              predecessor = predecessor.right;
                        }

                        if (predecessor.right == null) {
                              predecessor.right = current;
                              currDepth++;
                              current = current.left;
                        } else {
                              predecessor.right = null;
                              currDepth--;
                              current = current.right;
                        }
                  }
            }

            return maxDepth;
      }

      public static int maxDepthRecursion(TreeNode root) {
            if (root == null) {
                  return 0;
            }

            int leftDepth = maxDepthRecursion(root.left);
            int rightDepth = maxDepthRecursion(root.right);

            return Math.max(leftDepth, rightDepth) + 1;
      }
}
