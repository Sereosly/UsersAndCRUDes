// src/main/java/web/controller/UserController.java
package web.controller;

import web.model.User;
import web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public final class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUser(@RequestParam(required = false) final Long id, final Model model) {
        if (id != null) {
            final User user = userService.findById(id);
            model.addAttribute("user", user);
            model.addAttribute("isEditMode", true);
        } else {
            model.addAttribute("user", new User());
            model.addAttribute("isEditMode", false);
        }
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @PostMapping("/users/create")
    public String createUser(@RequestParam String username, @RequestParam Byte age, @RequestParam String city) {
        final User user = new User(username, age, city);
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/users/update")
    public String updateUser(@RequestParam Long id, @RequestParam String username, @RequestParam Byte age, @RequestParam String city) {
        final User user = new User(id, username, age, city);
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}