import java.util.*;

public class ThreeSum {
      public static List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) {
                  return new ArrayList<>();
            }

            ArrayList result = new ArrayList<>();

            //int left = 0;
            int right = nums.length - 1;
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                  int left = i + 1;

                  while (left < right) {
                        int sum = nums[i] + nums[left] + nums[right];

                        if (sum == 0) {
                              result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                              left++;
                              right--;
                        } else if (sum < 0) {
                              left++;
                        } else {
                              right--;
                        }
                  }
            }
            return result;
      }

      public static void main(String[] args) {
            int[] nums1 = {-1,0,1,2,-1,-4};
            int[] nums2 = {0,1,1};
            int[] nums3 = {0,0,0};

            //System.out.println(threeSum(nums1));
            //System.out.println(threeSum(nums2));
            //System.out.println(threeSum(nums3));

            //List<Integer> input = Arrays.asList(-1, 0, 1, 2, -1, -4);
            //System.out.println(find_zero_sum(input));
            ArrayList<Integer> list = new ArrayList<>();
            //Collections.addAll(list, -1,0,1,2,-1,-4);
            //Collections.addAll(list,10, 3, -4, 1, -6, 9);
            Collections.addAll(list, 4, -2, -2, -1, -3);
            System.out.println(find_zero_sum2(list));

      }

      static ArrayList<String> find_zero_sum(List<Integer> arr) {
            // Write your code here.
            if (arr == null || arr.size() < 3) return new ArrayList<>();

            Set<String> result = new HashSet<>();
            Collections.sort(arr);

            int right = arr.size() - 1;
            for (int i = 0; i < arr.size() - 2; i++) {
                  int left = i + 1;
                  while (left < right) {
                        int sum = arr.get(i) + arr.get(left)  + arr.get(right);

                        if (sum == 0) {
                             result.add(arr.get(i) + "," + arr.get(left) + "," + arr.get(right));
                        } else if (sum < 0) {
                              left++;
                        } else {
                              right--;
                        }
                  }
            }

            return new ArrayList<>(result);
      }

      static ArrayList<String> find_zero_sum2(ArrayList<Integer> arr) {
            if (arr == null || arr.size() < 3) return new ArrayList<>();

            Collections.sort(arr);
            HashSet<String> result = new HashSet<>();
            int left = 0;
            int right = arr.size() - 1;
            for (int i = 0; i < arr.size(); i++) {
                  left = i + 1;
                  while (left < right) {
                        int sum = arr.get(i) + arr.get(left) + arr.get(right);
                        //System.out.println(sum);
                        if (sum == 0) {
                              result.add(arr.get(i) + "," + arr.get(left) + "," + arr.get(right));
                              //System.out.println(result);
                              left++;
                              //right--;
                        } else if (sum < 0) {
                              left++;
                        } else {
                              right--;
                        }
                  }
            }

            // Write your code here.
            return new ArrayList(result);
      }
}
