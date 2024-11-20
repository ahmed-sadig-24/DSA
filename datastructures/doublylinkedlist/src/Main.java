import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

      public static void main(String[] args) {
            DoubleLinkedList myDoubleLinkedList = new DoubleLinkedList(1);
            //myDoubleLinkedList.prepend(1);
            myDoubleLinkedList.append(2);
            myDoubleLinkedList.append(3);
            myDoubleLinkedList.append(4);
            //myDoubleLinkedList.append(5);
            //myDoubleLinkedList.append(6);
            //myDoubleLinkedList.append(1);
            //myDoubleLinkedList.append(6);
            //System.out.println(myDoubleLinkedList.removeLast().value);
            //System.out.println("First Node Removed: " + myDoubleLinkedList.removeFirst().value);
            //System.out.println(myDoubleLinkedList.get(4).value);
            //myDoubleLinkedList.set(3,40);
            //myDoubleLinkedList.insert(7,20);
            //myDoubleLinkedList.printList();
            //System.out.println("-------\n");
            //myDoubleLinkedList.remove(6);
            //myDoubleLinkedList.swapFirstLast();
            //myDoubleLinkedList.reverse();
            //System.out.println(myDoubleLinkedList.isPalindrome());
            myDoubleLinkedList.swapPairs();
            myDoubleLinkedList.printList();
      }

}