package ru.netology.springbootdockerfile.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springbootdockerfile.domain.User;
import ru.netology.springbootdockerfile.enums.Authorities;
import ru.netology.springbootdockerfile.service.AuthorizationService;


import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {

    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }
}
