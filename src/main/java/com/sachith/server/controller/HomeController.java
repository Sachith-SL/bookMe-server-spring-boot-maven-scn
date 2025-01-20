package com.sachith.server.controller;

import com.sachith.server.config.AppProperties;
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

    private final AppProperties appProperties;

    public HomeController(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @GetMapping("/info")
    public String getAppInfo() {
        return String.format("Name: %s, Version: %s, Author: %s",
                appProperties.getName(),
                appProperties.getVersion(),
                appProperties.getAuthor().getName());
    }

    @GetMapping("/test")
    public String getAppInfoByValue() {
        return String.format("%s",appProperties.getTest());
    }

    @GetMapping()
    public String greeting(HttpServletRequest request){
        return "Wel come to Book with Me Application \n"+request.getSession().getId();
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
