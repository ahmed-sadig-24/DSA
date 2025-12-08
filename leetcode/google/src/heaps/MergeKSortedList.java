package heaps;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {
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

      public static ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                  return null;
            }

            PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

            for (ListNode node: lists) {
                  if (node != null) minHeap.offer(node);
            }

            ListNode dummy = new ListNode(Integer.MIN_VALUE);
            ListNode curr = dummy;
            while (!minHeap.isEmpty()) {
                  ListNode smallest = minHeap.poll();
                  curr.next = smallest;
                  curr = curr.next;

                  if (smallest.next != null) {
                        minHeap.offer(smallest.next);
                  }
            }

            return dummy.next;
      }

      public static void main(String[] args) {
            int[][] lists = {{1,4,5}, {1,3,4}, {2,6}};

            ListNode[] nodes = new ListNode[lists.length];
            for (int i = 0; i < lists.length; i++) {
                  nodes[i] = buildList(lists[i]);
            }

            ListNode merged = mergeKLists(nodes);
            printList(merged);
      }

      // Convert array to linked list
      private static ListNode buildList(int[] arr) {
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            for (int val : arr) {
                  curr.next = new ListNode(val);
                  curr = curr.next;
            }
            return dummy.next;
      }

      // Print a linked list
      private static void printList(ListNode head) {
            while (head != null) {
                  System.out.print(head.val + " ");
                  head = head.next;
            }
            System.out.println();
      }
}
