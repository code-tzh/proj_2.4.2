package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import web.model.User;
import web.services.UserService;


@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping("/user")
//    public String getUser(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("user", userService.getUserByName(authentication.getName()));
//        return "user";
//    }

    @GetMapping("/{id}")
    public String showUser(Principal principal, Model model){
        User username = userService.getUserByName(principal.getName());
        model.addAttribute("user", username);
        return "user";
    }
}