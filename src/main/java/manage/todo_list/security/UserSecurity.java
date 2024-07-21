package manage.todo_list.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserSecurity {

    public boolean hasUserId(Authentication authentication, Integer userId) {
        Integer currentUserId = (Integer) authentication.getDetails();
        return currentUserId.equals(userId);
    }
}
