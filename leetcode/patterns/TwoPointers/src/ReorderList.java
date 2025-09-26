public class ReorderList {
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

      public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;

            // Get middle
            ListNode midNode = getMiddle(head);

            // Reverse second half
            ListNode secondHalf = reverse(midNode);
            midNode.next = null;

            // Reorder
            ListNode p1 = head;
            ListNode p2 = secondHalf;
            while (p2 != null) {
                  ListNode temp1 = p1.next;
                  ListNode temp2 = p2.next;

                  p1.next = p2;
                  p2.next = temp1;

                  p1 = temp1;
                  p2 = temp2;
            }

      }

      private ListNode getMiddle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                  slow = slow.next;
                  fast = fast.next.next;
            }

            return slow;
      }

      private ListNode reverse(ListNode midNode) {
            ListNode prevNode = null;
            ListNode curr = midNode.next;

            while (curr != null) {
                  ListNode nextNode = curr.next;
                  curr.next = prevNode;
                  prevNode = curr;
                  curr = nextNode;
            }

            return prevNode;
      }

      // 🔹 Helper to print linked list
      public void printList(ListNode head) {
            ListNode curr = head;
            while (curr != null) {
                  System.out.print(curr.val);
                  if (curr.next != null) System.out.print(" -> ");
                  curr = curr.next;
            }
            System.out.println();
      }

      // 🔹 Test main
      public static void main(String[] args) {
            ReorderList rl = new ReorderList();

            // build list: 1 -> 2 -> 3 -> 4 -> 5
            ListNode head = rl.new ListNode(1);
            head.next = rl.new ListNode(2);
            head.next.next = rl.new ListNode(3);
            head.next.next.next = rl.new ListNode(4);
            head.next.next.next.next = rl.new ListNode(5);

            System.out.print("Original: ");
            rl.printList(head);

            rl.reorderList(head);

            System.out.print("Reordered: ");
            rl.printList(head);
      }
}
