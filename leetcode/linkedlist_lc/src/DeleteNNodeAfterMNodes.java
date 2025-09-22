public class DeleteNNodeAfterMNodes {
      // Definition for singly-linked list.
      public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      public ListNode deleteNodes(ListNode head, int m, int n) {
            ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
            ListNode curr = sentinel;

            while (curr.next != null) {
                  for (int i = 0; i < m; i++) {
                        curr = curr.next;
                        if (curr == null) return sentinel.next;
                  }

                  ListNode scout = curr;
                  for (int i = 0; i < n; i++) {
                        if (scout.next == null) {
                              curr.next = null;
                              return sentinel.next;
                        }
                        scout = scout.next;
                  }
                  curr.next = scout.next;
            }

            return sentinel.next;
      }
}
