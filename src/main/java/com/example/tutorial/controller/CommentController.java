package com.example.tutorial.controller;

import com.example.tutorial.dto.CommentDto;
import com.example.tutorial.model.Comment;
import com.example.tutorial.service.impl.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/{version}/comments", version = "v1")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/post/{postId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CommentDto> createComment(@RequestBody Comment request, @PathVariable("postId") Long id) {
        return ResponseEntity.
                ok(commentService.createComment(request, id));
    }

}
