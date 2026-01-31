package com.example.tutorial.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "posts")
@Getter
@Setter
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Column(name = "post_created_date", updatable = false)
    private Instant createdDate;

    // list of comments
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post",
            fetch = FetchType.LAZY, orphanRemoval = true)
    List<Comment> comments = new ArrayList<>();

    private String author;

    public Post() {

    }

    public Post(Long id, String title, String description, Instant createdDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
    }

    @PrePersist
    public void presetCreatedDate() {
        this.createdDate = Instant.now();
    }

}
