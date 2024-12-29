import java.util.ArrayList;

public class PostOrderTraversal {

      //      For your reference:
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

      static ArrayList<Integer> postorder(BinaryTreeNode root) {
            // Write your code here.
            ArrayList<Integer> result = new ArrayList<>();

            dfs(root, result);

            return result;
      }

      static void dfs(BinaryTreeNode root, ArrayList<Integer> result) {
            if (root == null) {
                  return;
            }

            dfs(root.left, result);

            dfs(root.right, result);

            result.add(root.value);
      }

}
