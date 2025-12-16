package com.production_ready_features.production_ready_features.services;

import com.production_ready_features.production_ready_features.dto.PostsDTO;
import com.production_ready_features.production_ready_features.entities.PostEntity;
import com.production_ready_features.production_ready_features.exception.ResourceNotFoundException;
import com.production_ready_features.production_ready_features.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public  class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostsDTO> findAllPosts() {
        return postRepository.findAll()
                 .stream()
                 .map(postEntity -> modelMapper.map(postEntity,PostsDTO.class))
                 .collect(Collectors.toList());
    }

    @Override
    public PostsDTO createNewPosts(PostsDTO inputPost) {
        PostEntity postEntity=modelMapper.map(inputPost,PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity),PostsDTO.class);

    }

    @Override
    public PostsDTO findPostById(Long id) {
       PostEntity postEntity= postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post with this id is not present"+id));
       return modelMapper.map(postEntity,PostsDTO.class);
    }

    @Override
    public PostsDTO updatePosts(PostsDTO postsDTO,Long id) {

        PostEntity postEntity=postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("id is not present"));
        modelMapper.map(postsDTO,postEntity);
        postEntity.setId(id);
        return modelMapper.map(postRepository.save(postEntity),PostsDTO.class);
    }
}
