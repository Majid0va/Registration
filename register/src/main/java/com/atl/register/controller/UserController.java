package com.atl.register.controller;

import com.atl.register.dto.UserDto;
import com.atl.register.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute("user") UserDto user, Model model) {
        System.out.println("get user" + user.getFirstName() + user.getLastName() + user.getEmail() + user.getPassword());
        userService.register(user);
        return "welcome";
    }

//    @PostMapping("/register")
//    public String userRegistration(final @Valid UserDto userData, final BindingResult bindingResult, final Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("registrationForm", userData);
//            return "account/register";
//        }
//        try {
//            userService.register(userData);
//        } catch (RuntimeException e) {
//            bindingResult.rejectValue("email", "userData.email", "An account already exists for this email.");
//            model.addAttribute("registrationForm", userData);
//            return "account/register";
//        }
//        return "welcome";
//    }
}