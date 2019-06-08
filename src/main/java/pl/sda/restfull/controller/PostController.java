package pl.sda.restfull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.restfull.service.PostService;

@RestController
public class PostController {
    PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/addPost/{id}")
    public String addPost(@PathVariable Long id, String title, String content){
        return postService.addPost(id, title, content);
    }
}
