package sn.origin.management.users;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/")
    public String home(Model model) {
        List<User> usersList = service.allUsers();

        model.addAttribute("usersList", usersList);

        return "home";
    }

    @GetMapping("/add")
    public String getUserForm(Model model) {

        model.addAttribute("user", new User());
        return "user_form";
    }

    @PostMapping("/save")
    public String saveUser(User user) {

        service.save(user);
        return "redirect:/";
    }
}
