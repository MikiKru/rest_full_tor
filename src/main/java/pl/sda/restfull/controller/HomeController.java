package pl.sda.restfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.restfull.model.User;
import pl.sda.restfull.service.UserService;

@RestController                     // obsługa żądań http
public class HomeController {
    UserService userService;
    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")    // adres wywołujący metodę
    public User register(String email, String password){          // sygnatura metody
        return userService.saveUser(email,password);
    }
    @PutMapping("/confirm/{id}")
    public User confirm(@PathVariable Long id){
        return userService.confirmUser(id);
    }


}
