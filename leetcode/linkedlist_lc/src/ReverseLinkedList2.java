public class ReverseLinkedList2 {

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

      public static ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
            ListNode startPrev = sentinel;

            for (int i = 0; i < left - 1; i++) {
                  startPrev = startPrev.next;
            }
            ListNode curr = startPrev.next;

            ListNode sublistHead = curr;
            ListNode sublistPrev = null;
            for (int i = 0; i < (right - left) + 1; i++) {
                  ListNode nextNode = curr.next;
                  curr.next = sublistPrev;
                  sublistPrev = curr;
                  curr = nextNode;
            }

            startPrev.next = sublistPrev;
            sublistHead.next = curr;

            return sentinel.next;

      }

}
