package com.smart.smart_contact_manager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.smart_contact_manager.dao.UserRepository;
import com.smart.smart_contact_manager.entity.User;
import com.smart.smart_contact_manager.helper.Message;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home - Smart Contact Manager");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About - Smart Contact Manager");
        return "about";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("title", "Register - Smart Contact Manager");
        model.addAttribute("user", new User());
        return "signup";
    }

    // handling user Registration form
    @PostMapping("/do_register")
    public String postMethodName(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
            @RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,
            HttpSession session) {

        try {
            if (!agreement) {
                System.out.println("Please Accept our terms and conditions");
                throw new Exception("Please Accept our terms and conditions");
            }

            if (bindingResult.hasErrors()) {
                System.out.println("ERROR" + bindingResult.toString());
                model.addAttribute("user", user);
                return "signup";
            }

            user.setEnabled(true);
            user.setImageUrl("default.png");
            user.setRole("ROLE_USER");

            System.out.println("Signup success");
            System.out.println(user);
            System.out.println(agreement);

            User uResult = this.userRepository.save(user);
            model.addAttribute("user", uResult);

            session.setAttribute("message", new Message("Successfully Registered!", "alert-success"));
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("message", new Message("Something went wrong! " + e.getMessage(), "alert-danger"));

        }
        return "signup";
    }

}
