import java.util.ArrayList;
import java.util.Arrays;

public class BSTInsert {
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

      static BinaryTreeNode build_a_bst(ArrayList<Integer> values) {
            // Write your code here.
            BinaryTreeNode root = new BinaryTreeNode(values.get(0));
            //System.out.println("root val: " + root.value);

            for (int i = 1; i < values.size(); i++) {
                  //System.out.println("num: " + values.get(i));
                  insertBST(root, values.get(i));
            }

            //System.out.println(root.right.value);
            return root;
      }

      static void insertBST(BinaryTreeNode root, int val) {
            BinaryTreeNode newNode = new BinaryTreeNode(val);
            //System.out.println(root.value);
            //System.out.println(val);

            if (root == null) {
                  //System.out.println("root is null");
                  return;
            }
            BinaryTreeNode curr = root;
            while (true) {
                  if (newNode.value == curr.value) {
                        return;
                  }
                  if (newNode.value < curr.value) {
                        if (curr.left == null) {
                              curr.left = newNode;
                              return;
                        }
                        curr = curr.left;
                  } else {
                        if (curr.right == null) {
                              //System.out.println("new node: " +  newNode.value);
                              curr.right = newNode;
                              return;
                        }
                        curr = curr.right;
                  }
            }
      }

      public static void main(String[] args) {
            ArrayList<ArrayList<Integer>> input = new ArrayList<>();
            //input.add(new ArrayList<>(Arrays.asList(7, 5, 9)));
            input.add(new ArrayList<>(Arrays.asList(-10000, 10000)));
            build_a_bst(input.get(0));
      }
}
