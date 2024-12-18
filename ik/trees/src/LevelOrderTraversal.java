import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {


      //For your reference:
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

      static ArrayList<ArrayList<Integer>> level_order_traversal(BinaryTreeNode root) {
            // Write your code here.
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            if (root == null) return result;

            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                  ArrayList<Integer> current = new ArrayList<>();
                  int size = q.size();
                  for (int i = 0; i < size; i++) {
                        BinaryTreeNode currentNode = q.remove();
                        current.add(currentNode.value);

                        if (currentNode.left != null) {
                              q.add(currentNode.left);
                        }
                        if (currentNode.right != null) {
                              q.add(currentNode.right);
                        }
                  }

                  result.add(current);
            }

            return result;
      }

}
