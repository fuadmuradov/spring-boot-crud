package com.example.crudspringdata.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorConstants {
    TEACHER_NOT_FOUND("Teacher Not Found Exception", "TEACHER_NOT_FOUND"),
    STUDENT_NOT_FOUND("Student Not Found Exception", "STUDENT_NOT_FOUND"),
    UNEXPECTED_ERROR("Unexpected Error", "UNEXPECTED_ERROR");

    private final String message;
    private final String code;
}
