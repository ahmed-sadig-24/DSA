public class PeakIndexMountainArray {
      public static int peakIndexInMountainArray(int[] arr) {
            int start = 0;
            int end = arr.length - 1;

            while (start < end) {
                  int mid = start + (end - start) / 2;

                  //if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    //    System.out.println("aaa");
                      //  return mid;
                  //}
                  //System.out.println("arr[mid]: " + arr[mid]);//5
                  //System.out.println("arr[mid + 1]: " + arr[mid + 1]);
                  if (arr[mid] > arr[mid + 1]) {
                        //decreasing part of array
                        System.out.println("i am here");
                        end = mid;
                  } else {
                        // increasing part of the array
                        start = mid + 1;
                        //System.out.println("arr[start]: " + arr[start]);
                  }
            }

            return start;
      }

      public static void main(String[] args) {
            //int[] arr = {0,1,0};
            //int[] arr = {0,2,1,0};
            //int[] arr = {0,10,5,2};
            //int[] arr = {1,2,3,4,5,6,4,3,2};
            int[] arr = {2,3,4,10,6,4,3,2};

            System.out.println(peakIndexInMountainArray(arr));
      }
}
