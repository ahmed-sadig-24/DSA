public class InsertIntoSortedCircularLL {
      // Definition for a Node.
      class Node {
            public int val;
            public Node next;

            public Node() {
            }

            public Node(int _val) {
                  val = _val;
            }

            public Node(int _val, Node _next) {
                  val = _val;
                  next = _next;
            }
      }

      public Node insert(Node head, int insertVal) {
            if (head == null) {
                  Node newNode = new Node(insertVal);
                  newNode.next = newNode;
                  return newNode;
            }

            Node currNode = head;

            while (true) {
                  Node nextNode = currNode.next;
                  if (insertVal >= currNode.val && insertVal <= nextNode.val) {
                        currNode.next = new Node(insertVal, nextNode);
                        return head;
                  }

                  if (currNode.val > nextNode.val) {
                        if (insertVal >= currNode.val || insertVal <= nextNode.val) {
                              currNode.next = new Node(insertVal, nextNode);
                              return head;
                        }
                  }

                  currNode = nextNode;
                  if (currNode == head) break;

            }
            currNode.next = new Node(insertVal, currNode.next);
            return head;
      }
}
