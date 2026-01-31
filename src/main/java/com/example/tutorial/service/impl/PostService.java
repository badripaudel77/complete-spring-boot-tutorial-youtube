package com.example.tutorial.service.impl;


import com.example.tutorial.dto.PostDto;
import com.example.tutorial.model.Post;
import com.example.tutorial.repository.PostRepository;
import com.example.tutorial.service.EmailService;
import com.example.tutorial.service.IPostService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService implements IPostService {
    private final PostRepository postRepository;
    private final EmailService emailService;

    public PostService(PostRepository postRepository, EmailService emailService) {
        this.postRepository = postRepository;
        this.emailService = emailService;
    }

    @Cacheable(value ="posts", key = "#root.method.name", unless = "#result.size() == 0")
    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = new ArrayList<>();
        posts.forEach(post -> {
            PostDto dto = new PostDto(post.getId(), post.getTitle(), post.getDescription(), post.getCreatedDate());
            postDtos.add(dto);
        });
        System.out.println("getting all posts from the db");
        return postDtos;
    }

    @Override
    public PostDto createPost(Post post) {
        Post savedPost = postRepository.save(post);
        // savedPost.getComments();
        // send the email
        emailService.sendEmail();
        return new PostDto(savedPost.getId(), savedPost.getTitle(),
                savedPost.getDescription(), savedPost.getCreatedDate());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
        try {
            emailService.sendAnotherEmail();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
