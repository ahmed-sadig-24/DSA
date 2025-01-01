public class ConvertSortedListToBST {

      //      For your reference:
      static class LinkedListNode {
            Integer value;
            LinkedListNode next;

            LinkedListNode(Integer value) {
                  this.value = value;
                  this.next = null;
            }
      }

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

      static BinaryTreeNode sorted_list_to_bst(LinkedListNode head) {
            // Write your code here.
            if (head == null) {
                  return null;
            }

            if (head.next == null) {
                  return new BinaryTreeNode(head.value);
            }

            LinkedListNode midNode =  getMidNode(head);
            BinaryTreeNode root = new BinaryTreeNode(midNode.value);
            root.left = sorted_list_to_bst(head);
            root.right = sorted_list_to_bst(midNode.next);

            return root;
      }

      static LinkedListNode getMidNode(LinkedListNode head) {
            LinkedListNode prev = null;
            LinkedListNode slow = head;
            LinkedListNode fast = head;

            while (fast != null && fast.next != null) {
                  prev = slow;
                  slow = slow.next;
                  fast = fast.next.next;
            }
            if (prev != null) {
                  prev.next = null;
            }

            return slow;
      }

}
