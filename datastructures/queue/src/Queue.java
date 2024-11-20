import org.w3c.dom.Node;

import java.util.Stack;

public class Queue {
      private Node first;
      private Node last;
      private int length;

      class Node {
            int value;
            Node next;

            Node(int value) {
                  this.value = value;
            }
      }

      public Queue(int value) {
            Node newNode = new Node(value);

            first = newNode;
            last = newNode;
            length = 1;
      }

      public void printQueue() {
            Node temp = first;

            while (temp != null) {
                  System.out.println(temp.value);
                  temp = temp.next;
            }
      }

      public void getFirst() {
            if (first == null) {
                  System.out.println("First: null");
            } else {
                  System.out.println("First: " + first.value);
            }
      }

      public void getLast() {
            if (last == null) {
                  System.out.println("Last: null");
            } else {
                  System.out.println("Last: " + last.value);
            }
      }

      public void getLength() {
            System.out.println("Length: " + length);
      }

      public void enqueue(int value) {
            Node newNode = new Node(value);

            if (length == 0) {
                  first = newNode;
                  last = newNode;
            } else {
                  last.next = newNode;
                  last = newNode;
            }
            length ++;
      }

      public Node dequeue() {
            if (length == 0) return null;

            Node temp = first;

            if (length == 1) {
                  first = null;
                  last = null;
            } else {
                  first = first.next;
                  temp.next = null;
            }

            length --;
            return temp;
      }

      public void enqueue2(int value) {
            Queue myQueue2 = new Queue(0);

            myQueue2.enqueue(value);

            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();

            while (!stack1.isEmpty()) {
                  stack2.push(stack1.pop());
                  stack1.push(value);
            }

            while (!stack2.isEmpty()) {
                  stack1.push(stack2.pop());
            }
      }

      public void push(int x) {
            Stack<Integer> inputStack = new Stack<>();
            Stack<Integer> outputStack = new Stack<>();

            inputStack.push(x);
      }
}
