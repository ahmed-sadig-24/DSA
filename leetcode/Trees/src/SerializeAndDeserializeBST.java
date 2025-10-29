import java.util.Arrays;

public class SerializeAndDeserializeBST {

      // Definition for a binary tree node.
      public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                  val = x;
            }
      }

      private static int preIndex = 0;

      // Encodes a tree to a single string.
      public static String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preorder(root, sb);

            return sb.toString().trim();
      }

      private static void preorder(TreeNode node, StringBuilder sb) {
            if (node == null) return;

            sb.append(node.val).append(" ");
            preorder(node.left, sb);
            preorder(node.right, sb);
      }

      // Decodes your encoded data to tree.
      public static TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;

            int[] preorder = Arrays.stream(data.split(" ")).mapToInt(Integer::parseInt).toArray();

            return buildTree(preorder, Integer.MAX_VALUE);
      }

      private static TreeNode buildTree(int[] preorder, int max) {
            if (preIndex == preorder.length || preorder[preIndex] > max) {
                  return null;
            }

            //
            int rootVal = preorder[preIndex++];
            TreeNode root = new TreeNode(rootVal);
            root.left = buildTree(preorder, rootVal);
            root.right = buildTree(preorder, max);

            return root;
      }
}
