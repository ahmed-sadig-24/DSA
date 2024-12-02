import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
      public static boolean canAttendMeetings(int[][] intervals) {
            if (intervals == null || intervals.length <= 1) {
                  return true;
            }

            Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

            for (int i = 1; i < intervals.length; i++) {
                  if (intervals[i - 1][1] > intervals[i][0]) {
                        return false;
                  }
            }

            return true;
      }

      public static void main(String[] args) {
            int[][] intervals1 = {{0,30},{5,10},{15,20}};
            int[][] intervals2 = {{7,10},{2,4}};

            System.out.println(canAttendMeetings(intervals1));
            System.out.println(canAttendMeetings(intervals2));
      }
}
