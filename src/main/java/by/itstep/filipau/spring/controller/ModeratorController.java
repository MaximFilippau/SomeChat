package by.itstep.filipau.spring.controller;

import by.itstep.filipau.spring.domain.User;
import by.itstep.filipau.spring.servises.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/userss")
public class ModeratorController {

    public final UserService userService;

    @PreAuthorize("hasAuthority('MODERATOR')")
    @GetMapping
    public String userList(Model model){
        model.addAttribute("userss", userService.users());
        return "userss";
    }

    @PreAuthorize("hasAuthority('MODERATOR')")
    @GetMapping("mute/{user}")
    public String muteUser(@PathVariable User user, Model model){
        model.addAttribute("userss", userService.users());
        userService.muteUser(user);
        return "userss";
    }

    @PreAuthorize("hasAuthority('MODERATOR')")
    @GetMapping("unmute/{user}")
    public String unmuteUser(@PathVariable User user, Model model){
        model.addAttribute("userss", userService.users());
        userService.unmuteUser(user);
        return "userss";
    }

    @PreAuthorize("hasAuthority('MODERATOR')")
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ){
        userService.saveUser(user, username, form);
        return "redirect:/userss";
    }


}