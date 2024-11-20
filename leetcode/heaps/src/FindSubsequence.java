import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindSubsequence {
      public static int maxSubsequenceSum(int[] nums, int k) {
            if (nums.length == 0 || k <= 0 || k > nums.length) {
                  return -1;
            }

            int sum = 0;
            for (int i = 0; i < k; i++) {
                  sum += nums[i];
            }

            int maxSum = sum;
            int start = 0;
            for (int j = k; j < nums.length; j++) {
                  sum += nums[j] - nums[start++];

                  maxSum = Math.max(maxSum, sum);
            }

            return maxSum;
      }

      public static int[] maxSubsequence(int[] nums, int k) {
            if (nums.length ==0 || k<= 0 || k > nums.length) {
                  return new int[]{};
            };
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int[] tmp = new int[nums.length];

            for (int i = 0; i < k; i++) {
                  //System.out.println("i: " + i);
                  pq.add(i);
                  tmp[i] = 1;
            }

            for (int i = k; i < nums.length; i++) {
                  int j = (int) pq.peek();
                  System.out.println("j: " + j);
                  if (nums[j] < nums[i]) {
                        System.out.println("nums[j]: " + nums[j]);
                        System.out.println("nums[i]: " + nums[i]);
                        System.out.println("i: " + i);
                        pq.poll();
                        pq.add(i);
                        tmp[j] = 0;
                        tmp[i] = 1;
                  }
            }

            int[] result = new int[k];
            for (int i = 0, j = 0; i < tmp.length; i++) {
                  if (tmp[i] == 1)    result[j++] = nums[i];
            }

            return result;
      }

      public static int[] maxSubsequence3(int[] nums, int k) {
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            List<Integer> v=new ArrayList<>();
            for(int x:nums){
                  pq.add(x);
                  v.add(x);
            }

            int[] ans=new int[k];

            for(int i=0;i<nums.length-k;i++) {
                  //System.out.println(pq.remove());
                  //System.out.println(pq.peek());
                  v.remove(pq.remove());
            }

            for(int i=0;i<k;i++) {
                  //System.out.println(i);
                  ans[i]=v.get(i);
            }


            return ans;
            //return v.toArray();
      }

      public static void main(String[] args) {
            //int[] nums = {2,1,3,3};
            int[] nums = {-1, -2, 3, 4};
            int k = 3;

            //System.out.println(maxSubsequenceSum(nums, k));
            //System.out.println(Arrays.toString(maxSubsequence(nums, k)));
            System.out.println(Arrays.toString(maxSubsequence3(nums, k)));
      }
}
