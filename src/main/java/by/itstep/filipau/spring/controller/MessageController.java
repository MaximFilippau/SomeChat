package by.itstep.filipau.spring.controller;

import by.itstep.filipau.spring.domain.ChatMessage;
import by.itstep.filipau.spring.servises.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/messages")
public class MessageController {

    public final ChatMessageService chatMessageService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model){
        model.addAttribute("messages", chatMessageService.messages());
        return "messages";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{message}")
    public String deleteMessage(
            Model model,
            @PathVariable ChatMessage message){
        chatMessageService.deleteMessage(message);
        model.addAttribute("messages", chatMessageService.messages());
        return "redirect:/messages";
    }

}
