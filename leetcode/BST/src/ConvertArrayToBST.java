import java.util.Arrays;

public class ConvertArrayToBST {
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
      public static TreeNode sortedArrayToBST(int[] nums) {
           if (nums.length == 0) return null;

           return helper(nums, 0, nums.length - 1);
      }

      private static TreeNode helper(int[] nums, int left, int right) {
            if (left > right) return null;

            int mid = left + (right - left) / 2;
            TreeNode myNode = new TreeNode(nums[mid]);
            myNode.left = helper(nums, left, mid - 1);
            myNode.right = helper(nums, mid + 1, right);

            return myNode;
      }



      public static void main(String[] args) {
            int[] nums = {-10,-3,0,5,9};

            System.out.println(sortedArrayToBST(nums).val);
      }
}
