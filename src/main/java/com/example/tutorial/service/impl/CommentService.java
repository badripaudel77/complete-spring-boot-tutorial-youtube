package com.example.tutorial.service.impl;

import com.example.tutorial.dto.CommentDto;
import com.example.tutorial.model.Comment;
import com.example.tutorial.model.Post;
import com.example.tutorial.repository.CommentRepository;
import com.example.tutorial.repository.PostRepository;
import com.example.tutorial.service.ICommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(Comment comment, Long postId) {
        Optional<Post> byId = postRepository.findById(postId);
        if(byId.isEmpty()) {
            throw new RuntimeException("Posts with Id " + postId + " not found in the DB");
        }
        comment.setPost(byId.get());
        Comment savedComment = commentRepository.save(comment);
        return new CommentDto(savedComment.getId(), savedComment.getCommentText(),
                savedComment.getCommentedDate(), postId);
    }

    @Override
    public List<CommentDto> getCommentsForPost(Long postId) {
        boolean existsById = postRepository.existsById(postId);
        if(!existsById) {
            throw new RuntimeException("Posts with Id " + postId + " not found in the DB");
        }
        // commentRepository.findALlByPost((post....);
        List<Comment> comments = commentRepository.findAllCommentsByPostId(postId);
        List<CommentDto> commentDtos = new ArrayList<>();

        comments.forEach(comment -> {
            CommentDto dto = new CommentDto(comment.getId(), comment.getCommentText(),
                    comment.getCommentedDate(), postId);
            commentDtos.add(dto);
        });
        return commentDtos;
    }
}
