import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversalWithoutRecursion {

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

      static ArrayList<Integer> postorder_traversal(BinaryTreeNode root) {
            // Write your code here.
            ArrayList<Integer> result = new ArrayList<>();

            if (root == null) {
                  return result;
            }

            Stack<BinaryTreeNode> stack = new Stack<>();
            BinaryTreeNode current = root;
            BinaryTreeNode lastVisited = null;

            while (!stack.isEmpty() || current != null) {
                  if (current != null) {
                        stack.push(current);
                        current = current.left;
                  } else {
                        BinaryTreeNode peekNode = stack.peek();
                        if (peekNode.right != null && lastVisited != peekNode.right) {
                              current = peekNode.right;
                        } else {
                              result.add(peekNode.value);
                              lastVisited = stack.pop();
                        }
                  }
            }

            return result;
      }

      public static BinaryTreeNode buildTree() {
            BinaryTreeNode root = new BinaryTreeNode(1);
            root.left = new BinaryTreeNode(2);
            root.right = new BinaryTreeNode(3);
            root.left.left = new BinaryTreeNode(4);
            root.left.right = new BinaryTreeNode(5);
            root.right.left = new BinaryTreeNode(6);
            root.right.right = new BinaryTreeNode(7);
            return root;
      }

      public static void main(String[] args) {
            BinaryTreeNode root = buildTree();
            List<Integer> result = postorder_traversal(root);
            System.out.println("Postorder Traversal (without recursion): " + result);
      }

      static ArrayList<Integer> postorder_traversal2(BinaryTreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();

            if (root == null) {
                  return result;
            }

            Stack<BinaryTreeNode> myStack = new Stack<>();
            BinaryTreeNode currentNode = root;
            BinaryTreeNode lastVisitedNode = null;
            while (!myStack.isEmpty() || currentNode != null) {
                  if (currentNode != null) {
                        myStack.push(currentNode);
                        currentNode = currentNode.left;
                  } else {
                        BinaryTreeNode peekNode = myStack.peek();
                        if (peekNode.right != null && peekNode.right != lastVisitedNode) {
                              currentNode = peekNode.right;
                        } else {
                              result.add(peekNode.value);
                              lastVisitedNode = myStack.pop();
                        }
                  }
            }

            return result;
      }
}
