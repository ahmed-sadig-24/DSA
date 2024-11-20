import java.util.List;

public class SortList {
      public static class ListNode {
           int val;
           ListNode next;
           ListNode() {}
           ListNode(int val) { this.val = val; }
           ListNode(int val, ListNode next) { this.val = val; this.next = next; }
       }

      public static ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode temp = head;
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                  temp = slow;
                  slow = slow.next;
                  fast = fast.next.next;
            }
            System.out.println("temp: " + temp.val);

            temp.next = null;

            ListNode left = sortList(head);
            ListNode right = sortList(slow);

            return merge(left, right);
      }

      public static ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(Integer.MIN_VALUE);
            ListNode current = dummy;

            while (l1 != null && l2 != null) {
                  if (l1.val < l2.val) {
                        current.next = l1;
                        l1 = l1.next;
                  } else {
                        current.next = l2;
                        l2 = l2.next;
                  }

                  current = current.next;
            }

            if (l1 != null) {
                  current.next = l1;
                  l1 = l1.next;
            }

            if (l2 != null) {
                  current.next = l2;
                  l2 = l2.next;
            }

            System.out.println(dummy.next.val);
            return dummy.next;
      }
      public static void main(String[] args) {
            //int[] list1 = {4, 2, 1, 3};
            ListNode head  = new ListNode(4);
            head.next = new ListNode(2);
            head.next.next = new ListNode(1);
            head.next.next.next = new ListNode(3);

            sortList(head);
            //System.out.println(sortList(head));
            //System.out.println(head);
            //System.out.println(sort);
      }
}
