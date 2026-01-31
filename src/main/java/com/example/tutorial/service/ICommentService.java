package com.example.tutorial.service;

import com.example.tutorial.dto.CommentDto;
import com.example.tutorial.model.Comment;

import java.util.List;

public interface ICommentService {
    public CommentDto createComment(Comment comment, Long postId);

    public List<CommentDto> getCommentsForPost(Long postId);

}
