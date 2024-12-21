public class BSTDeleteNode {
      // Definition for a binary tree node.
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

      public static TreeNode deleteNode(TreeNode root, int key) {
            TreeNode currentNode = root;

            if (currentNode == null) return null;

            if (key < currentNode.val) {
                  currentNode = deleteNode(currentNode.left,key);
            } else if (key > currentNode.val) {
                  currentNode = deleteNode(currentNode.right, key);
            } else {
                  if (currentNode.left == null && currentNode.right == null) {
                        return null;
                  } else if (currentNode.left == null) {
                        currentNode = currentNode.right;
                  } else if (currentNode.right == null) {
                        currentNode = currentNode.left;
                  } else {
                        int subTreeMin = minValue(currentNode.right);
                        currentNode.val = subTreeMin;
                        currentNode.right = deleteNode(currentNode.right, subTreeMin);
                  }
            }

            return currentNode;
      }

      public static int minValue(TreeNode currentNode) {
            while (currentNode.left != null) {
                  currentNode = currentNode.left;
            }

            return currentNode.val;
      }

      public static void main(String[] args) {
            TreeNode myNode = new TreeNode(5);
            myNode.left = new TreeNode(3);
            myNode.left.left = new TreeNode(2);
            myNode.left.right = new TreeNode(4);
            myNode.right = new TreeNode(6);
            //myNode.right.left = new TreeNode(7);
            myNode.right.right = new TreeNode(7);

            //System.out.println(minValue(myNode.right));
            deleteNode(myNode, 3);
            System.out.println(myNode.left.val);
      }
}
