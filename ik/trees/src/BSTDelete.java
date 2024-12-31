import java.util.ArrayList;
import java.util.Arrays;

public class BSTDelete {
  //     For your reference:
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

      static BinaryTreeNode delete_from_bst(BinaryTreeNode root, ArrayList<Integer> values_to_be_deleted) {
            // Write your code here.
            if (values_to_be_deleted == null || values_to_be_deleted.isEmpty()) {
                  return root;
            }

            for (int v: values_to_be_deleted) {
                  deleteNode(root ,v);
            }
            return root;
      }

      static BinaryTreeNode deleteNode(BinaryTreeNode root, int key) {
             BinaryTreeNode currentNode = root;

             //base case
             if (currentNode == null) return null;

             if (key < currentNode.value) {
                   currentNode.left = deleteNode(currentNode.left, key);
             } else if (key > currentNode.value) {
                   currentNode.right = deleteNode(currentNode.right, key);
             } else {
                   if (currentNode.left == null && currentNode.right == null) {
                         return null;
                   } else if (currentNode.left == null) {
                         currentNode = currentNode.right;
                   } else if (currentNode.right == null) {
                         currentNode = currentNode.left;
                   } else {
                         int subTreeMin = minValue(currentNode.right);
                         currentNode.value = subTreeMin;

                         currentNode.right = deleteNode(currentNode.right, subTreeMin);
                   }
             }

             return currentNode;
      }

      static int minValue(BinaryTreeNode currNode) {
             while (currNode.left != null) {
                   currNode = currNode.left;
             }

             return currNode.value;
      }

      public static void main(String[] args) {
             /*
            BinaryTreeNode root = new BinaryTreeNode(4);
            root.left = new BinaryTreeNode(2);
            root.left.left = new BinaryTreeNode(1);
            root.left.right = new BinaryTreeNode(3);
            root.right = new BinaryTreeNode(6);
            root.right.left = new BinaryTreeNode(5);
            root.right.right = new BinaryTreeNode(7);


              */

            BinaryTreeNode root = new BinaryTreeNode(1);

            //System.out.println(minValue(root.right));

            ArrayList<ArrayList<Integer>> input = new ArrayList<>();
            //input.add(new ArrayList<>(Arrays.asList(7, 5, 9)));
            input.add(new ArrayList<>(Arrays.asList(5, 6)));
            delete_from_bst(root, input.get(0));
            System.out.println(root.right.value);
      }

}
