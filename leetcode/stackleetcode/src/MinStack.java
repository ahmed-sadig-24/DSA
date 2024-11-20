public class MinStack {
      private Node head;

      public MinStack() {

      }
      public void push(int val) {
            if (head == null) {
                  head = new Node(null, val, val);
            } else  {
                  head = new Node(head, val, Math.min(val, head.minVal));
            }
      }

      public void pop() {
            head = head.next;
      }

      public int top() {
            return head.val;
      }

      public int getMin() {
            return head.minVal;
      }

      private class Node {
            Node next;
            int val;
            int minVal;

            public Node(Node next, int val, int minVal) {
                  this.next = next;
                  this.val = val;
                  this.minVal = minVal;
            }
      }
}
