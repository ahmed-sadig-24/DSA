public class ConvertSortedArrayToBinarySearchTree {

      //Definition for a binary tree node.
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

      public static TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) return null;

            return dfs(nums, 0, nums.length - 1);
      }

      private static TreeNode dfs(int[] nums, int left, int right) {
            if (left > right) return null;

            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(mid);
            root.left = dfs(nums, left, mid - 1);
            root.right = dfs(nums, mid + 1, right);

            return root;
      }

      public static void main(String[] args) {
            int[] nums1 = {-10,-3,0,5,9};

            //System.out.println(sortedArrayToBST(nums1).val);
      }

}
