import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

//      For your reference:
static class BinaryTreeNode {
          Integer value;
          BinaryTreeNode left;
          BinaryTreeNode right;

          BinaryTreeNode(Integer value) {
              this.value = value;
              this.left = null;
              this.right = null;
          }
      }
      static Integer find_maximum_width(BinaryTreeNode root) {
            // Write your code here.
            if (root == null) {
                  return 0;
            }

            int maxWidth = 0;

            HashMap<BinaryTreeNode, Integer> indexMap = new HashMap<>();
            indexMap.put(root, 0);

            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                  int levelStart = indexMap.get(q.peek());
                  int levelEnd = levelStart;

                  int size = q.size();
                  for (int i = 0; i < size; i++) {
                        BinaryTreeNode currentNode = q.poll();
                        int index = indexMap.get(currentNode);
                        levelEnd = index;

                        if (currentNode.left != null) {
                              q.offer(currentNode.left);
                              indexMap.put(currentNode.left, 2 * index);
                        }
                        if (currentNode.right != null) {
                              q.offer(currentNode.right);
                              indexMap.put(currentNode.right, 2 * index + 1);
                        }
                  }

                  maxWidth = Math.max(maxWidth, levelEnd - levelStart + 1);
            }

            return maxWidth;
      }

      public static void main(String[] args) {
            BinaryTreeNode root = new BinaryTreeNode(1);
            root.left = new BinaryTreeNode(3);
            root.right = new BinaryTreeNode(2);
            root.left.left = new BinaryTreeNode(5);
            root.left.right = new BinaryTreeNode(3);
            root.right.right = new BinaryTreeNode(9);

            //System.out.println(widthOfBinaryTree(root));
            System.out.println(find_maximum_width(root));
      }
}
