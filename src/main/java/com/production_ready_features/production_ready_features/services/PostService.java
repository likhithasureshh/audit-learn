package com.production_ready_features.production_ready_features.services;

import com.production_ready_features.production_ready_features.dto.PostsDTO;

import java.util.List;

public interface PostService
{
    List<PostsDTO> findAllPosts();
    PostsDTO createNewPosts(PostsDTO inputPost);
    PostsDTO findPostById(Long id);

    PostsDTO updatePosts(PostsDTO postsDTO,Long id);
}
