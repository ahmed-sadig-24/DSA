import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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

      private static int preIndex = 0;

      public static TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inOrderMap = new HashMap<>();

            for (int i = 0; i < inorder.length; i++) {
                  inOrderMap.put(inorder[i], i);
            }

            return splitTree(preorder, inOrderMap, 0, inorder.length - 1);
      }

      private static TreeNode splitTree(int[] preorder, Map<Integer, Integer> inOrderMap, int left, int right) {
            if (left > right) return null;

            int val = preorder[preIndex++];
            TreeNode root = new TreeNode(val);
            int mid = inOrderMap.get(val);
            root.left = splitTree(preorder, inOrderMap, left, mid - 1);
            root.right = splitTree(preorder, inOrderMap, mid + 1, right);

            return root;

      }



}
