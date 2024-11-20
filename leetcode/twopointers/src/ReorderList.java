import java.util.List;

public class ReorderList {
      // Definition for singly-linked list.
      public static class ListNode {
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

      public static void reorderList(ListNode head) {
            if (head == null || head.next == null) return;

            // find the middle
            ListNode p1 = head;
            ListNode p2 = head;
            while (p2.next != null && p2.next.next != null) {
                  p1 = p1.next;
                  p2 = p2.next.next;
            }

            // reverse after middle
            ListNode middle = p1;
            ListNode before = null;
            ListNode curr = middle.next;
            while (curr != null) {
                  ListNode after = curr.next;
                  curr.next = before;
                  before = curr;
                  curr = after;
            }
            middle.next = before;

            // reorder
            p1 = head;
            p2 = middle.next;
            while (p1 != middle) {
                  middle.next = p2.next;
                  p2.next = p1.next;
                  p1.next = p2;
                  p1 = p2.next;
                  p2 = middle.next;
            }
      }

      public static void main(String[] args) {
            /*
            ListNode head = new ListNode(4);
            head.next = new ListNode(8);
            head.next.next = new ListNode(15);
            head.next.next.next = new ListNode(16);
            head.next.next.next.next = new ListNode(23);


             */

            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            reorderList(head);


            ListNode temp = head;
            while (temp != null) {
                  System.out.print(temp.val + "-");
                  temp = temp.next;
            }


      }
}
