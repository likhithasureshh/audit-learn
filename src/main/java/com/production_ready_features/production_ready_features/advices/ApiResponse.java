package com.production_ready_features.production_ready_features.advices;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApiResponse<T> {
    private T data;
    private ApiError error;
    private LocalDate timeStamp;

    public ApiResponse( ) {
        this.timeStamp = LocalDate.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }
}
