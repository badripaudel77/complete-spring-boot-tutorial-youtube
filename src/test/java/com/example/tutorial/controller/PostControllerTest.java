package com.example.tutorial.controller;

import com.example.tutorial.dto.PostDto;
import com.example.tutorial.service.impl.PostService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

    @Mock
    PostService postService;

    @InjectMocks
    PostController underTest;
    @BeforeEach
    void setUp() {
        System.out.println("Set up ....");
    }

    @AfterEach
    void tearDown() {
        System.out.println("cleaning up ");
    }

    @Test
    void it_should_verify_get_all_posts() {
        List<PostDto> allPosts = new ArrayList<>();
        PostDto dto1 = new PostDto(1L, "Title1","Description" ,
                Instant.now());
        PostDto dto2 = new PostDto(1L, "Title1","Description" ,
                Instant.now());

        allPosts.add(dto1);
        allPosts.add(dto2);

        when(postService.getAllPosts()).thenReturn(allPosts);

        ResponseEntity<List<PostDto>> response = underTest.getAllPosts();
        assertEquals(response.getBody().size(), allPosts.size());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(postService, times(1)).getAllPosts();
    }
}