package ru.netology.springbootdockerfile.service;

import org.springframework.stereotype.Service;
import ru.netology.springbootdockerfile.domain.User;
import ru.netology.springbootdockerfile.enums.Authorities;
import ru.netology.springbootdockerfile.exception.InvalidCredentials;
import ru.netology.springbootdockerfile.exception.UnauthorizedUser;
import ru.netology.springbootdockerfile.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getUser()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getUser(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
