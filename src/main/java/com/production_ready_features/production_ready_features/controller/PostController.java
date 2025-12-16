package com.production_ready_features.production_ready_features.controller;

import com.production_ready_features.production_ready_features.dto.PostsDTO;
import com.production_ready_features.production_ready_features.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping
    public ResponseEntity<List<PostsDTO>> findAllPosts()
    {
        return ResponseEntity.ok(postService.findAllPosts());
    }
    @PostMapping
    public ResponseEntity<PostsDTO> createNewPosts(@RequestBody PostsDTO postsDTO)
    {
        return ResponseEntity.ok(postService.createNewPosts(postsDTO));
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<PostsDTO> findPostById(@PathVariable  Long id)
    {
      return ResponseEntity.ok(postService.findPostById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PostsDTO> updatePosts(@RequestBody PostsDTO postsDTO,@PathVariable  Long id)
    {
        return ResponseEntity.ok(postService.updatePosts(postsDTO,id));
    }
}
