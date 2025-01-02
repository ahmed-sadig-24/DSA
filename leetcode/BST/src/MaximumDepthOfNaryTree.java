import java.util.Arrays;
import java.util.List;

public class MaximumDepthOfNaryTree {
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

      public static int maxDepth(Node root) {
            if (root == null) {
                  return 0;
            }

            if (root.children == null) {
                  return 0;
            }

            int height = 0;
            for (Node child : root.children) {
                  int childHeight = maxDepth(child);
                  //System.out.println(childHeight);
                  height = Math.max(height, childHeight);
            }

            return height + 1;
      }

      public static void main(String[] args) {
            //Node root1 = null;
            //System.out.println(maxDepth(root1));
            //Node root2 = new Node(1);
            //System.out.println(maxDepth(root2));

            //Node root3 = new Node(1, Arrays.asList(new Node(2), new Node(3), new Node(4)));
            //System.out.println(maxDepth(root3));

            Node root4 = new Node(1, Arrays.asList(
                    new Node(2, Arrays.asList(new Node(5), new Node(6))),
                    new Node(3),
                    new Node(4, Arrays.asList(new Node(7, Arrays.asList(new Node(8)))))
            ));
            System.out.println("Test Case 4: " + (maxDepth(root4) == 4 ? "Passed" : "Failed"));
      }
}



