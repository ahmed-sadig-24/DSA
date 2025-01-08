public class ConvertBSTSortedDLL_ {
      // Definition for a Node.
      class Node {
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

      private Node prev;
      private Node head;

      public Node treeToDoublyList(Node root) {
            if (root == null) {
                  return null;
            }

            inOrderTraversal(root);

            prev.right = head;
            head.left = prev;

            return head;
      }

      private void inOrderTraversal(Node node) {
            if (node == null) {
                  return;
            }

            inOrderTraversal(node.left);

            if (head == null) {
                  head = node;
            } else {
                  prev.right = node;
                  node.left = prev;
            }
            prev = node;

            inOrderTraversal(node.right);
      }
}
