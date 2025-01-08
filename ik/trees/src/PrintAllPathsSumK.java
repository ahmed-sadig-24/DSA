import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PrintAllPathsSumK {

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

      static ArrayList<ArrayList<Integer>> all_paths_sum_k(BinaryTreeNode root, Integer k) {
            // Write your code here.
            ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
            //paths.add(Arrays.asList(-1,-1));

            if (root == null) {
                  return paths;
            }

            findPaths(root, new ArrayList<Integer>(), paths, k);

            //return paths.isEmpty() ?  paths.add(new ArrayList<>(Arrays.asList(-1)))  : paths;
            if (paths.isEmpty()) {
                  paths.add(new ArrayList<>(Arrays.asList(-1)));
            }

            return paths;
      }

      static void findPaths(BinaryTreeNode root, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> paths, int targetSum) {
            if (root == null) {
                  return;
            }

            current.add(root.value);
            int newTargetSum = targetSum - root.value;

            if (root.left == null && root.right == null && root.value == targetSum) {
                  paths.add(current);
            } else {
                  findPaths(root.left, new ArrayList<Integer>(current), paths, newTargetSum);
                  findPaths(root.right, new ArrayList<Integer>(current), paths, newTargetSum);
            }
      }

      public static void main(String[] args) {
            /*
            BinaryTreeNode root = new BinaryTreeNode(5);
            root.left = new BinaryTreeNode(4);
            root.right = new BinaryTreeNode(8);
            root.left.left = new BinaryTreeNode(11);
            root.right.left = new BinaryTreeNode(13);
            root.right.right = new BinaryTreeNode(4);
            root.left.left.left = new BinaryTreeNode(7);
            root.left.left.right = new BinaryTreeNode(2);
            root.right.right.left = new BinaryTreeNode(5);
            root.right.right.right = new BinaryTreeNode(1);

             */

            BinaryTreeNode root = new BinaryTreeNode(10000);
            root.left = new BinaryTreeNode(10000);
            root.left.left = new BinaryTreeNode(0);

            //System.out.println(all_paths_sum_k(root, 22));
            System.out.println(all_paths_sum_k(root, 0));
      }

}
