package by.itstep.filipau.spring.repository;

import by.itstep.filipau.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);

    User findByActivationCode(String code);
}
