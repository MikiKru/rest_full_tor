package pl.sda.restfull.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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


}
