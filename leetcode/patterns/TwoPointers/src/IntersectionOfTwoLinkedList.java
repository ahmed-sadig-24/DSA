public class IntersectionOfTwoLinkedList {
      // Definition for singly-linked list.
      public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                  val = x;
                  next = null;
            }
      }
      public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA = getLen(headA);
            int lenB = getLen(headB);

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

      private static int getLen(ListNode head) {
            int len = 0;

            while (head != null) {
                  head = head.next;
                  len++;
            }

            return len;
      }
}
