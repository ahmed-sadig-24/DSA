import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

      // Definition for a binary tree node.
      public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                  this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                  this.val = val;
                  this.left = left;
                  this.right = right;
            }
      }

      private static int postIndex;

      public static TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> inOrderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                  inOrderMap.put(inorder[i], i);
            }

            postIndex = postorder.length - 1;

            return splitTree(inOrderMap, postorder, 0, inorder.length - 1);
      }

      private static TreeNode splitTree(Map<Integer, Integer> inOrderMap, int[] postorder, int left, int right) {
            if (left > right) return null;

            int rootVal = postorder[postIndex--];
            TreeNode root = new TreeNode(rootVal);

            int mid = inOrderMap.get(rootVal);

            root.right = splitTree(inOrderMap, postorder, mid + 1, right);
            root.left = splitTree(inOrderMap, postorder, left, mid - 1);

            return root;
      }

}
