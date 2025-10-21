public class InorderSuccessorInBST {
      // Definition for a binary tree node.
      public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                  val = x;
            }
      }

      public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode result = null;
            TreeNode prev = null;

            TreeNode curr = root;
            while (curr != null) {
                  if (curr.left == null) {
                        //
                        if (prev == p) {
                              result = curr;
                              break;
                        }
                        prev = curr;

                        curr = curr.right;
                  } else  {
                        TreeNode predecessor = curr.left;
                        while (predecessor.right != curr && predecessor.right != null) {
                              predecessor = predecessor.right;
                        }
                        if (predecessor.right == null) {
                              predecessor.right = curr;
                              curr = curr.left;
                        } else {
                              //
                              predecessor.right = null;
                              if (prev == p) {
                                    result =  curr;
                                    break;
                              }
                              prev = curr;

                              curr = curr.right;
                        }
                  }
            }

            return result;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(2);
            root.left = new TreeNode(1);
            root.right = new TreeNode(3);
            //root.left.left = new TreeNode(1);
            //root.left.right = new TreeNode(2);
            //root.right.left = new TreeNode(3);

            TreeNode p = new TreeNode(1);

            System.out.println(inorderSuccessor(root, p));
            //System.out.println(p.val);

      }
}
