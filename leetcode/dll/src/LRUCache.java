import java.util.HashMap;
import java.util.Map;

public class LRUCache {
      final Node head = new Node();
      final Node tail = new Node();
      int cacheCapacity;
      HashMap<Integer, Node> nodeMap;

      public LRUCache(int capacity) {
            this.cacheCapacity = capacity;
            nodeMap = new HashMap<>(capacity);
            head.next = tail;
            tail.prev = head;
      }

      class Node{
            int key;
            int val;
            Node prev;
            Node next;
      }

      public void add(Node node) {
            Node head_next = head.next;
            head.next = node;
            node.prev = head;
            node.next = head_next;
            head_next.prev = node;
      }

      public void remove(Node node) {
            Node prevNode = tail.prev;
            Node nextNode = node.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
      }

      public int get(int key) {
            int result = -1;

            Node node = nodeMap.get(key);
            if (node != null) {
                  result = node.val;
                  remove(node);
                  add(node);
            }

            return result;
      }

      public void put(int key, int value) {
            Node node = nodeMap.get(key);
            if (node != null) {
                  remove(node);
                  node.val = value;
                  add(node);
            } else {
                  if (nodeMap.size() == cacheCapacity) {
                        nodeMap.remove(tail.prev.key);
                        remove(tail.prev);
                  }
                  //Add new node
                  Node newNode = new Node();
                  newNode.key = key;
                  newNode.val = value;

                  nodeMap.put(key, newNode);
                  add(newNode);
            }
      }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

