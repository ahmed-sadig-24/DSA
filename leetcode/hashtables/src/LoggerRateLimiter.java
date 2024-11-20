import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

      public LoggerRateLimiter() {
            //logMap = new HashMap<>();
      }

      public static boolean shouldPrintMessage(int timestamp, String message) {
            Map<String, Integer> logMap = new HashMap<>();

            if (!logMap.containsKey(message)) {
                  logMap.put(message, timestamp + 10);
                  return true;
            }

            if (logMap.get(message) > timestamp) {
                  return false;
            }

            logMap.put(message,timestamp + 10);
            return false;
      }

      public static void main(String[] args) {
            int timestamp = 1;
            String message = "foo";

            System.out.println(shouldPrintMessage(timestamp, message));
      }
}
