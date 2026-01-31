package com.example.tutorial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Entity
@Table(name = "comments")
@Getter
@Setter
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commentText;
    @Column(name = "commented_date", updatable = false)
    private Instant commentedDate;

    // @JsonIgnore
    @ManyToOne
    private Post post;

    @PrePersist
    public void presetCommentedDate() {
        this.commentedDate = Instant.now();
    }
}
