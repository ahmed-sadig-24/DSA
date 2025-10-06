import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

      // Definition for a binary tree node.
      public class TreeNode {
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

      public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null) return result;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                  int size = q.size();
                  List<Integer> currLevel = new ArrayList<>();
                  for (int i = 0;i < size; i++) {
                        TreeNode currNode = q.remove();
                        currLevel.add(currNode.val);

                        if (currNode.left != null) {
                              q.add(currNode.left);
                        }
                        if (currNode.right != null) {
                              q.add(currNode.right);
                        }
                  }

                  result.add(currLevel);
            }

            return result;
      }
}
