public class ConvertBSTSortedDLL {
      // Definition for a Node.
      static class LLNode {
            public int val;
            public LLNode prev;
            public LLNode next;

            public LLNode(int val) {
                  this.val = val;
            }
      }

      static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            public TreeNode (int val) {
                  this.val = val;
            }
      }

      static LLNode head;
      static LLNode tail;

      public static TreeNode treeToDoublyList(TreeNode root) {
            if (root == null) {
                  return null;
            }

            helper(root);

            return root;
      }

      private static void helper(TreeNode node) {
            if (node == null) {
                  return;
            }

            helper(node.left);

            LLNode newNode = new LLNode(node.val);
            if (head == null) {
                  head = newNode;
                  tail = newNode;
            } else  {
                  tail.next = newNode;
                  newNode.prev = tail;
                  tail = newNode;
            }

            helper(node.right);
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.right = new TreeNode(5);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);

            System.out.println(treeToDoublyList(root).val);

      }
}

