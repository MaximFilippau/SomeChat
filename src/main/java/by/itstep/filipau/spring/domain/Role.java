package by.itstep.filipau.spring.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    USER,
    MODERATOR;

    @Override
public String getAuthority(){
        return name();
    }
}
