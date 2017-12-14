package it.contrader.sprint3.controller;

import it.contrader.sprint3.model.UserEntity;
import it.contrader.sprint3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value="/getUsers", method = RequestMethod.GET)
    public String users (Model model) {
        List<UserEntity> users = userService.findByRole("user");
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value="/prova")
    public String newUser() {

        return "insertUser";
    }

    @RequestMapping(value="/newUser", method = RequestMethod.GET)
    public String newUser(@ModelAttribute UserEntity User){
        User.setRole("user");
        userService.insert(User);
        return "hello";
    }



}
