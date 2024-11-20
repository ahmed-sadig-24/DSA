public class LongestSubstring {
      public static int lengthOfLongestSubstring(String s) {
            int max = 0;

            for (int rp = 0, lp = 0; rp < s.length(); rp++) {
                  int index = s.indexOf(s.charAt(rp),lp);
                  //System.out.println("lp: " + lp);
                  //System.out.println("rp: " + rp);
                  //System.out.println("ch(rp)" + s.charAt(rp));
                  //System.out.println("ch(lp)" + s.charAt(lp));
                  System.out.println("index: " + index);

                  if (index != rp) {
                        //System.out.println("ch(lp): " + s.charAt(lp));
                        lp = index + 1;
                        System.out.println(lp);
                  }
                  max = Math.max(max, rp - lp + 1);
            }

            return max;
      }

      public static void main(String[] args) {
            //String s = "abcabcbb";
            //String s = "bbbbb";
            String s = "pwwkew";

            //System.out.println(s.indexOf("w",3));

            System.out.println(lengthOfLongestSubstring(s));
      }
}
