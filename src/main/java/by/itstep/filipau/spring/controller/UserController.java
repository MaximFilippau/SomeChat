package by.itstep.filipau.spring.controller;

import by.itstep.filipau.spring.domain.User;
import by.itstep.filipau.spring.servises.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    public final UserService userService;

    @GetMapping
    public String editUser(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/password")
    public String password() {
        return "password";
    }

    @PostMapping("/password")
    public String editUser(
            @RequestParam(name = "oldPassword", defaultValue = "", required = false) String oldPassword,
            @RequestParam(name = "newPassword", defaultValue = "", required = false) String newPassword,
            @RequestParam(name = "confirmPassword", defaultValue = "", required = false) String confirmPassword,
            Model model,
            @AuthenticationPrincipal User user) {

        Map<String, String> errorMap = userService.changePassword(oldPassword, newPassword, confirmPassword, user);
        if (errorMap.isEmpty()) {
            return "redirect:/logout";
        }
        model.mergeAttributes(errorMap);
        return "password";
    }

    @GetMapping("/email")
    public String userEmail() {
        return "email";
    }

    @PostMapping("/email")
    public String changeEmail(
            @RequestParam(name = "oldEmail", defaultValue = "") String oldEmail,
            @RequestParam(name = "newEmail", defaultValue = "") String newEmail,
            @AuthenticationPrincipal User user,
            Model model
    ) {
        Map<String, String> emailErrors = userService.changeEmail(oldEmail, newEmail, user);
        if (emailErrors.isEmpty()) {
            return "redirect:/logout";
        } else {
            model.mergeAttributes(emailErrors);
            model.addAttribute("oldEmail", oldEmail);
            model.addAttribute("newEmail", newEmail);
        }
        return "email";
    }

    @GetMapping("/username")
    public String username() {
        return "username";
    }

    @PostMapping("/username")
    public String changeUsername(
            @RequestParam(name = "oldUsername", defaultValue = "", required = false) String oldUsername,
            @RequestParam(name = "newUsername", defaultValue = "", required = false) String newUsername,
            @RequestParam(name = "currentPassword", defaultValue = "", required = false) String currentPassword,
            Model model,
            @AuthenticationPrincipal User user) {

        Map<String, String> usernameError = userService.changeUsername(oldUsername, newUsername, currentPassword, user);
        if (usernameError.isEmpty()) {
            return "redirect:/logout";
        }
        model.mergeAttributes(usernameError);
        return "username";
    }

//    @GetMapping
//    public String getUsers(
//            @RequestParam(required = false) String usernameFilter,
//            @PageableDefault(sort = {"id", "name"}, direction = Sort.Direction.ASC) Pageable pageable,
//            Model model
//    ) {
//        Page<User> page = userService.findAllUsers(usernameFilter, pageable);
//        model.addAttribute("page", page);
//
//        model.addAttribute("url", "/users");
//        model.addAttribute("usernameFilter", usernameFilter);
//
//
//        return "users";
//    }
}
