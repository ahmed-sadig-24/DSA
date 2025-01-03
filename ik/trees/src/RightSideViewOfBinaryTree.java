import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightSideViewOfBinaryTree {

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

      static ArrayList<Integer> right_view(BinaryTreeNode root) {
            // Write your code here.
            ArrayList<Integer> result = new ArrayList<>();

            if (root == null) {
                  return result;
            }

            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  int size = q.size();
                  for (int i = 0; i < size; i++) {
                        BinaryTreeNode currentNode = q.poll();

                        if (i == size - 1) {
                              result.add(currentNode.value);
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

            BinaryTreeNode root = new BinaryTreeNode(1);
            root.left = new BinaryTreeNode(2);
            root.right = new BinaryTreeNode(3);
            root.left.right = new BinaryTreeNode(5);
            root.right.right = new BinaryTreeNode(4);

            BinaryTreeNode root2 = new BinaryTreeNode(1);
            root2.left = new BinaryTreeNode(2);
            root2.right = new BinaryTreeNode(3);
            root2.left.left = new BinaryTreeNode(4);
            root2.left.left.left = new BinaryTreeNode(5);

            System.out.println(right_view(root));
            System.out.println(right_view(root2));
      }

}
