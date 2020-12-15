package by.itstep.filipau.spring.domain;

import by.itstep.filipau.spring.validation.PasswordConfirm;
import by.itstep.filipau.spring.validation.UniqueEmail;
import by.itstep.filipau.spring.validation.UniqueUsername;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.dom4j.tree.AbstractEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@UniqueEmail(message = "email существует")
@UniqueUsername(message = "Логин существует")
@PasswordConfirm(message = "Пароль не совпадает")
public class User extends AbstractEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Transient
    private String passwordConfirm;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> roles;

    @Email
    @NotBlank
    private String email;

    private String activationCode;

    private boolean isActive;

    private boolean isMuted;

    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }

    public boolean isModerator() {
        return roles.contains(Role.MODERATOR);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    @OneToMany(mappedBy = "chatSender", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ChatMessage> ownerOfMessage;

}