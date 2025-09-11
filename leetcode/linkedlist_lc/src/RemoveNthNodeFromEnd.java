public class RemoveNthNodeFromEnd {
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

      public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode preHead = new ListNode(Integer.MIN_VALUE,head);
            ListNode slow = preHead;
            ListNode fast = head;

            for (int i = 0; i < n; i++) {
                  if (fast == null) return null;

                  fast = fast.next;
            }

            while (fast != null) {
                  slow = slow.next;
                  fast = fast.next;
            }

            slow.next = slow.next.next;

            return preHead.next;
      }

      public ListNode removeNthFromEnd2(ListNode head, int n) {
            ListNode sentinel = new ListNode(Integer.MIN_VALUE,head);
            ListNode slow = sentinel;
            ListNode fast = sentinel;

            for (int i = 0; i < n; i++) {
                  fast = fast.next;
            }

            while (fast.next != null) {
                  fast = fast.next;
                  slow = slow.next;
            }
            slow.next = slow.next.next;

            return sentinel.next;
      }
}
