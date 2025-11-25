package trees;

import java.util.Arrays;

public class SerializeAndDeserializeBST {
      // Definition for a binary tree node.
      public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                  val = x;
            }
      }

      private int preIndex = 0;

      // Encodes a tree to a single string.
      public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();

            serializeDFS(root, sb);

            return sb.toString().trim();
      }

      private void serializeDFS(TreeNode node, StringBuilder sb) {
            if (node == null) return;

            sb.append(node.val).append(",");
            serializeDFS(node.left, sb);
            serializeDFS(node.right, sb);
      }

      // Decodes your encoded data to tree.
      public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;

            int[] preorder = Arrays.stream(data.split(",")).mapToInt(Integer::parseInt).toArray();

            return buildTree(preorder, Integer.MAX_VALUE);
      }

      private TreeNode buildTree(int[] preorder, int max) {
            if (preIndex == preorder.length || preorder[preIndex] > max){
                  return null;
            }

            int rootVal = preorder[preIndex++];
            TreeNode root = new TreeNode(rootVal);
            root.left = buildTree(preorder, rootVal);
            root.right = buildTree(preorder, max);

            return root;
      }

}
