package com.example.tutorial.service;

import com.example.tutorial.dto.CommentDto;
import com.example.tutorial.dto.PostDto;
import com.example.tutorial.model.Post;

import java.util.List;


public interface IPostService {
    public List<PostDto> getAllPosts();

    public PostDto createPost(Post post);

    void deletePost(Long postId);
}
