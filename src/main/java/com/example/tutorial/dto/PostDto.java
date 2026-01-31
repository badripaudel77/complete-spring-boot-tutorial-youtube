package com.example.tutorial.dto;

import java.time.Instant;

public record PostDto(Long id, String title, String description, Instant createdDate) {

}
