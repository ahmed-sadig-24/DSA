import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {

      // Definition for a Node.
      class Node {
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

      public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null) return result;

            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  int size = q.size();
                  List<Integer> currLevel = new ArrayList<>();

                  for (int i = 0; i < size; i++) {
                        Node currNode = q.remove();
                        currLevel.add(currNode.val);

                        if (currNode.children != null) {
                              for (Node child: currNode.children) {
                                    q.offer(child);
                              }
                        }
                  }

                  result.add(currLevel);
            }

            return result;
      }

}
