package pl.sda.restfull.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.restfull.model.Role;
import pl.sda.restfull.model.User;
import pl.sda.restfull.repository.RoleRepository;
import pl.sda.restfull.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class UserService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    public User setRole(Long user_id, Long role_id){
        if(userRepository.findById(user_id).isPresent()
                && roleRepository.findById(role_id).isPresent()) {
            User user = userRepository.getOne(user_id);
            Role role = roleRepository.getOne(role_id);
            user.addRole(role);
            return userRepository.save(user);
        }
        return new User(); }
    public User saveUser(String email, String password) {
        User user = new User(email, password);
        // przypisanie roli ROLE_USER po rejestracji
        setRole(user.getId(),1L);
        // INSERT INTO user VALUES (default, ?, ?, default, default);
        userRepository.save(user);
        return user; }

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
