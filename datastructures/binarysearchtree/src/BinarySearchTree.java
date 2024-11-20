import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;
//import java.u

//import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
      Node root;

      class Node {
            int value;
            Node left;
            Node right;

            Node(int value) {
                  this.value = value;
            }
      }

      public boolean insert(int value) {
            Node newNode = new Node(value);

            if (root == null) {
                  root = newNode;
                  return true;
            }

            Node temp = root;

            while (true) {
                  if (temp.value == newNode.value) return false;

                  if (newNode.value < temp.value) {
                        if (temp.left == null) {
                              temp.left = newNode;
                              return true;
                        }
                        temp = temp.left;
                  } else {
                        if (temp.right == null) {
                              temp.right = newNode;
                              return true;
                        }
                        temp = temp.right;
                  }
            }
      }

      public boolean contains(int value) {
            Node temp = root;

            while (temp != null) {
                  if (value < temp.value) {
                        temp = temp.left;
                  } else if (value > temp.value) {
                        temp = temp.right;
                  } else {
                        return  true;
                  }
            }

            return false;
      }

      private boolean rContains(Node currentNode, int value) {
            if (currentNode == null) return false;

            if (currentNode.value == value) return true;

            if (value < currentNode.value) {
                  return rContains(currentNode.left, value);
            } else {
                  return rContains(currentNode.right, value);
            }
      }

      public boolean rContains(int value) {return rContains(root, value);}

      private Node rInsert(Node currentNode, int value) {
            if (currentNode == null) return new Node(value);

            if (value < currentNode.value) {
                  currentNode.left = rInsert(currentNode.left, value);
            } else if ( value > currentNode.value) {
                  currentNode.right = rInsert(currentNode.right, value);
            }

            return currentNode;
      }

      public void rInsert(int value) {
            if (root == null) root = new Node(value);

            rInsert(root, value);
      }

      private Node deleteNode(Node currentNode, int value) {
            if (currentNode == null) return null;

            if (value < currentNode.value) {
                  currentNode.left = deleteNode(currentNode.left, value);
            } else if (value > currentNode.value) {
                  currentNode.right = deleteNode(currentNode.right, value);
            } else {
                  if (currentNode.left == null && currentNode.right == null) {
                        return null;
                  } else if (currentNode.left == null) {
                        currentNode = currentNode.right;
                  } else if (currentNode.right == null) {
                        currentNode = currentNode.left;
                  } else {
                        int subTreeMin = minValue(currentNode.right);
                        currentNode.value = subTreeMin;
                        currentNode.right = deleteNode(currentNode.right,subTreeMin);
                  }
            }

            return currentNode;
      }

      public void deleteNode(int value) {
            deleteNode(root, value);
      }

      public int minValue(Node currentNode) {
            while (currentNode.left != null) {
                  currentNode = currentNode.left;
            }

            return currentNode.value;
      }

      public Node sortedArrayToBST(int[] nums, int left, int right) {
            if (left > right) return null;

            int midIndex = left + (right - left) / 2;
            Node midNode = new Node(nums[midIndex]);

            midNode.left = sortedArrayToBST(nums, left, midIndex - 1);
            midNode.right = sortedArrayToBST(nums,midIndex + 1, right);

            return midNode;
      }

      public boolean isBalanced() {
            return height(this.root) != -1;
      }

      private int height(Node node) {
            if (node == null) return 0;
            int leftHeight = height(node.left);
            if (leftHeight == -1) return -1;
            int rightHeight = height(node.right);
            if (rightHeight == -1) return -1;
            if (Math.abs(leftHeight - rightHeight) > 1) return -1;
            return 1 + Math.max(leftHeight, rightHeight);
      }

      private Node invertTree(Node node) {
            Node left = invertTree(root.left);
            Node right = invertTree(root.right);

            root.left = right;
            root.right = left;

            return root;

      }

      public TreeNode invertTree2(TreeNode root) {
            if (root == null) return null;

            Queue<TreeNode> myQueue = new LinkedList<>();
            myQueue.add(root);

            while (!myQueue.isEmpty()) {
                  final TreeNode myNode =  myQueue.poll();

                  final TreeNode temp = myNode.left;
                  myNode.left = myNode.right;
                  myNode.right = temp;

                  if (myNode.left != null) myQueue.add(myNode.left);
                  if (myNode.right != null) myQueue.add(myNode.right);
            }

            return root;
      }

      public class TreeNode {
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

      public ArrayList<Integer> BFS() {
            Node currentNode = root;
            Queue<Node> bfsQueue = new LinkedList<>();
            ArrayList<Integer> results = new ArrayList<>();

            bfsQueue.add(currentNode);

            while (!bfsQueue.isEmpty()) {
                  currentNode = bfsQueue.remove();
                  results.add(currentNode.value);

                  if (currentNode.left != null) {
                        bfsQueue.add(currentNode.left);
                  }
                  if (currentNode.right != null) {
                        bfsQueue.add(currentNode.right);
                  }
            }

            return results;
      }

      public ArrayList<Integer> DFSPreOrder() {
            ArrayList<Integer> results = new ArrayList<>();
            class Traverse {
                  Traverse(Node currentNode) {
                        results.add(currentNode.value);
                        if (currentNode.left != null) {
                              new Traverse(currentNode.left);
                        }
                        if (currentNode.right != null) {
                              new Traverse(currentNode.right);
                        }
                  }
            }
            new Traverse(root);

            return results;
      }

      public ArrayList<Integer> DFSPostOrder() {
            ArrayList<Integer> results = new ArrayList<>();
            class Traverse {
                  Traverse(Node currentNode) {
                        if (currentNode.left != null) {
                              new Traverse(currentNode.left);
                        }
                        if (currentNode.right != null) {
                              new Traverse(currentNode.right);
                        }
                        results.add(currentNode.value);
                  }
            }

            new Traverse(root);
            return results;
      }

      public ArrayList<Integer> DFSInOrder() {
            ArrayList<Integer> results = new ArrayList<>();

            class Traverse {
                  Traverse(Node currentNode) {
                        if (currentNode.left != null) {
                              new Traverse(currentNode.left);
                        }

                        results.add(currentNode.value);

                        if (currentNode.right != null) {
                              new Traverse(currentNode.right);
                        }
                  }
            }

            new Traverse(root);
            return results;
      }

      public ArrayList<Integer> sortBST() {
            if (root == null) return null;

            ArrayList<Integer> results = new ArrayList<>();

            class Traverse{
                  Traverse(Node currentNode) {
                        //results.add(currentNode.value);
                        if (currentNode.left != null) {
                              new Traverse(currentNode.left);
                        }
                        results.add(currentNode.value);
                        //System.out.println("res: " + results);
                        if (currentNode.right != null) {
                              new Traverse(currentNode.right);
                        }
                  }
            }

            new Traverse(root);
            //System.out.println("root: " + root.value);
            //System.out.println("res: " + results);
            return results;
      }

      public boolean isValidBST() {
            ArrayList<Integer> res = sortBST();
            //res = new ArrayList<>() ;
            System.out.println(res);
            //int prev = res.get(0);
            int current;
            int prev;
            for (int i = 1; i < res.size(); i++) {
                  current = res.get(i);
                  prev = res.get(i - 1);
                  //System.out.println("current: " + current);
                  //System.out.println("prev: " + prev);
                  if (current <= prev) {
                        //System.out.println("Not a valid BST");
                        //return Boolean.;
                        return false;
                  }
                  //prev = res.get(i);
                  //System.out.println("prev: " + prev);
                  //System.out.println(res.get(i));
            }
            return true;
      }

      public Integer kthSmallest(int k) {
            return 0;

      }

}
