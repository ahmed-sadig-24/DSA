import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
      public static void main(String[] args) {
            BinarySearchTree myBST = new BinarySearchTree();
/*
            myBST.insert(47);
            myBST.insert(21);
            myBST.insert(76);
            myBST.insert(18);
            myBST.insert(27);
            myBST.insert(52);
            myBST.insert(82);

 */

            //myBST.insert(27);

            //System.out.println(myBST.minValue(myBST.root));
            //System.out.println(myBST.minValue(myBST.root.right));

            //System.out.println("Root = " + myBST.root.value);
            //System.out.println(myBST.root.left.right.value);

            //System.out.println(myBST.BFS());
            /*
            System.out.println("\nPreOrder: ");
            System.out.println(myBST.DFSPreOrder());
            System.out.println("\nPostOrder: ");
            System.out.println(myBST.DFSPostOrder());
            System.out.println("\nInOrder: ");
            System.out.println(myBST.DFSInOrder());

             */
           /*
            myBST.insert(2);
            myBST.insert(1);
            myBST.insert(3);

            System.out.println("\nRoot: " + myBST.root.value);
            System.out.println("\nRoot->Left: " + myBST.root.left.value);
            System.out.println("\nRoot->Right: " + myBST.root.right.value);

            myBST.deleteNode(2);

            System.out.println("\nRoot: " + myBST.root.value);
            System.out.println("\nRoot->Left: " + myBST.root.left.value);
            System.out.println("\nRoot->Right: " + myBST.root.right);

            //System.out.println(myBST.rContains(21));
            //System.out.println(myBST.rContains(17));

            */
            //int[] nums = {-10, -3, 0, 5, 9};
            //System.out.println(Arrays.toString(myBST.sortedArrayToBST(nums,0,4)));
            //System.out.println(Arrays.toString(miniHeap.toArray()));
            //System.out.println(Arrays.toString(myBST.sortedArrayToBST(nums,0,4).toArray()));
            //myBST.sortedArrayToBST(nums,0,4);

            /*
            myBST.insert(4);
            myBST.insert(1);
            myBST.insert(2);
            myBST.insert(3);
            myBST.insert(6);
            myBST.insert(7);
            myBST.insert(9);
            System.out.println("\nRoot: " + myBST.root.value);
            System.out.println("\nRoot->Left: " + myBST.root.left.value);
            System.out.println("\nRoot->Left->Left: " + myBST.root.left.left);
            System.out.println("\nRoot->Right: " + myBST.root.right.value);
            System.out.println("\nRoot->Right->Right: " + myBST.root.right.right.value);
             */

            //myBST.insert(3);
            //myBST.root.left = new BinarySearchTree.Node(2);
            //myBST.insert(4);
            //myBST.insert(2);
            //myBST.insert(5);
            //myBST.insert(1);
            //myBST.insert(3);
            //myBST.insert(10);
/*
            myBST.insert(5);
            myBST.insert(1);
            myBST.insert(4);
            myBST.insert(0);
            myBST.insert(0);
            myBST.insert(3);
            myBST.insert(6);


 */
            /*
            BinarySearchTree bst = new BinarySearchTree();
            bst.insert(5);
            bst.insert(4);
            bst.insert(6);
            //bst.insert(null);
            bst.insert(3);
            bst.insert(7);
            //bst.insert(2);
            //myBST.sortBST(bst);
            //printIsValidBST(bst);
            System.out.println(bst.isValidBST());

             */

            BinarySearchTree bst = new BinarySearchTree();

            bst.insert(5);
            bst.insert(3);
            bst.insert(7);
            bst.insert(2);
            bst.insert(4);
            bst.insert(6);
            bst.insert(8);

            //System.out.println(bst.kthSmallest(1));  // Expected output: 2
            System.out.println(bst.kthSmallest(3));  // Expected output: 4
            //System.out.println(bst.kthSmallest(6));  // Expected output: 7

      }
      private static void printIsValidBST(BinarySearchTree bst) {
            System.out.println("Is valid BST: " + bst.isValidBST());
      }
}
