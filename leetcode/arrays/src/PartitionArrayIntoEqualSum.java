public class PartitionArrayIntoEqualSum {
      public static boolean canThreePartsEqualSum(int[] arr) {
            int totalSum = 0;
            for (int num: arr) {
                  totalSum += num;
            }

            if (totalSum % 3 != 0) return false;

            int targetSum = totalSum / 3;
            int currentSum = 0;
            int counter = 0;
            for (int num: arr) {
                  currentSum += num;
                  if (currentSum == targetSum) {
                        counter++;
                        currentSum = 0;
                  }
            }

            return (counter >= 3);
      }

      public static void main(String[] args) {
            //int[] arr = {0,2,1,-6,6,-7,9,1,2,0,1};
            //int[] arr = {0,2,1,-6,6,7,9,-1,2,0,1};
            int[] arr = {3,3,6,5,-2,2,5,1,-9,4};

            System.out.println(canThreePartsEqualSum(arr));
      }
}
