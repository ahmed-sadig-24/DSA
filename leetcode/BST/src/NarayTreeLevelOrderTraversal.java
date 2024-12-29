import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NarayTreeLevelOrderTraversal {
      // Definition for a Node.
      static class Node {
            public int val;
            public List<Node> children;

            public Node() {
            }

            public Node(int _val) {
                  val = _val;
            }

            public Node(int _val, List<Node> _children) {
                  val = _val;
                  children = _children;
            }
      }

      ;

      public static List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null) return result;

            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  List<Integer> currentLevelNodes = new ArrayList<>();
                  int size = q.size();
                  for (int i = 0; i < size; i++) {
                        Node currentNode = q.poll();
                        currentLevelNodes.add(currentNode.val);
                        if (currentNode.children != null) {
                              for (Node child : currentNode.children) {
                                    q.offer(child);
                              }
                        }
                  }

                  result.add(currentLevelNodes);
            }

            return result;
      }

      public static void main(String[] args) {
            Node root = new Node(1);

      }
}

