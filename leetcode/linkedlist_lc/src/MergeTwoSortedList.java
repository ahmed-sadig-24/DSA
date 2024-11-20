import java.util.Arrays;

public class MergeTwoSortedList {

      public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummyNode = new ListNode(Integer.MAX_VALUE);
            ListNode headNode = dummyNode;

            while (list1 != null && list2 != null) {
                  if (list1.val < list2.val) {
                        dummyNode.next = list1;
                        list1 = list1.next;
                  } else {
                        dummyNode.next = list2;
                        list2 = list2.next;
                  }
                  dummyNode = dummyNode.next;
            }

            if (list1 == null) {
                  dummyNode.next = list2;
            } else if (list2 == null) {
                  dummyNode.next = list1;
            }

            return headNode.next;
      }

      public static void main(String[] args) {
            int[] list1 = {1, 2, 4};
            int[] list2 = {1, 3, 4};

            //mergeTwoLists(list1, list2);
            //System.out.println(Arrays.toString(mergeTwoLists(list1, list2)));
      }
}
