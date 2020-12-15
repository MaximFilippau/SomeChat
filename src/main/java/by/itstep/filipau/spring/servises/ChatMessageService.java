package by.itstep.filipau.spring.servises;

import by.itstep.filipau.spring.domain.ChatMessage;
import by.itstep.filipau.spring.domain.User;
import by.itstep.filipau.spring.repository.MessageRepo;
import by.itstep.filipau.spring.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    public final MessageRepo messageRepo;

    public final UserRepo userRepo;

    public boolean saveMessage(ChatMessage message){
        User user = userRepo.findByUsername(message.getSender());
        if (!user.isMuted()){
            message.setChatSender(user);
            messageRepo.save(message);
            return true;
        }
        else{
            return false;
        }
    }

    public List<ChatMessage> messages(){
        return messageRepo.findAll();

    }

    public void deleteMessage(ChatMessage message) {
            messageRepo.delete(message);
    }


}
