package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService service;
    public UserController (UserService service) {
        this.service = service;
    }

    @GetMapping()
    public String printUsers(Model model) {
        model.addAttribute("list", service.getUsers());
        return "users";
    }

    @GetMapping("/user")
    public String printUser(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "user";
    }

    @GetMapping("/user/edit")
    public String editUser(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "edit";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") int id) {
        service.deleteUser(id);
        return "redirect:/users";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") User user) {
        service.editUser(user);
        return "redirect:/users";
    }
}