public class RemoveNthNodeFromEndLL {

      // Definition for singly-linked list.
      public static class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                  this.val = val;
            }

            ListNode(int val, ListNode next) {
                  this.val = val;
                  this.next = next;
            }
      }

      public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
            ListNode slow = sentinel;
            ListNode fast = sentinel;

            for (int i = 0; i < n; i++) {
                  fast = fast.next;
            }

            while (fast.next != null) {
                  slow = slow.next;
                  fast = fast.next;
            }
            slow.next = slow.next.next;

            return sentinel.next;
      }
}
