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
            ListNode current = head;

            while (current.next != null) {
                  for (int i = 0; i < m; i++) {
                        current = current.next;
                  }

                  for (int i = 0; i < n; i++) {
                        current.next = current.next.next;
                  }
            }

            return head;
      }
}
