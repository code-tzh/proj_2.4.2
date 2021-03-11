package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAllUsers(Model model) {
        //List<User> tableUsers = UserService.allUsers();
        model.addAttribute("users", userService.allUsers());
        return "users";
    }

    @GetMapping("/addUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String editUser(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        userService.editUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam Long id, Model model) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
