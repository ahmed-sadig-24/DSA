import java.util.*;

public class ZigZagLevelOrderTraversal {
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

      public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) return null;

            List<List<Integer>> result = new ArrayList<>();

            boolean leftToRight = true;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                  int size = q.size();
                  //List<Integer> currentLevel = new ArrayList<>();
                  Deque<Integer> levelNodes = new LinkedList<>();

                  for (int i = 0; i < size; i++) {
                        TreeNode currentNode = q.poll();

                        if (leftToRight) {
                              levelNodes.offerLast(currentNode.val);
                        } else {
                              levelNodes.offerFirst(currentNode.val);
                        }

                        if (currentNode.left != null) {
                              q.add(currentNode.left);
                        }
                        if (currentNode.right != null){
                              q.add(currentNode.right);
                        }

                  }
                  result.add(new ArrayList<>(levelNodes));

                  leftToRight = !leftToRight;
            }

            return result;
      }

      public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null) return result;

            boolean leftToRight = true;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  int size = q.size();
                  List<Integer> currentLevel = new ArrayList<>();
                  for (int i = 0; i < size; i++) {
                        TreeNode currentNode = q.poll();

                        if (leftToRight) {
                              currentLevel.add(currentNode.val);
                        } else {
                              currentLevel.add(0, currentNode.val);
                        }

                        if (currentNode.left != null) {
                              q.offer(currentNode.left);
                        }

                        if (currentNode.right != null) {
                              q.offer(currentNode.right);
                        }
                  }

                  result.add(currentLevel);
                  leftToRight = !leftToRight;
            }

            return result;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);

            System.out.println(zigzagLevelOrder(root));
      }

}
