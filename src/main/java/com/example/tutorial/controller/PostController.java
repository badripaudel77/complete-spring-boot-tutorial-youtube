package com.example.tutorial.controller;

import com.example.tutorial.dto.CommentDto;
import com.example.tutorial.dto.PostDto;
import com.example.tutorial.model.Post;
import com.example.tutorial.service.impl.CommentService;
import com.example.tutorial.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/{version}/posts", version = "v1")
public class PostController {
    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping()
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> allPosts = postService.getAllPosts();
        // return ResponseEntity.ok(allPosts);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allPosts);
    }

    @PostMapping()
    public ResponseEntity<PostDto> createPost(@RequestBody Post request) {
        PostDto post = postService.createPost(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(post);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<CommentDto>> getAllCommentsForPost(@PathVariable Long postId) {
        List<CommentDto> commentsForPost = commentService.getCommentsForPost(postId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(commentsForPost);
    }

}
