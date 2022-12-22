package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

//    @Autowired
//    public UsersController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping("/")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "getAll";
    }

    @GetMapping("/{id}")
    public String find(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "find";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.addNewUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/";
    }
    @DeleteMapping("{/id}")
    public String delete(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/";
    }


}
