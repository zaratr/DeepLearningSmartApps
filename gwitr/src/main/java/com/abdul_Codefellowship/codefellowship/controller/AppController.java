package com.abdul_Codefellowship.codefellowship.controller;

import com.abdul_Codefellowship.codefellowship.model.AppUser;
import com.abdul_Codefellowship.codefellowship.repositories.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class AppController  {

    @Autowired
    AppRepository appRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/login")
    public String getLonginPage(){
        return "login";
    }
    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup";
    }


    @PostMapping("/logout")
    public RedirectView logoutUser(Principal p) {
        if (p != null) {
            try {
                request.logout();
            } catch (ServletException e) {
                System.out.println("Error logging out.");
                e.printStackTrace();
            }
        }
        return new RedirectView("/login");
    }




    @PostMapping("/signup")
    public RedirectView createUser(String username, String password, String firstName, String lastName, String dateOfBirth, String bio) {
        // hash the password!!!
        String hashedPw = passwordEncoder.encode(password);
        AppUser newUser = new AppUser(username, hashedPw,firstName,lastName,dateOfBirth,bio);
        appRepository.save(newUser);

        authWithHttpServletRequest(username, password);

        return new RedirectView("/login");
    }

    public void authWithHttpServletRequest(String username, String password)
    {
        try {
            request.login(username, password);
        } catch (ServletException e) {
            System.out.println("Error while logging in.");
            e.printStackTrace();
        }
    }


    @GetMapping("/aboutus")
    public String aboutUsPage(){
        return "aboutus.html";
    }



}

