package lk.creativelabs.jobseekers.security.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {
    private final String userId;
    private final String role;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String userId,String role) {
        super(username, password, authorities);
        this.userId = userId;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }
    public String getRole() {
        return role;
    }


}
