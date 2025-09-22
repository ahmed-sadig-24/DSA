import java.util.List;

public class MiddleOfLinkedList {
      //Definition for singly-linked list.
      public class ListNode {
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

      public static ListNode middleNode(ListNode head) {
            if (head.next == null) return head;

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                  slow = slow.next;
                  fast = fast.next.next;
            }

            return slow;
      }
}
