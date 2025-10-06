import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthOfNaryTree {

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

      public int maxDepth(Node root) {
            if (root == null) return 0;

            int depth = 0;
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  depth++;

                  int qSize = q.size();
                  for (int i = 0; i < qSize; i++) {
                      Node currNode = q.remove();

                      if (currNode.children != null) {
                            for (Node child: currNode.children) {
                                  q.offer(child);
                            }
                      }
                  }
            }

            return depth;
      }
}
