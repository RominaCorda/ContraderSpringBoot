package it.contrader.sprint3.controller;

import it.contrader.sprint3.model.UserEntity;
import it.contrader.sprint3.service.LoginService;
import it.contrader.sprint3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(value="/menu", method = RequestMethod.POST)
    public String menu (@RequestParam("username") String username, @RequestParam("password") String password, Model model)
    {

        UserEntity user = loginService.login(username, password);

        if (user == null)
        {
            model.addAttribute("msg","Credenziali non valide");
            return "loginPage";
        }

        model.addAttribute("FirstName", user.getFirstname());
        model.addAttribute("LastName", user.getLastname());

        if(user.getRole().equalsIgnoreCase("admin"))
            return "menuAdmin";
        else
            return "menuUser";
    }


    @RequestMapping(value="/regControl", method=RequestMethod.POST)
    public String control (@ModelAttribute UserEntity User, Model model, RedirectAttributes redirectAttrs)
    {
        String username = User.getUsername();
        String password = User.getPassword();
        UserEntity user = loginService.login(username, password);
        //model.addAttribute("user",user);
        if (user != null)
        {
            model.addAttribute("msg","Username già in uso...");
            return "insertUser";
        }
        else
            {
                model.addAttribute("user",User);
                redirectAttrs.addFlashAttribute("user",User);
                return  "redirect:/users/newUser";

            }

    }

}