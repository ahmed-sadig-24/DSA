public class BSTSearch {
//For your reference:
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
      static Boolean search_node_in_bst(BinaryTreeNode root, Integer value) {
            // Write your code here.
            while (root != null && root.value != value) {
                  root = root.value > value ? root.left : root.right;
                  //root = value < root.value ? root.left : root.right;
            }
            return root != null;
      }

      static Boolean search_node_in_bst2(BinaryTreeNode root, Integer value) {
            // Write your code here.
            if (root == null) return null;

            if (root.value.equals(value)) {
                  return true;
            }

            if (root.value > value) {
                  return search_node_in_bst2(root.left, value);
            } else {
                  return search_node_in_bst2(root.right, value);
            }
      }


      public static void main(String[] args) {

            //BinaryTreeNode myNode = new BinaryTreeNode(4);
            //myNode.left = new BinaryTreeNode(2);
            //myNode.left.left = new BinaryTreeNode(1);
            //myNode.right = new BinaryTreeNode(7);

            //BinaryTreeNode myNode = new BinaryTreeNode(20);
            //myNode.left = new BinaryTreeNode(10);
            //myNode.right = new BinaryTreeNode(30);

            BinaryTreeNode myNode = new BinaryTreeNode(2);
            myNode.left = new BinaryTreeNode(1);
            myNode.right = new BinaryTreeNode(5);
            myNode.right.left = new BinaryTreeNode(4);
            myNode.right.right = new BinaryTreeNode(6);

            //System.out.println(searchBST(myNode, 2));
            System.out.println(search_node_in_bst(myNode, 4));
            //System.out.println(search_node_in_bst2(myNode, 4));
            //System.out.println(myNode.val);
      }

}
