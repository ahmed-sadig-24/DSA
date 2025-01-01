import java.util.LinkedList;
import java.util.Queue;

public class ConvertSortedListToBST {
      // Definition for singly-linked list.
      public static class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                  this.val = val;
            }

            ListNode(int val, ListNode next) {
                  this.val = val;
                  this.next = next;
            }
      }

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

      public static TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                  return null;
            }

            if (head.next == null) {
                  return new TreeNode(head.val);
            }

            ListNode midNode = getMidNode(head);
            TreeNode root = new TreeNode(midNode.val);

            root.left = sortedListToBST(head);
            root.right = sortedListToBST(midNode.next);

            return root;
      }

      private static ListNode getMidNode(ListNode head) {
            ListNode prev = head;
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                  prev = slow;
                  slow = slow.next;
                  fast = fast.next.next;
            }

            if (prev != null) {
                  prev.next = null;
            }

            return slow;
      }

      public static void main(String[] args) {
            // Test Case 1: Empty List
            testCase(null, "Test Case 1: Empty List");

            // Test Case 2: Single Node List
            ListNode singleNodeList = createLinkedList(new int[]{1});
            testCase(singleNodeList, "Test Case 2: Single Node List");

            // Test Case 3: Two Nodes
            ListNode twoNodeList = createLinkedList(new int[]{1, 2});
            testCase(twoNodeList, "Test Case 3: Two Nodes");

            // Test Case 4: Odd Number of Nodes
            ListNode oddNodeList = createLinkedList(new int[]{-10, -3, 0, 5, 9});
            testCase(oddNodeList, "Test Case 4: Odd Number of Nodes");

            // Test Case 5: Even Number of Nodes
            ListNode evenNodeList = createLinkedList(new int[]{-10, -3, 0, 5});
            testCase(evenNodeList, "Test Case 5: Even Number of Nodes");
      }

      // Function to test a case and print results
      private static void testCase(ListNode head, String description) {
            System.out.println(description);
            TreeNode root = ConvertSortedListToBST.sortedListToBST(head);
            printTree(root);
            System.out.println();
      }

      // Utility function to create a linked list from an array
      private static ListNode createLinkedList(int[] values) {
            if (values == null || values.length == 0) {
                  return null;
            }
            ListNode head = new ListNode(values[0]);
            ListNode current = head;
            for (int i = 1; i < values.length; i++) {
                  current.next = new ListNode(values[i]);
                  current = current.next;
            }
            return head;
      }

      // Utility function to print a binary tree in level-order
      private static void printTree(TreeNode root) {
            if (root == null) {
                  System.out.println("Tree is empty.");
                  return;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                  TreeNode current = queue.poll();
                  if (current != null) {
                        System.out.print(current.val + " ");
                        queue.add(current.left);
                        queue.add(current.right);
                  } else {
                        System.out.print("null ");
                  }
            }
            System.out.println();
      }
}
