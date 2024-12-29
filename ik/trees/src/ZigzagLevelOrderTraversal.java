import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ZigzagLevelOrderTraversal {

      //      For your reference:
      static class BinaryTreeNode {
            Integer value;
            BinaryTreeNode left;
            BinaryTreeNode right;

            BinaryTreeNode(Integer value) {
                  this.value = value;
                  this.left = null;
                  this.right = null;
            }
      }

      static ArrayList<ArrayList<Integer>> zigzag_level_order_traversal(BinaryTreeNode root) {
            // Write your code here.
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            if (root == null) return result;

            boolean leftToRight = true;

            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  int size = q.size();
                  Deque<Integer> currentLevelNodes = new LinkedList<>();
                  for (int i = 0; i < size; i++) {
                        BinaryTreeNode currentNode = q.poll();
                        if (leftToRight) {
                              currentLevelNodes.offerLast(currentNode.value);
                        } else {
                              currentLevelNodes.offerFirst(currentNode.value);
                        }

                        if (currentNode.left != null) {
                              q.offer(currentNode.left);
                        }
                        if (currentNode.right != null) {
                              q.offer(currentNode.right);
                        }
                  }

                  result.add(new ArrayList<>(currentLevelNodes));
                  leftToRight = !leftToRight;
            }

            return result;
      }

      public static void main(String[] args) {
            BinaryTreeNode root = new BinaryTreeNode(3);
            root.left = new BinaryTreeNode(9);
            root.right = new BinaryTreeNode(20);
            root.right.left = new BinaryTreeNode(15);
            root.right.right = new BinaryTreeNode(7);

            System.out.println(zigzag_level_order_traversal(root));
      }

}
