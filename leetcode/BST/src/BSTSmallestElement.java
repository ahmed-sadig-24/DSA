public class BSTSmallestElement {
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

      public static int kthSmallest(TreeNode root, int k)  {
                  TreeNode current = root;
                  int counter = 0;

                  while (current != null) {
                        if (current.left == null) {
                              System.out.println(current.val);
                              counter++;
                              if (counter == k) return current.val;
                              current = current.right;
                        } else {
                              //find the predecessor
                              TreeNode predecessor = current.left;
                              //To find predecessor keep going right till right node is not null or right node is not current
                              while (predecessor.right != current && predecessor.right != null) {
                                    predecessor = predecessor.right;
                              }
                              //if right node is null then go left after establishing the link from predecessor to current.
                              if (predecessor.right == null){
                                    predecessor.right = current;
                                    current = current.left;
                              } else { // left is already visited. Go right after visiting current.
                                    predecessor.right = null;
                                    System.out.println(current.val);
                                    counter++;
                                    if (counter == k) return current.val;
                                    current = current.right;
                              }
                        }
                  }
                  return -1;
      }

      public static void main(String[] args) {
            //TreeNode myNode = root;
            //kthSmallest(myNode, 3);
      }
}
