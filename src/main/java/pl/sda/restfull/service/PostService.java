package pl.sda.restfull.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.restfull.model.Post;
import pl.sda.restfull.model.User;
import pl.sda.restfull.model.enums.CategoryEnum;
import pl.sda.restfull.repository.PostRepository;
import pl.sda.restfull.repository.RoleRepository;
import pl.sda.restfull.repository.UserRepository;

@Service
public class PostService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    PostRepository postRepository;
    @Autowired
    public PostService(UserRepository userRepository, RoleRepository roleRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.postRepository = postRepository;
    }

    public String addPost(Long user_id, String title, String content, CategoryEnum category){
        if(userRepository.findById(user_id).isPresent()){
            User user = userRepository.getOne(user_id);
            if(user.getRoles().contains(roleRepository.getOne(1L))){
                postRepository.save(new Post(title,content,category,user));
                return "dodano posta.";
            }
            return "brak uprawnień do dodawania postów!";
        }
        return "błędne dane id użytkownika!";
    }
}
