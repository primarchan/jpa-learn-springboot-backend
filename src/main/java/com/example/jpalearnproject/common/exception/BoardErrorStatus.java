package com.example.jpalearnproject.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BoardErrorStatus {

    INTERNAL_SERVER_ERROR(500, "internal server error", HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_FOUND_RESERVATION(15000, "게시글을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST)
    ;


    private final int code;
    private final String reason;
    private final HttpStatus httpStatus;

    BoardErrorStatus(int code, String reason, HttpStatus httpStatus) {
        this.code = code;
        this.reason = reason;
        this.httpStatus = httpStatus;
    }
}
