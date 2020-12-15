package by.itstep.filipau.spring.controller;

import by.itstep.filipau.spring.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @RequestMapping("/chat")
    public String index(@AuthenticationPrincipal User user,
                        Model model) {

        model.addAttribute("user", user);

        return "chat";
    }

    @GetMapping(path = "/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping(path = "/login")
    public String doLogin(HttpServletRequest request,
                          @AuthenticationPrincipal User user, Model model) {

        model.addAttribute("username", user.getUsername());

        return "redirect:/";
    }

}
