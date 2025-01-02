import java.security.KeyPair;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumWidthofBinaryTree {

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

      public static int widthOfBinaryTree(TreeNode root) {
            if (root == null) return 0;

            // Use a queue to store nodes and their indices
            Queue<TreeNode> queue = new LinkedList<>();
            HashMap<TreeNode, Integer> indexMap = new HashMap<>();

            queue.offer(root);
            indexMap.put(root, 0); // Start with root at index 0

            int maxWidth = 0;

            while (!queue.isEmpty()) {
                  int size = queue.size();
                  int levelStart = indexMap.get(queue.peek()); // Leftmost index in the level
                  int levelEnd = levelStart; // Initialize rightmost index

                  for (int i = 0; i < size; i++) {
                        TreeNode node = queue.poll();
                        int index = indexMap.get(node);
                        //System.out.println("index: " + index);

                        // Update the rightmost index in the level
                        levelEnd = index;
                        //System.out.println(node.val);
                        System.out.println("level end: " + levelEnd);
                        System.out.println("level start: " + levelStart);

                        // Enqueue left and right children with their respective indices
                        if (node.left != null) {
                              queue.offer(node.left);
                              indexMap.put(node.left, 2 * index);
                        }
                        if (node.right != null) {
                              queue.offer(node.right);
                              indexMap.put(node.right, 2 * index + 1);
                        }
                  }

                  // Update maximum width
                  maxWidth = Math.max(maxWidth, levelEnd - levelStart + 1);
            }

            return maxWidth;
      }

      public static int widthOfBinaryTree2(TreeNode root) {
            if (root == null) {
                  return 0;
            }

            int maxWidth = 0;

            Map<TreeNode, Integer> indexMap = new HashMap<>();
            indexMap.put(root, 0);

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  int levelStart = indexMap.get(q.peek());
                  int levelEnd = levelStart;

                  int size = q.size();
                  for (int i = 0; i < size; i++) {
                        TreeNode currentNode = q.poll();
                        int index = indexMap.get(currentNode);
                        levelEnd = index;

                        if (currentNode.left != null) {
                              q.offer(currentNode.left);
                              indexMap.put(currentNode.left, 2 * index);
                        }
                        if (currentNode.right != null) {
                              q.offer(currentNode.right);
                              indexMap.put(currentNode.right, 2 * index + 1);
                        }
                  }

                  maxWidth = Math.max(maxWidth, levelEnd - levelStart + 1);
            }

            return maxWidth;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(3);
            root.right = new TreeNode(2);
            root.left.left = new TreeNode(5);
            root.left.right = new TreeNode(3);
            root.right.right = new TreeNode(9);

            //System.out.println(widthOfBinaryTree(root));
            System.out.println(widthOfBinaryTree2(root));
      }

}
