import java.util.Stack;

public class PathSum {
      public static class TreeNode {
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

      public static boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;

            Stack<TreeNode> pathStack = new Stack<>();
            Stack<Integer> sumStack = new Stack<>();

            pathStack.push(root);
            sumStack.push(root.val);

            while (!pathStack.isEmpty()) {
                  TreeNode tempNode = pathStack.pop();
                  int tempVal = sumStack.pop();

                  //System.out.println(targetSum);
                  if (tempNode.left == null && tempNode.right == null && tempVal == targetSum) {
                        return true;
                  }

                  if (tempNode.left != null) {
                        pathStack.push(tempNode.left);
                        sumStack.push(tempVal + tempNode.left.val);
                  }

                  if (tempNode.right != null) {
                        pathStack.push(tempNode.right);
                        sumStack.push(tempVal + tempNode.right.val);
                  }
            }

            return false;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(4);
            root.left.left = new TreeNode(11);
            root.left.left.left = new TreeNode(7);
            root.left.left.right = new TreeNode(2);

            root.right = new TreeNode(8);
            root.right.left = new TreeNode(13);
            root.right.right = new TreeNode(4);
            root.right.right.right = new TreeNode(1);

            int target = 22;

            System.out.println(hasPathSum(root,target));
      }
}

