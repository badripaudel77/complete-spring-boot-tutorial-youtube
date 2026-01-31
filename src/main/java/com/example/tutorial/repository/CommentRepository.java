package com.example.tutorial.repository;

import com.example.tutorial.model.Comment;
import com.example.tutorial.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findALlByPost(Post post);
    // JPQL
    @Query(value = "SELECT c FROM Comment c WHERE c.post.id = :postId ORDER BY c.commentedDate DESC")
    List<Comment> findAllCommentsByPostId(@Param("postId") Long postId);
}
