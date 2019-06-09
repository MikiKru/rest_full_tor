package pl.sda.restfull.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.restfull.model.Comment;
import pl.sda.restfull.model.Post;
import pl.sda.restfull.model.User;
import pl.sda.restfull.model.enums.CategoryEnum;
import pl.sda.restfull.repository.CommentRepository;
import pl.sda.restfull.repository.PostRepository;
import pl.sda.restfull.repository.RoleRepository;
import pl.sda.restfull.repository.UserRepository;

@Service
public class PostService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    PostRepository postRepository;
    CommentRepository commentRepository;
    @Autowired
    public PostService(UserRepository userRepository, RoleRepository roleRepository, PostRepository postRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }
    public String addComment(Long post_id, Long user_id, String comment_message){
        if(postRepository.findById(post_id).isPresent() && userRepository.findById(user_id).isPresent()) {
            Post post = postRepository.getOne(post_id);
            User user = userRepository.getOne(user_id);
            Comment comment = new Comment(comment_message, user, post);
            commentRepository.save(comment);
            return "dodano komentarz!";
        }
        return "błędne id posta lub użtrkownika";
    }
    public void deleteComment(Long comment_id, Long user_id){
        User user = userRepository.getOne(user_id);
        Comment comment = commentRepository.getOne(comment_id);
        if(comment.getUser() == user){
            commentRepository.delete(comment);
        }
    }
    public String addPost(Long user_id, String title, String content, CategoryEnum category) {
        if (userRepository.findById(user_id).isPresent()) {
            User user = userRepository.getOne(user_id);
            if (user.getRoles().contains(roleRepository.getOne(1L))) {
                postRepository.save(new Post(title, content, category, user));
                return "dodano posta.";
            }
            return "brak uprawnień do dodawania postów!";
        }
        return "błędne dane id użytkownika!";
    }

    public String changeTitle(Long user_id, Long post_id, String new_title) {
        if (userRepository.findById(user_id).isPresent()) {
            if (userRepository.getOne(user_id).getRoles().contains(roleRepository.getOne(2L))) {
                Post post = postRepository.findFirstByTitle(postRepository.getOne(post_id).getTitle());
                post.setTitle(new_title);
                postRepository.save(post);
                return "zmodyfikowano tytuł posta";
            }
            return "brak uprawnień";
        }
        return "błędne id użytkownika";
    }

    public void removePost(Long user_id, Long post_id) {
        if (userRepository.findById(user_id).isPresent() && postRepository.findById(post_id).isPresent()) {
            Post post = postRepository.getOne(post_id);
            User user = userRepository.getOne(user_id);
            if (user.getRoles().contains(roleRepository.getOne(2L))
                    || post.getUser()== user)
                postRepository.delete(post);
        }
    }
}
