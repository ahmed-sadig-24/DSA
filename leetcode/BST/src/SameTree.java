import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
      public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                  this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                  this.val = val;
                  this.left = left;
                  this.right = right;
            }
      }

      public static boolean isSameTree(TreeNode p, TreeNode q) {
            Queue<TreeNode> myQueue = new LinkedList<>();

            myQueue.add(p);
            myQueue.add(q);

            while (!myQueue.isEmpty()) {
                  TreeNode first = myQueue.poll();
                  TreeNode second = myQueue.poll();

                  if (first == null || second == null) {
                        continue;
                  } else if (first != null || second != null || first.val != second.val) {
                        return false;
                  }

                  myQueue.add(p.left);
                  myQueue.add(q.left);
                  myQueue.add(p.left);
                  myQueue.add(q.right);
            }

            return true;
      }

}
