public class MaxConsecutiveOnes3 {
      public static int longestOnes(int[] nums, int k) {
            int left = 0;
            int zeroCount = 0;
            int maxOnes = 0;

            for (int right = 0; right < nums.length; right++) {
                  if (nums[right] == 0) {
                        zeroCount++;
                  }

                  while (zeroCount > k) {
                        if (nums[left] == 0) {
                              zeroCount--;
                        }

                        left++;
                  }

                  maxOnes = Math.max(maxOnes, right - left + 1);
            }

            return maxOnes;
      }

      public static void main(String[] args) {
            int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0}; // 6
            int k1 = 2;

            int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
            int k2 = 3;

            System.out.println(longestOnes(nums1, k1));
            System.out.println(longestOnes(nums2, k2));
      }
}
