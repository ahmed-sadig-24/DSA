package trees;

public class SerializeAndDeserializeBinaryTree {
      // Definition for a binary tree node.
      public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                  val = x;
            }
      }

      private int index;  // global pointer

      // SERIALIZE (preorder)
      public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeDFS(root, sb);
            return sb.toString();
      }

      private void serializeDFS(TreeNode node, StringBuilder sb) {
            if (node == null) {
                  sb.append("null,");
                  return;
            }

            sb.append(node.val).append(",");
            serializeDFS(node.left, sb);
            serializeDFS(node.right, sb);
      }

      // DESERIALIZE using global index
      public TreeNode deserialize(String data) {
            String[] values = data.split(",");
            index = 0;   // reset pointer before starting
            return deserializeDFS(values);
      }

      private TreeNode deserializeDFS(String[] values) {
            if (values[index].equals("null")) {
                  index++;   // move to next token
                  return null;
            }

            TreeNode node = new TreeNode(Integer.parseInt(values[index]));
            index++;

            node.left = deserializeDFS(values);
            node.right = deserializeDFS(values);

            return node;
      }

}
