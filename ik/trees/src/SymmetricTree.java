import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SymmetricTree {
      //For your reference:
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

      static Boolean check_if_symmetric(BinaryTreeNode root) {
            // Write your code here.
            if (root == null) return true;

           Queue<BinaryTreeNode> leftTreeQ = new LinkedList<>();
           Queue<BinaryTreeNode> rightTreeQ = new LinkedList<>();

           leftTreeQ.add(root.left);
           rightTreeQ.add(root.right);
           while (!leftTreeQ.isEmpty() && !rightTreeQ.isEmpty()) {
                 BinaryTreeNode leftNode  = leftTreeQ.poll();
                 BinaryTreeNode rightNode = rightTreeQ.poll();

                 if (leftNode == null && rightNode == null) {
                       continue;
                 }
                 //if (leftNode == null || rightNode == null) {
                   //    return false;
                 //}
                 if (leftNode == null || rightNode == null || !Objects.equals(leftNode.value, rightNode.value)) {
                       return false;
                 }

                 leftTreeQ.add(leftNode.left);
                 leftTreeQ.add(leftNode.right);

                 rightTreeQ.add(rightNode.right);
                 rightTreeQ.add(rightNode.left);
           }

           //return true;
            return leftTreeQ.isEmpty() && rightTreeQ.isEmpty();
      }

      public static void main(String[] args) {
            BinaryTreeNode myNode = new BinaryTreeNode(1);

            myNode.left = new BinaryTreeNode(2);
            myNode.left.left = new BinaryTreeNode(3);
            myNode.left.right = new BinaryTreeNode(4);

            myNode.right = new BinaryTreeNode(2);
            myNode.right.right = new BinaryTreeNode(3);
            myNode.right.left = new BinaryTreeNode(4);

            System.out.println(check_if_symmetric(myNode));

      }

}
