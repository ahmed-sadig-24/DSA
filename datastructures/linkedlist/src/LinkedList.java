import org.w3c.dom.Node;

import java.util.Stack;

public class LinkedList {

 private Node head;
 private Node tail;
 private int length;

 class Node {
     int value;
     Node next;

     Node(int value) {
         this.value = value;
     }
 }
    public LinkedList(int value) {
         Node newNode = new Node(value);
         head = newNode;
         tail = newNode;
         length = 1;
    }

    public void printList() {
     Node temp = head;
     while (temp != null){
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

        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast()
    {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;

        while (temp.next != null)
        {
           pre = temp;
           temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0)
        {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value)
    {
        Node newNode = new Node(value);

        if (length == 0)
        {
            head = newNode;
            tail = newNode;
        } else
        {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
     if (length == 0) return null;
     Node temp = head;
     head = head.next;
     temp.next = null;
     length--;
     if (length == 0){
         tail = null;
     }
     return temp;
    }

    public Node get(int index) {
     if (index < 0 || index >= length) return null;
     Node temp = head;

     for (int i = 0; i < index; i++){
         temp = temp.next;
     }
     return temp;
    }

    public boolean set(int index, int value) {
       Node temp = get(index);

       if (temp != null){
             temp.value = value;
             return true;
       }
       return false;
    }

    public boolean insert(int index, int value) {
       if (index < 0 || index > length) return false;
       if (index == 0) {
             prepend(value);
             return true;
       }
       if (index == length) {
             append(value);
             return true;
       }

       Node newNode = new Node(value);
       Node temp = get(index -1);
       newNode.next = temp.next;
       temp.next = newNode;
       length++;
       return true;
    }

    public Node remove(int index) {
       if (index < 0 || index >= length) return null;
       if (index == 0) return removeFirst();
       if (index == length -1) return  removeLast();

       Node prev = get(index -1);
       Node temp = prev.next;
       prev.next = temp.next;
       temp.next = null;
       length--;

       return temp;
    }

    public void reverse() {
       Node temp = head;
       head = tail;
       tail = temp;
       Node before = null;
       Node after = temp.next;

       for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
          }
    }

    public Node findMiddleNode() {
       Node slow = head;
       Node fast = head;

       //if (head != null)
       while (fast !=null && fast.next !=null) {
             slow = slow.next;
             fast = fast.next.next;
       }

       return slow;
    }

    public boolean hasLoop() {
       Node slow = head;
       Node fast = head;

       while (fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
             if (slow == fast) return true;
       };
       return false;
    }

      public Node findKthFromEnd(int k) {
            Node slow = head;
            Node fast = head;

            for (int i=0; i < k; i++){
                  if (fast == null){
                        return null;
                  }
                  fast = fast.next;
            }

            while (fast != null) {
                  slow = slow.next;
                  fast = fast.next;
            }
            return slow;
      }

      public void partitionList(int x) {
            if (head == null) return;

            Node lowerDummy = new Node(0);
            Node greaterDummy = new Node(0);
            Node lowerP = lowerDummy;
            Node greaterP = greaterDummy;
            Node current = head;

            while (current !=null) {
                  if (current.value < x) {
                        lowerP.next = current;
                        lowerP = current;
                  } else {
                        greaterP.next = current;
                        greaterP = current;
                  }
                  current = current.next;
            }

            greaterP.next = null;
            lowerP.next = greaterDummy.next;
            head = lowerDummy.next;
      }

      public void removeDuplicates() {
            if (head == null) return;

            Node prev = head;
            Node temp = prev.next;

            while (temp != null) {
                  if (temp.value == prev.value) {
                        temp = temp.next;
                        continue;
                  }

                  prev.next = temp;
                  prev = temp;
                  temp = temp.next;
            }
            prev.next = null;
            //return head;
      }

      public int binaryToDecimal() {
            Node temp = head;
            int num = 0;

            while (temp != null) {
                  //num += 1;
                  num = (num * 2) + temp.value;
                  temp = temp.next;
            }
            return num;
      }

      public void reverse2() {
            if (head == null) return;

            Node before = null;
            Node temp = head;
            Node after = temp.next;

            head = tail;
            tail = temp;

            for (int i = 0; i < length; i++) {
                  after = temp.next;
                  temp.next = before;
                  before = temp;
                  temp = after;
            }
      }


      public void reverseBetween(int s, int e) {
            Node leftCurrent = head;
            Node leftBefore = leftCurrent;
            Node subListHead = null;

            for (int i = 1; i < s -1; i++) {
                  leftCurrent = leftCurrent.next;
                  leftBefore = leftCurrent;
            }
            System.out.println("before: " + leftBefore.value);

            subListHead = leftBefore.next;
            //System.out.println(subListHead.value);
            Node subListBefore = null;
            Node subListCurrent = subListHead;
            Node subListAfter = subListCurrent.next;

            for (int i = 0; i < e -s + 1; i++) {
                  subListAfter = subListCurrent.next;
                  subListCurrent.next = subListBefore;
                  subListBefore = subListCurrent;
                  subListCurrent = subListAfter;
            }
            //leftBefore.next = subListHead;
            leftBefore.next = subListBefore;
            subListHead.next = subListCurrent;
            //System.out.println("Sublist Current: " + subListCurrent.value);
            //System.out.println();
            //head = subListBefore;
      }

      public void reverseBetween2(int startIndex, int endIndex) {
            if (head == null) return;

            Node dummyNode = new Node(0);
            dummyNode.next = head;
            Node previousNode = dummyNode;

            for (int i = 0; i < startIndex -1; i++) {
                  previousNode = previousNode.next;
            }
            //System.out.println(previousNode.value);
            Node subListBefore = null;
            Node subListCurrent = previousNode.next;
            Node subListAfter = subListCurrent.next;
            Node subListHead = subListCurrent;
            for (int i = 0; i < endIndex - startIndex + 1; i++) {
                  subListAfter = subListCurrent.next;
                  subListCurrent.next = subListBefore;
                  subListBefore = subListCurrent;
                  subListCurrent = subListAfter;
            }

            previousNode.next = subListBefore;
            subListHead.next = subListCurrent;
            head = dummyNode.next;
            //su
            //System.out.println("Before: " + subListBefore.value);
            //System.out.println(previousNode.value);
            //System.out.println(subListAfter.value);//6
      }

      public void bubbleSort() {
            if (this.length < 2) return;
            for (int i = this.length -1; i > 0; i--) {
                  for (int j = 0; j < i; j++) {
                        
                  }
            }
      }

      public Node findKthFromEndLeet(int k) {
            Node slow = head;
            Node fast = head;

            for (int i = 0; i < k; i++) {
                  if (fast == null){
                        return null;
                  }

                  fast = fast.next;
            }

            while (fast != null)  {
                  slow = slow.next;
                  fast = fast.next;
            }

            return slow;
      }

      public Node removeNthFromEndLeet(int n) {
            Node res = new Node(0);
            res.next = head;
            //head = res.next;
            Node slow = res;
            Node fast = res;

            for (int i = 0; i < n; i++) {
                  if (fast == null) {
                        return null;
                  }

                  fast = fast.next;
            }
            while (fast.next != null) {
                  slow = slow.next;
                  fast = fast.next;
            }


            slow.next = slow.next.next;


            return res.next;
      }

      public void reverseLinkedListLeet() {
            if (head == null) {
                  return;
            }

            if (head.next == null) {
                  return;
            }
            Node before = null;
            Node current = head;
            Node after = current.next;

            while (current != null){
                  after = current.next;
                  current.next = before;
                  before = current;
                  current = after;
            }

            //return before;
            head = before;
      }

      public void reverseLinkedList2Leet(int left, int right) {
            Node dummyNode = new Node(Integer.MIN_VALUE);
            dummyNode.next = head;
            Node leftBefore = dummyNode;
            Node current = head;

            for (int i = 0; i < left -1; i++) {
                  leftBefore = leftBefore.next;
                  System.out.println("Left Before: " + leftBefore.value);
                  current = current.next;
                  //System.out.println("Current1: " + current.value);
            }
            //System.out.println("Current1: " + current.value);
            Node subListHead = current;

            Node before = null;

            for (int i = 0; i < (right - left) + 1; i++) {
                  Node after = current.next;
                  current.next = before;
                  before = current;
                  current = after;
            }

            System.out.println("current: " + current.value);
            leftBefore.next = before;
            subListHead.next = current;
            //before.next = current;

            head = dummyNode.next;

      }

      public void removeDuplicatesLeet() {
            Node prev = head;
            Node temp = head.next;

            while (temp != null) {
                  if (prev.value == temp.value) {
                        temp = temp.next;
                        //prev.next = temp;
                        continue;
                  }

                  prev.next = temp;
                  prev = temp;
                  temp = temp.next;
            }

            prev.next = null;
      }

      public Node partitionListLeet(int x) {
           Node dummyLower = new Node(Integer.MIN_VALUE);
           Node lowerP = dummyLower;
           Node dummyGreater = new Node(Integer.MIN_VALUE);
           Node greaterP = dummyGreater;

           while (head != null) {
                 if (head.value < x) {
                       lowerP.next = head;
                       lowerP = head;
                 } else {
                       greaterP.next = head;
                       greaterP = head;
                 }
                 head = head.next;
           }

           greaterP.next = null;
           lowerP.next = dummyGreater.next;

           head = dummyLower.next;
           return dummyLower.next;
      }

      public void removeDuplicatesLeet2() {
            Node temp = head;

            while (temp.next != null) {
                  if (temp.value == temp.next.value) {
                        temp.next = temp.next.next;
                  } else
                        temp = temp.next;
            }
      }

      public boolean palindromeLinkedListLeetStack() {
            if (head == null) return false;
            if (head.next == null) return true;

            Stack<Integer> myStack = new Stack<>();
            Node temp = head;

            while (temp != null) {
                  myStack.push(temp.value);
                  temp = temp.next;
            }

            temp = head;

            for(int i = 0; i < myStack.size(); i++) {
                  if (myStack.pop() != temp.value) {
                        return false;
                  }
                  temp = temp.next;
            }

            return true;
      }

      public boolean palindromLinkedListLeet() {
            if (head == null) return false;
            if (head.next == null) return true;

            // find the middle node
            Node slow = head;
            Node fast = head;

            while (fast != null &&  fast.next != null) {
                  slow = slow.next;
                  fast = fast.next.next;
            }
            //System.out.println("middle: " + slow.value);

            //reverse
            slow = palindromeReverse(slow);
            fast = head;
            //slow = head;

            while (slow != null) {
                  System.out.println("slow: " + slow.value);
                  System.out.println("fast: " + fast.value);

                  if (fast.value != slow.value) {
                        return false;
                  }
                  fast = fast.next;
                  slow = slow.next;
            }

            return true;
      }

      private Node palindromeReverse(Node midNode) {
             //System.out.println(midNode.value);
             Node before = null;
             Node current = midNode;
             Node after = current.next;

             while (current != null) {
                   //System.out.println("current: " + current.value);
                   after = current.next;
                   current.next = before;
                   before = current;
                   current = after;
             }
            //System.out.println("before: " +  before.value);
            //System.out.println("before next: " + before.next.value);
            //System.out.println("before next next: " +  before.next.next.value);
            return before;
      }

      public void removeLLElements(int val) {
            Node dummy = new Node(Integer.MIN_VALUE);
            Node temp = dummy;
            dummy.next = head;

            //System.out.println("temp next val: " + temp.next.value);
            while (temp.next != null) {
                  //System.out.println("temp.val: " + temp.value);
                  //System.out.println("temp next val: " + temp.next.value);
                  //System.out.println("t val: " + temp.value);
                  if (temp.next.value == val) {
                        //System.out.println("temp next val: " + temp.next.value);
                        //temp = temp.next.next;
                      //  temp.next.next = temp;
                        temp.next = temp.next.next;
                        //temp.next = temp.next;

                  } else {
                        temp = temp.next;
                  }
                  //System.out.println(temp.value);
                  //temp = temp.next;
            }

            //head = dummy.next;
            //return dummy.next;
      }

      public Node swapPairsLeet() {
            Node dummy = new Node(-1);
            dummy.next = head;
            Node pointer = dummy;

            while (pointer.next != null && pointer.next.next != null) {
                  Node swap1 = pointer.next;
                  Node swap2 = pointer.next.next;

                  swap1.next = swap2.next;
                  swap2.next = swap1;

                  pointer.next = swap2;
                  pointer = swap1;
            }

            head = dummy.next;
            return head;
      }
}

