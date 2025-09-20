package com.spring.tutorial.studentmanagement.dto;

import org.springframework.http.HttpStatus;

public class ResponseDto<T> {
    HttpStatus status;
    String message;
    T data;

    public ResponseDto() {
    }


    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseDto(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
