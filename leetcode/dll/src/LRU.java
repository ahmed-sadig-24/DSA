import java.util.HashMap;
import java.util.Map;

public class LRU {
      final Node head = new Node();
      final Node tail = new Node();
      Map<Integer, Node> nodeMap;
      int cacheCapacitiy;

      public LRUCache(int capacity) {
            head.next = tail;
            tail.prev = head;
            this.cacheCapacitiy = capacity;

            nodeMap = new HashMap<>(capacity);
      }

      public int get(int key) {
            int result = -1;

            Node myNode = nodeMap.get(key);

            if (myNode != null) {
               result = myNode.val;
               remove(myNode);
               add(myNode);
            }

            return result;
      }

      public void put(int key, int value) {
            Node myNode = nodeMap.get(key);

            if (myNode != null) {
                  remove(myNode);
                  myNode.val = value;
                  add(myNode);
            } else {
                  if (nodeMap.size() == cacheCapacitiy) {
                        nodeMap.remove(tail.prev.key);
                        remove(tail.prev);
                  }

                  Node newNode = new Node();
                  newNode.key = key;
                  newNode.val = value;

                  nodeMap.put(key, newNode);
                  add(newNode);
            }
      }

      public void add(Node myNode) {
            Node headNext = head.next;
            head.next = myNode;
            headNext.prev = myNode;
            myNode.next = headNext;
            myNode.prev = head;
      }

      public void remove(Node myNode) {
            Node prevNode = myNode.prev;
            Node nextNode = myNode.next;

            nextNode.prev = prevNode;
            prevNode.next = nextNode;
      }

      class Node {
            int key;
            int val;
            Node prev;
            Node next;
      }
}
