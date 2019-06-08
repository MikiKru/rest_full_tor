package pl.sda.restfull.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.restfull.model.User;
import pl.sda.restfull.repository.UserRepository;

@Service
public class UserService {
    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User saveUser(String email, String password){
        User user = new User(email,password);
        // zapis do bazy danych
        // INSERT INTO user VALUES (default, ?, ?, default, default);
        userRepository.save(user);
        return user;
    }
    public User confirmUser(Long id){
        User user = userRepository.getOne(id);
        // aktywacja konta
        user.setActivity(true);
        return userRepository.save(user);
        }
}
