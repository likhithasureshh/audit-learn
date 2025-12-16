package com.production_ready_features.production_ready_features.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostsDTO {
    private Long id;
    private String title;
    private String description;
}
