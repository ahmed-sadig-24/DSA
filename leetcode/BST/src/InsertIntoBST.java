public class InsertIntoBST {

      //Definition for a binary tree node.
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

      public static TreeNode insertIntoBST(TreeNode root, int val) {
            TreeNode newNode = new TreeNode(val);

            if (root == null) {
                  return newNode;
            }

            TreeNode curr = root;
            while (true) {
                  if (newNode.val == curr.val) {
                        return root;
                  }
                  if (newNode.val < curr.val) {
                        if (curr.left == null) {
                              curr.left = newNode;
                              return root;
                        }
                        curr = curr.left;
                  } else {
                        if (curr.right == null) {
                              curr.right = newNode;
                              return root;
                        }
                        curr = curr.right;
                  }
            }
            //return root;
      }

      public static void main(String[] args) {
            TreeNode myNode = new TreeNode(4);
            myNode.left = new TreeNode(2);
            myNode.left.left = new TreeNode(1);
            myNode.left.right = new TreeNode(3);
            myNode.right = new TreeNode(7);

            insertIntoBST(myNode, 5);
            //System.out.println(insertIntoBST(myNode,5));
            System.out.println(myNode.right.left.val);
      }

}
