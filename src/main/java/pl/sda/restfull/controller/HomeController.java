package pl.sda.restfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.restfull.model.User;
import pl.sda.restfull.service.UserService;
import java.util.List;

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
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
    @GetMapping("/users/{id}")
    public User getUserById(Long id){
        return userService.getUserById(id);
    }
    @PutMapping("/setAdmin/{id}")
    public User setAdmin(@PathVariable Long id){
        return userService.setRole(id,2L);
    }


}
