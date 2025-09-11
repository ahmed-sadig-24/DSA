public class RemoveDuplicatesSortedList {
       // Definition for singly-linked list.
        public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

      public ListNode deleteDuplicates(ListNode head) {
              if (head == null) {
                    return null;
              }

              ListNode currNode = head;

              while (currNode != null && currNode.next != null) {
                    if (currNode.val == currNode.next.val) {
                          currNode.next = currNode.next.next;
                    } else {
                          currNode = currNode.next;
                    }
              }

              return head;
      }

}
