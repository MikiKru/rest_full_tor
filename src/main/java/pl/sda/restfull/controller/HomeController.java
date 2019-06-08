package pl.sda.restfull.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.restfull.model.User;

@RestController                     // obsługa żądań http
public class HomeController {
    User user;
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
        user = new User(email,password);
        System.out.println(user);
        return user; }
    @PutMapping("/confirm")
    public User confirm(){
        user.setActivity(true);
        return user;
    }


}
