import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalofATree {

      //      For your reference:
      class TreeNode {
            Integer value;
            ArrayList<TreeNode> children;

            TreeNode(Integer value) {
                  this.value = value;
                  this.children = new ArrayList(3);
            }
      }

      static ArrayList<ArrayList<Integer>> level_order(TreeNode root) {
            // Write your code here.
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            if (root == null) return result;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  ArrayList<Integer> currentLevelNodes = new ArrayList<>();
                  int size = q.size();
                  for (int i = 0; i < size; i++) {
                        TreeNode currentNode = q.poll();
                        currentLevelNodes.add(currentNode.value);
                        if (currentNode.children != null) {
                              for (TreeNode child : currentNode.children) {
                                    q.offer(child);
                              }
                        }
                  }

                  result.add(currentLevelNodes);
            }

            return result;
      }

}
