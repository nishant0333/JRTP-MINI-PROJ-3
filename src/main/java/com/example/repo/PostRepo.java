package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {

}
