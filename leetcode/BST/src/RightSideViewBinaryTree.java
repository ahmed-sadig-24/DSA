import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewBinaryTree {
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

      public static List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) {
                  return result;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  int size = q.size();
                  for (int i = 0; i < size; i++) {
                        TreeNode currentNode = q.poll();

                        if (i == size - 1) {
                              result.add(currentNode.val);
                        }

                        if (currentNode.left != null) {
                              q.offer(currentNode.left);
                        }
                        if (currentNode.right != null) {
                              q.offer(currentNode.right);
                        }
                  }
            }

            return result;
      }

      public static void main(String[] args) {

            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.right = new TreeNode(5);
            root.right.right = new TreeNode(4);

            TreeNode root2 = new TreeNode(1);
            root2.left = new TreeNode(2);
            root2.right = new TreeNode(3);
            root2.left.left = new TreeNode(4);
            root2.left.left.left = new TreeNode(5);

            System.out.println(rightSideView(root));
            System.out.println(rightSideView(root2));
      }
}
