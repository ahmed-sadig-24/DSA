import java.util.Map;
import java.util.Set;

public class Permission {

      public boolean hasPermission(
              String user,
              String permission,
              Map<String, Set<String>> userRoles,
              Map<String, Set<String>> rolePermission
      ) {
            for (String role: userRoles.getOrDefault(user, Set.of())) {
                  if (rolePermission.getOrDefault(role, Set.of()).contains(permission)) {
                        return true;
                  }
            }

            return false;
      }

      public boolean hasPermission2(
              String user,
              String permission,
              Map<String, Set<String>> userRoles,
              Map<String, Set<String>> rolePermission
      ) {
            for (String role: userRoles.getOrDefault(user, Set.of())) {
                  if (rolePermission.getOrDefault(role, Set.of()).contains(permission)) {
                        return true;
                  }
            }

            return false;
      }

}
