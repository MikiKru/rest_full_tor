package pl.sda.restfull.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.restfull.model.User;

@RestController                     // obsługa żądań http
public class HomeController {

    @GetMapping("/hello")           // adres wywołujący metodę
    public String hello(){          // sygnatura metody
        return "hello world!";
    }

    @GetMapping("/hello/{name}")    // adres wywołujący metodę
    public String hello(@PathVariable String name){          // sygnatura metody
        return "hello "+name+"!";
    }

    @PostMapping("/register")    // adres wywołujący metodę
    public User hello(@PathVariable String email,
                        @PathVariable String password){          // sygnatura metody
        User user = new User(email,password);
        System.out.println(user);
        return user;
    }


}
