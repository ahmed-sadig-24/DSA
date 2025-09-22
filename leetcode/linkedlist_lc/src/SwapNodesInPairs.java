public class SwapNodesInPairs {
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

      public static ListNode swapPairs(ListNode head) {
            ListNode sentinel = new ListNode(Integer.MIN_VALUE,head);
            ListNode current = sentinel;

            while (current.next != null && current.next.next != null) {
                  ListNode swap1 = current.next;
                  ListNode swap2 = current.next.next;

                  swap1.next = swap2.next;
                  swap2.next = swap1;

                  current.next = swap2;
                  current = swap1;
            }

            return sentinel.next;
      }

}
