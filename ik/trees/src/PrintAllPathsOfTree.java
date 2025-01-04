import java.util.ArrayList;
import java.util.Arrays;

public class PrintAllPathsOfTree {

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

      static ArrayList<ArrayList<Integer>> all_paths_of_a_binary_tree(BinaryTreeNode root) {
            // Write your code here.
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            if (root == null) {
                  return result;
            }

            ArrayList<Integer> current = new ArrayList<>();
            dfs(root, current, result);

            return result;
      }

      static void dfs(BinaryTreeNode node, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
            if (node == null) {
                  return;
            }

            current.add(node.value);

            if (node.left == null && node.right == null) {
                  result.add(new ArrayList<>(current));
            } else {
                  dfs(node.left, current, result);
                  dfs(node.right, current, result);
            }

            current.remove(current.size() - 1);
      }

      public static void main(String[] args) {
            BinaryTreeNode root = new BinaryTreeNode(1);
            root.left = new BinaryTreeNode(2);
            root.right = new BinaryTreeNode(3);
            root.left.left = new BinaryTreeNode(4);
            root.left.right = new BinaryTreeNode(5);
            root.right.left = new BinaryTreeNode(6);
            root.right.right = new BinaryTreeNode(7);

            System.out.println(all_paths_of_a_binary_tree(root));
      }

}
