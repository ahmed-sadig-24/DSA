import java.util.ArrayList;

public class InOrderTraversal {


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

      static ArrayList<Integer> inorder(BinaryTreeNode root) {
            // Write your code here.
            ArrayList<Integer> result = new ArrayList<>();

            dfs(root, result);

            return result;
      }

      static void dfs(BinaryTreeNode root, ArrayList<Integer> result) {
            if (root == null) return;

            dfs(root.left, result);

            result.add(root.value);

            dfs(root.right, result);
      }

      public static void main(String[] args) {
            BinaryTreeNode myNode = new BinaryTreeNode(1);
            myNode.right = new BinaryTreeNode(2);
            myNode.right.left = new BinaryTreeNode(3);

            System.out.println(inorder(myNode));
      }

}
