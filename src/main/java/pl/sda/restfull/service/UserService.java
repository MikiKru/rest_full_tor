package pl.sda.restfull.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.restfull.model.User;
import pl.sda.restfull.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(String email, String password) {
        User user = new User(email, password);
        // zapis do bazy danych
        // INSERT INTO user VALUES (default, ?, ?, default, default);
        userRepository.save(user);
        return user;
    }

    public User confirmUser(Long id) {
        if(userRepository.findById(id).isPresent()) {
            User user = userRepository.getOne(id);
            // aktywacja konta
            user.setActivity(true);
            return userRepository.save(user);
        }
        return new User();
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public boolean deleteUser(Long id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public User getUserById(Long id){
        if(userRepository.findById(id).isPresent()){
            return userRepository.getOne(id);
        }
        return new User();
    }

}
