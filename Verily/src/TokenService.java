import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class TokenService {

      private final Map<String, Long> tokenExpiry = new HashMap<>();

      public void issueToken(String token, long currentTime) {
            Long expiry = tokenExpiry.get(token);
      }

      public boolean isValid(String token, long currentTime) {
            Long expiry = tokenExpiry.get(token);

            return expiry != null && currentTime < expiry;
      }
}
