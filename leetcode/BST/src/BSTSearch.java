public class BSTSearch {

        //Definition for a binary tree node.
        public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
               this.val = val;
                this.left = left;
                this.right = right;
            }
        }


        public static TreeNode searchBST(TreeNode root, int val) {
              while (root != null && root.val != val) {
                    root = root.val < val ? root.right : root.left;
              }

              return root;
        }

      public static void main(String[] args) {
              /*
            TreeNode myNode = new TreeNode(4);
            myNode.left = new TreeNode(2);
            myNode.left.left = new TreeNode(1);
            myNode.right = new TreeNode(7);

               */

            /*
            TreeNode myNode = new TreeNode(62);
            myNode.right = new TreeNode(93);
            myNode.left = new TreeNode(2);
            //myNode.left.left = null;
            myNode.left.right = new TreeNode(30);
            myNode.left.right.left = new TreeNode(15);

             */

            TreeNode myNode = null;

            //System.out.println(searchBST(myNode, 2));
            System.out.println(searchBST(myNode, 15));
            //System.out.println(myNode.val);
      }
}
