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
    @GetMapping("/hello")           // adres wywołujący metodę
    public String hello(){          // sygnatura metody
        return "hello world!";
    }
    @GetMapping("/hello/{name}")    // adres wywołujący metodę
    public String hello(@PathVariable String name){          // sygnatura metody
        return "hello "+name+"!";
    }

    @PostMapping("/register")    // adres wywołujący metodę
    public User register(String email, String password){          // sygnatura metody
        return userService.saveUser(email,password);
    }
//    @PutMapping("/confirm")
//    public User confirm(){
//        user.setActivity(true);
//        return user;
//    }


}
