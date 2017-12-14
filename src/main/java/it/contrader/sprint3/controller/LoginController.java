package it.contrader.sprint3.controller;

import it.contrader.sprint3.model.UserEntity;
import it.contrader.sprint3.service.LoginService;
import it.contrader.sprint3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@ControllerAdvice
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value="/page")
    public String loginPage()
    {
        return "loginPage";
    }

    @RequestMapping(value="/test", method = RequestMethod.POST)
    public String test (@RequestParam("username") String username, @RequestParam("password") String password, Model model)
    {

        UserEntity user = loginService.login(username, password);

        if (user == null) {
            return "loginPage";
        }

        model.addAttribute("username", user.getFirstname());
        model.addAttribute("password", user.getLastname());
        return "test";
    }
}
