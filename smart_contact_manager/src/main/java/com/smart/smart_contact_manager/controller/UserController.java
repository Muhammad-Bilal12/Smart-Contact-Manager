package com.smart.smart_contact_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.smart_contact_manager.dao.UserRepository;
import com.smart.smart_contact_manager.entity.Contact;
import com.smart.smart_contact_manager.entity.User;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    @ResponseBody
    public String test() {

        User user = new User();
        user.setName("Bilal");
        user.setEmail("bilal@gmail.com");

        Contact contact = new Contact();
        contact.setName("Noman");
        user.getContacts().add(contact);

        userRepository.save(user);

        return "working...";
    }

}
