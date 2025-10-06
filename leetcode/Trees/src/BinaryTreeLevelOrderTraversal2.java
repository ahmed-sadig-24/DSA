import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {

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

      public static List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null) return result;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  int qSize = q.size();
                  List<Integer> currLevel = new ArrayList<>();

                  for (int i = 0; i < qSize; i++) {
                        TreeNode currNode = q.remove();
                        currLevel.add(currNode.val);

                        if (currNode.left != null) {
                              q.offer(currNode.left);
                        }
                        if (currNode.right != null) {
                              q.offer(currNode.right);
                        }
                  }

                  //result.addFirst(currLevel);
                  result.add(currLevel);


            }

            //return result;
            return result.reversed();
      }

      public static void main(String[] args) {
            // Level 0
            TreeNode root4 = new TreeNode(3);
            // Level 1
            root4.left = new TreeNode(9);
            root4.right = new TreeNode(20);
            // Level 2
            root4.right.left = new TreeNode(15);
            root4.right.right = new TreeNode(7);
            //root4.right.right = new TreeNode(6); // Right-most node on this level

            System.out.println(levelOrderBottom(root4));
      }

}
