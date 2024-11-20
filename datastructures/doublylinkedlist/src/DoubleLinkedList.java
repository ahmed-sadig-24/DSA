public class DoubleLinkedList {

      private Node head;
      private Node tail;
      private int length;

      class Node {
            int value;
            Node next;
            Node prev;

            Node(int value) {
                  this.value = value;
            }
      }

      public DoubleLinkedList(int value) {
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            length = 1;
      }

      public void printList() {
            Node temp = head;

            while (temp != null) {
                  System.out.println(temp.value);
                  temp = temp.next;
            }
      }

      public void getHead() {
            System.out.println("Head: " + head.value);
      }

      public void getTail() {
            System.out.println("Tail: " + tail.value);
      }

      public void getLength() {
            System.out.println("Length: " + length);
      }

      public void append(int value) {
            Node newNode = new Node(value);

            if (length == 0) {
                  head = newNode;
                  tail = newNode;
            } else {
                  tail.next = newNode;
                  newNode.prev = tail;
                  tail = newNode;
            }
            length ++;
      }

      public Node removeLast() {
            if (length == 0) return null;

            Node temp = tail;

            if (length == 1) {
                  head = null;
                  tail = null;
            } else {
                  tail = tail.prev;
                  tail.next = null;
                  tail.prev = null;
            }
            length --;
            return  temp;
      }

      public void prepend(int value) {
            Node newNode = new Node(value);

            if (length == 0) {
                  head = newNode;
                  tail = newNode;
            } else {
                  newNode.next = head;
                  head.prev = newNode;
                  head = newNode;
            }
            length ++;
      }

      public Node removeFirst() {
            if (length == 0) return null;

            Node temp = head;

            if (length == 1) {
                  head = null;
                  tail = null;
            } else {
                  head = head.next;
                  head.prev = null;
                  temp.next = null;
            }
            length --;
            return temp;
      }

      public Node get(int index) {
            if (index < 0 || index >= length) return null;

            Node temp = head;

            if (index < length / 2) {
                  for (int i = 0; i < index; i++){
                        temp = temp.next;
                  }
            } else {
                  temp = tail;
                  for (int i = length -1; i > index; i--){
                        temp = temp.prev;
                  }
            }

            return temp;
      }

      public boolean set(int index, int value) {
            Node temp = get(index);

            if (temp != null) {
                  temp.value = value;
                  return true;
            }
            return false;
      }

      public boolean insert(int index, int value) {
            if (index == 0) {
                  prepend(value);
                  return true;
            }
            if (index == length) {
                  append(value);
                  return true;
            }

            Node newNode = new Node(value);
            Node prev = get(index -1);
            Node after = prev.next;
            prev.next = newNode;
            after.prev = newNode;
            newNode.prev = prev;
            newNode.next = after;
            length++;

            return true;
      }

      public boolean remove(int index) {
            if (index == 0) {
                  removeFirst();
                  return true;
            }

            if (index == length) {
                  removeLast();
                  return true;
            }

            Node prev = get(index -1);
            Node temp = prev.next;
            Node after = prev.next.next;

            prev.next = after;
            after.prev = prev;
            temp.next = null;
            temp.prev = null;

            length --;
            return true;
      }

      public void swapFirstLast() {
            if (length < 2) return;

            int temp = head.value;
            head.value = tail.value;
            tail.value = temp;
      }

      public void reverse3() {
            if (length == 0) return;

            Node temp = tail;

            while (temp != null) {
                  System.out.println(temp.value);
                  temp = temp.prev;
            }
      }

      public void reverse2() {
            if (length == 0 ) return;

            Node temp = head;
            head = tail;
            tail = temp;

            Node before = null;
            Node current  = temp;

            Node after = current.next;

            while (current != null) {
                  after = current.next;
                  current.prev = before;
                  before = current;
                  after.prev = current;
                  current = after;

            }

      }

      public void reverse_c() {
            if (length == 0) return;

            Node current = head;
            Node temp = null;

            while (current != null) {
                  temp = current.prev;
                  current.prev = current.next;
                  current.next = temp;
                  current = current.prev;
            }

            temp = head;
            head = tail;
            tail = temp;
      }















      public void reverse() {
            if (length == 0) return;

            Node current = head;
            Node temp = null;

            while (current != null) {
                  temp = current.prev;
                  current.prev = current.next;
                  current.next = temp;
                  current = current.prev;
            }

            temp = head;
            head = tail;
            tail = temp;
      }

      public boolean isPalindrome() {
            if (length == 0) return false;
            if (length == 1) return true;

            Node temp = head;
            Node temp2 = tail;

            for (int i = 0; i < length/2; i++) {
                  if (temp.value != temp2.value) return false;
                  //System.out.println(temp2.value);
                  temp = temp.next;
                  temp2 = temp2.prev;
            }

            return true;
      }

      public void swapPairs() {
            if (length < 2) return;

            Node dummyNode = new Node(0);
            dummyNode.next = head;

            Node pointer = dummyNode;

            Node swap1;
            Node swap2;

            while (pointer.next != null && pointer.next.next != null) {
                  swap1 = pointer.next;
                  swap2 = pointer.next.next;

                  swap1.next = swap2.next;
                  swap2.next = swap1;

                  pointer.next = swap2;
                  pointer = swap1;
            }

            head = dummyNode.next;

      }
}
