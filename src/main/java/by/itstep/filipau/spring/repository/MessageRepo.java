package by.itstep.filipau.spring.repository;

import by.itstep.filipau.spring.domain.ChatMessage;
import by.itstep.filipau.spring.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepo extends JpaRepository<ChatMessage, Long> {


}
