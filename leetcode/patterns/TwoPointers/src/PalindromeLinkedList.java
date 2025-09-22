public class PalindromeLinkedList {
      // Definition for singly-linked list.
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

      public boolean isPalindrome(ListNode head) {
            if (head == null)
                  return false;
            if (head.next == null)
                  return true;

            // find middle
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                  slow = slow.next;
                  fast = fast.next.next;
            }

            slow = reverseList(slow);
            fast = head;

            while (fast != null && slow != null) {
                  if (fast.val != slow.val) {
                        return false;
                  }

                  fast = fast.next;
                  slow = slow.next;
            }

            return true;
      }

      private static ListNode reverseList(ListNode midNode) {
            ListNode prevNode = null;
            ListNode currNode = midNode;

            while (currNode != null) {
                  ListNode nextNode = currNode.next;
                  currNode.next = prevNode;
                  prevNode = currNode;
                  currNode = nextNode;
            }

            return prevNode;
      }

}
