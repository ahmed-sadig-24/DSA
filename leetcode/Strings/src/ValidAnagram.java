public class ValidAnagram {
      public static boolean isAnagram(String s, String t) {
            s = s.replace(" ", "");
            t = t.replace(" ", "");

            if (s.length() != t.length()) return false;

            s = s.toLowerCase();
            t = t.toLowerCase();

            int[] numsCount = new int[26];

            for (int i = 0; i < s.length(); i++) {
                  numsCount[s.charAt(i) - 'a']++;
                  numsCount[t.charAt(i) - 'a']--;
            }

            for (int count: numsCount) {
                  if (count != 0) return false;
            }

            return true;
      }

      public static void main(String[] args) {
            String s = "silent";
            String t = "listen";

            System.out.println(isAnagram(s, t));
      }
}
