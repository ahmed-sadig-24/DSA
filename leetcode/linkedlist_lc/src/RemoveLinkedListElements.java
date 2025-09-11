public class RemoveLinkedListElements {
       // Definition for singly-linked list.
        public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

      public ListNode removeElements(ListNode head, int val) {
              ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
              ListNode currentNode = sentinel;

              while (currentNode.next != null) {
                    if (currentNode.next.val == val) {
                          currentNode.next = currentNode.next.next;
                    } else {
                          currentNode = currentNode.next;
                    }
              }

              return sentinel.next;
      }
}
