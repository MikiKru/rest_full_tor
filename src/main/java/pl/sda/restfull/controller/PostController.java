package pl.sda.restfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.restfull.model.enums.CategoryEnum;
import pl.sda.restfull.service.PostService;

@RestController
public class PostController {
    PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/addPost/{id}")
    public String addPost(@PathVariable Long id, String title, String content, CategoryEnum category){
        return postService.addPost(id, title, content, category);
    }
    @PutMapping("/changeTitle/{user_id}/{post_id}")
    public String changeTitle(
            @PathVariable Long user_id,
            @PathVariable Long post_id,
            String new_title){
        return postService.changeTitle(user_id,post_id,new_title);
    }
    @DeleteMapping("/deletePost/{post_id}/{user_id}")
    public void deletePost(@PathVariable Long post_id, Long user_id){
        postService.removePost(user_id, post_id);
    }
}
