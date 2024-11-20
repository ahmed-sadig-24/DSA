import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MakeArrayZero {
      public static int minimumOperations(int[] nums) {
            Set<Integer> mySet = new HashSet<>();

            for (int num: nums) {
                  if (num != 0) {
                        mySet.add(num);
                  }
            }

            return mySet.size();
      }

            public static int minimumOperationsHeap(int[] nums) {
                  int ans= 0;
                  //PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
                  PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

                  while(true){
                        for(int i : nums){
                              if(i != 0)
                                    maxHeap.offer(i);
                        }
                        if(maxHeap.isEmpty()){
                              break;
                        }
                        int minEle = maxHeap.poll();
                        for(int i = 0;i<nums.length;i++){
                              if(nums[i] != 0){
                                    nums[i] = nums[i] - minEle;
                              }
                        }
                        ans++;
                        if(!maxHeap.isEmpty()){
                              maxHeap.clear();
                        }
                  }
                  return ans;
            }

      public static void main(String[] args) {
            int[] nums = {1,5,0,3,5};
            //int[] nums = {0};

            System.out.println(minimumOperations(nums));
            System.out.println(minimumOperationsHeap(nums));
      }
}