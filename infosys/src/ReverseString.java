public class ReverseString {

      public static void main(String[] args) {
            String str = "infosys";

            String reverse = new StringBuilder(str).reverse().toString();
            System.out.println(reverse);
      }
}
