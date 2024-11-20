import java.util.*;

public class MinIndexSum {
      public static String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, Integer> myHashMap = new HashMap<>();

            for (int i = 0; i < list1.length; i++) {
                  myHashMap.put(list1[i], i);
            }

            int minIndex = Integer.MAX_VALUE;
            int sumIndex = 0;
            List<String> result = new ArrayList<>();

            for (int i = 0; i < list2.length; i++) {
                  //if (myHashMap.get(list2[i]) != null) {
                  if(myHashMap.containsKey(list2[i])) {
                        sumIndex = i + myHashMap.get(list2[i]);
                        if (sumIndex < minIndex) {
                              result.clear();
                              result.add(list2[i]);
                        } else if (sumIndex == minIndex) {
                              result.add(list2[i]);
                        }

                        minIndex = Math.min(sumIndex, minIndex);
                  }
            }

            String[] arr = new String[result.size()];
            return result.toArray(arr);
      }

      public static void main(String[] args) {
            //String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
            //String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};

            //String[] list1 = {"happy","sad","good"};
            //String[] list2 = {"sad","happy","good"};

            //String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
            //String[] list2 = {"KNN", "KFC", "Burger King", "Tapioca Express","Shogun"};

            String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
            String[] list2 = {"KFC","Shogun","Burger King"};

            //System.out.println(Arrays.toString(findRestaurant(list1, list2)));
            System.out.println(Arrays.toString(findRestaurant(list1, list2)));
      }
}
