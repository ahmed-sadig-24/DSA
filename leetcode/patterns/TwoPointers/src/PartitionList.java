public class PartitionList {

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

      public static ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) {
                  return head;
            }

            ListNode lSentinel = new ListNode(Integer.MAX_VALUE);
            ListNode lCurr = lSentinel;
            ListNode gSentinel = new ListNode(Integer.MIN_VALUE);
            ListNode gCurr = gSentinel;

            while (head != null) {
                  if (head.val < x) {
                        lCurr.next = head;
                        lCurr = head;
                  } else {
                        gCurr.next = head;
                        gCurr = head;
                  }

                  head = head.next;
            }

            gCurr.next = null;
            lCurr.next = gSentinel.next;

            return lSentinel.next;
      }

}
