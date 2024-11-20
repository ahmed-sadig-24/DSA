public class LinkedListIntersection {
      public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
            val = x;
            next = null;
      }
  }

      public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA = getLength(headA);
            int lenB = getLength(headB);

            while (lenA > lenB) {
                  lenA--;
                  headA = headA.next;
            }

            while (lenB > lenA) {
                  lenB--;
                  headB = headB.next;
            }

            while (headA != headB) {
                  headA = headA.next;
                  headB = headB.next;
            }

            return headA;
      }

      private static int getLength(ListNode head) {
            int length = 0;

            while (head != null) {
                  length++;
                  head = head.next;
            }

            return length;
      }

      public static void main(String[] args) {
            //ListNode listA = ne
      }

}
