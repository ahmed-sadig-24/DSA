public class LinkedListCycle2 {
      // Definition for singly-linked list.
      class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                  val = x;
                  next = null;
            }
      }

      public ListNode detectCycle(ListNode head) {
            if (head == null) return null;

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                  slow = slow.next;
                  fast = fast.next.next;

                  if (slow == fast) {
                        while (head != slow) {
                              head = head.next;
                              slow = slow.next;
                        }

                        return slow;
                  }
            }

            return null;
      }

}
