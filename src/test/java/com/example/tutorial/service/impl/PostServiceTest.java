package com.example.tutorial.service.impl;

import com.example.tutorial.dto.PostDto;
import com.example.tutorial.model.Post;
import com.example.tutorial.repository.PostRepository;
import com.example.tutorial.service.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    PostRepository postRepository;

    @Mock
    EmailService emailService;

    @InjectMocks
    PostService underTest;

    @Test
    void post_should_be_created_successfully() {
        Post request = new Post(1L, "Title", "Description", Instant.now());
        Post mockResponse = new Post(1L, "Title", "Description", Instant.now());
        when(postRepository.save(any())).thenReturn(mockResponse);

        // call
        PostDto actualResponse = underTest.createPost(request);

        assertNotNull(actualResponse);
        assertEquals(mockResponse.getId(), actualResponse.id());
        verify(postRepository, times(1)).save(any());
        verify(emailService, times(1)).sendEmail();
    }
}