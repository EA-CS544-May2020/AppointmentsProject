package cs544.project.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @RequestMapping("/")
    public String login() {
        String auth = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        return "User logged as "+ auth;
    }
}