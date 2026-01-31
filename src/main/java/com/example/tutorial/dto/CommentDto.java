package com.example.tutorial.dto;

import java.time.Instant;

public record CommentDto(Long id, String commentText, Instant commentedDate, Long postId) {

}
