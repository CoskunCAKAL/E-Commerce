package com.haratres.controller;

import com.haratres.entity.User;
import com.haratres.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;


    @GetMapping
    public String getAllAccount(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String mail = authentication.getName();

        User currentUser=accountService.findByUserMail(mail);

        model.addAttribute("user",currentUser);
        return "account/user-details";
    }



    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user")User user){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String mail = authentication.getName();
        User currentUser=accountService.findByUserMail(mail);
        currentUser.setName(user.getName());
        currentUser.setSurname(user.getSurname());
        currentUser.setTelephone(user.getTelephone());
        currentUser.setMail(user.getMail());
        currentUser.setAddress(user.getAddress());
        accountService.saveAccount(currentUser);
        return "login/login";
    }

}
