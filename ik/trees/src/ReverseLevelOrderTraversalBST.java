import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseLevelOrderTraversalBST {

      //      For your reference:
      class BinaryTreeNode {
            Integer value;
            BinaryTreeNode left;
            BinaryTreeNode right;

            BinaryTreeNode(Integer value) {
                  this.value = value;
                  this.left = null;
                  this.right = null;
            }
      }

      static ArrayList<ArrayList<Integer>> reverse_level_order_traversal(BinaryTreeNode root) {
            // Write your code here.
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            if (root == null) return result;

            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  ArrayList<Integer> currentLevelNodes = new ArrayList<>();

                  int size = q.size();
                  for (int i = 0; i < size; i++) {
                        BinaryTreeNode currentNode = q.poll();
                        currentLevelNodes.add(currentNode.value);

                        if (currentNode.left != null) {
                              q.offer(currentNode.left);
                        }
                        if (currentNode.right != null) {
                              q.offer(currentNode.right);
                        }
                  }

                  result.add(0, currentLevelNodes);
            }

            return result;
      }

}
