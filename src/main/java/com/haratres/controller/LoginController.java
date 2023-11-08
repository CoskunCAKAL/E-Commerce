package com.haratres.controller;

import com.haratres.entity.Role;
import com.haratres.entity.User;
import com.haratres.service.AccountService;
import com.haratres.service.UserRolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller

public class LoginController {
    @Autowired
    private AccountService userService;
    @Autowired
    private UserRolesService userRolesService;

    @GetMapping("/login")
    public String login(Model theModel) {
        theModel.addAttribute("user", new User());
        return "login/login";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        System.err.println(user.toString());

        if (userService.findByUserMail(user.getMail()) == null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);

            Role userRole = userRolesService.findRoleByName("USER");
            Set<Role> roles = new HashSet<>();
            roles.add(userRole);

            user.setRoles(roles);



            userService.saveAccount(user);
            user = userService.findByUserMail(user.getMail());



         //   userRolesService.save(userRoles);

        }
        return "redirect:/login";
    }
}
