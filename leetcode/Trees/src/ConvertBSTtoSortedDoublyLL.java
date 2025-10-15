public class ConvertBSTtoSortedDoublyLL {

      // Definition for a Node.
      static class Node {
            public int val;
            public Node left;
            public Node right;

            public Node() {
            }

            public Node(int _val) {
                  val = _val;
            }

            public Node(int _val, Node _left, Node _right) {
                  val = _val;
                  left = _left;
                  right = _right;
            }

      }

      private static Node first = null;
      private static Node last = null;

      public static Node treeToDoublyList(Node root) {
            if (root == null) return null;

            dfs(root);

            first.left = last;
            last.right = first;

            return first;
      }

      private static void dfs(Node node) {
            if (node == null) return;

            dfs(node.left);

            if (last != null) {
                  last.right = node;
                  node.left = last;
            } else {
                  first = node;
            }

            last = node;

            dfs(node.right);
      }

      public static void main(String[] args) {
            Node root = new Node(4);
            root.left = new Node(2);
            root.right = new Node(5);
            root.left.left = new Node(1);
            root.left.right = new Node(3);

            System.out.println(treeToDoublyList(root).val);

      }
}
