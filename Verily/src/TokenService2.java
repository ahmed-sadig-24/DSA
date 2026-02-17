import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenService2 {

      private final Map<String, Long> tokenExpiryMap = new ConcurrentHashMap<>();

      public void issueToke(String token, long expiryTime) {
            tokenExpiryMap.put(token, expiryTime);
      }

      public boolean isValidToken(String token, long currentTime) {
            if (token == null || token.isEmpty()) return false;

            Long expiry = tokenExpiryMap.get(token);

            return expiry != null && expiry <= currentTime;
      }
}
