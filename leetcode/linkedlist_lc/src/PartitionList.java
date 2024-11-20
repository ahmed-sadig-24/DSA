public class PartitionList {
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

      public ListNode partition(ListNode head, int x) {
             if (head == null || head.next == null) {
                   return head;
             }

             ListNode lowerDummy = new ListNode(Integer.MIN_VALUE);
             ListNode lowerPointer = lowerDummy;
             ListNode greaterDummy = new ListNode(Integer.MIN_VALUE);
             ListNode greaterPointer = greaterDummy;

             while (head != null) {
                   if (head.val < x) {
                        lowerPointer.next = head;
                        lowerPointer = head;
                   } else {
                        greaterPointer.next = head;
                        greaterPointer = head;
                   }

                   head = head.next;
             }

             greaterPointer.next = null;
             lowerPointer.next = lowerDummy.next;

             return lowerDummy.next;
      }
}
