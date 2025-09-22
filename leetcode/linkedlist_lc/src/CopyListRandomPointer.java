public class CopyListRandomPointer {
      class Node {
            int val;
            Node next;
            Node random;

            public Node(int val) {
                  this.val = val;
                  this.next = null;
                  this.random = null;
            }
      }

      public Node copyRandomList(Node head) {
            if (head == null) return null;

            Node curr = head;

            while (curr != null) {
                  Node newNode = new Node(curr.val);
                  newNode.next = curr.next;
                  curr.next = newNode;
                  curr = newNode.next;
            }

            // copy random pointers
            curr = head;
            while (curr != null) {
                  if (curr.random != null) {
                        curr.next.random = curr.random.next;
                  }
                  curr = curr.next.next;
            }

            // separate the two lists
            curr = head;
            Node newHead = head.next;
            Node newCurr = newHead;

            while (curr != null) {
                  curr.next = newCurr.next;
                  curr = curr.next;

                  if (curr != null) {
                        newCurr.next = curr.next;
                        newCurr = newCurr.next;
                  }
            }

            return newHead;
      }

      public Node copyRandomList2(Node head) {
            if (head == null) return null;

            Node curr = head;
            while (curr != null) {
                  Node newNode = new Node(curr.val);
                  newNode.next = curr.next;
                  curr.next = newNode;
                  curr = newNode.next;
            }

            curr = head;
            while (curr != null) {
                  if (curr.random.next != null) {
                        curr.next.random = curr.random.next;
                  }
                  curr = curr.next.next;
            }

            curr = head;
            Node newHead = head.next;
            Node newCurr = newHead;

            while (curr != null) {
                  curr.next = newCurr.next;
                  curr = curr.next;

                  if (curr != null) {
                        newCurr.next = curr.next;
                        newCurr = newCurr.next;
                  }
            }

            return newHead;
      }
}
