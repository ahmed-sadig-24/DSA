import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
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


      public static List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return null;

            List<List<Integer>> result = new ArrayList<>();

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                  int size = q.size();
                  List<Integer> currentLevel = new ArrayList<>();
                  for (int i = 0; i < size; i++) {
                        TreeNode currentNode = q.remove();
                        currentLevel.add(currentNode.val);
                        if (currentNode.left != null) {
                              q.add(currentNode.left);
                        }
                        if (currentNode.right != null) {
                              q.add(currentNode.right);
                        }
                  }
                  result.add(currentLevel);
            }

            return result;
      }

      public static List<List<Integer>> levelOrder2(TreeNode root) {
            if (root == null) return null;

            List<List<Integer>> result = new ArrayList<>();

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                  int size = q.size();
                  List<Integer> currentLevel = new ArrayList<>();

                  for (int i = 0; i < size; i ++) {
                        TreeNode currentNode = q.remove();
                        currentLevel.add(currentNode.val);

                        if (currentNode.left != null) {
                              q.add(currentNode.left);
                        }
                        if (currentNode.right != null) {
                              q.add(currentNode.right);
                        }
                  }
                  result.add(currentLevel);
            }

            return result;
      }
      public static void main(String[] args) {
            TreeNode myNode = new TreeNode(3);
            myNode.left = new TreeNode(9);
            myNode.right = new TreeNode(20);
            myNode.right.left = new TreeNode(15);
            myNode.right.right = new TreeNode(7);

            System.out.println(levelOrder(myNode));
            System.out.println(levelOrder2(myNode));
      }

}