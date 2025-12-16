package com.production_ready_features.production_ready_features.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data

public class ApiError {

    private LocalDateTime timeStamp=LocalDateTime.now();
    private String message;
    private HttpStatus status;

    public ApiError() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiError(String message, HttpStatus status) {

        this.message = message;
        this.status = status;
    }
}
