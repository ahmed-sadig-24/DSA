public class FindMissingNumber {

      public static void main(String[] args) {
            int[] arr = {1,2,4,5,6};

            int allXOR = 0;

            for(int i = 0; i <= arr.length + 1; i++) {
                  allXOR = allXOR ^ i;
            }

            for(int num: arr) {
                  allXOR = allXOR ^ num;
            }

            System.out.println(allXOR);;
      }
}
