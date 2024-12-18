import java.util.ArrayList;

public class PreOrderTraversal {
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

      static ArrayList<Integer> preorder(BinaryTreeNode root) {
            // Write your code here.
            ArrayList<Integer> result = new ArrayList<>();


            dfs(root, result);

            return result;
      }

      static void dfs(BinaryTreeNode root, ArrayList<Integer> result) {
            if (root == null) return;

            result.add(root.value);

            dfs(root.left, result);

            dfs(root.right, result);
      }


      public static void main(String[] args) {
            BinaryTreeNode myNode = new BinaryTreeNode(1);
            myNode.right = new BinaryTreeNode(2);
            myNode.right.left = new BinaryTreeNode(3);

            System.out.println(preorder(myNode));
      }

}
