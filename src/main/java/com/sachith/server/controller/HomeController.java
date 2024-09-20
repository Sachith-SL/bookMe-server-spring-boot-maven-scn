package com.sachith.server.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@CrossOrigin()
public class HomeController {

    @GetMapping()
    public String greeting(HttpServletRequest request){
        return "Wel come to Book with Me Application \n"+request.getSession().getId();
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
