public class InfiniteArraySearch {

      static int ans(int[] arr, int target) {
            int start = 0;
            int end = 1;
            int val = arr[0];

            while (target > arr[end]) {
                  int temp = end + 1;
                  end = end * 2; //end + (end - start + 1) * 2;
                  start = temp;

                  //start = end;
                  //end = end * 2;
                  //val = arr[end];
            }

            return binarySearch(arr, target, start, end);
      }

      static int binarySearch(int[] arr, int target, int start, int end) {
            while (start <= end) {
                  int mid = start +  (end - start) / 2;

                  //System.out.println(arr[mid]);
                  if (target == arr[mid]) {
                        //System.out.println(arr[mid]);
                        return mid;
                  } else if (target < arr[mid]) {
                        end = mid - 1;
                  } else {
                        start = mid + 1;
                        //System.out.println("start: " + start);
                  }
            }

            return -1;
      }

      public static void main(String[] args) {
            int[] arr = {3,5,7,9,10,90,100,120,130,140,160};
            int target = 100;

            System.out.println(ans(arr,target));
      }
}
