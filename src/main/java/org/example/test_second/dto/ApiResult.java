package org.example.test_second.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<T> implements Serializable {
    private int code;
    private String msg;
    private T data;
    private String timestamp;
    private static final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static <T> ApiResult<T> ok() {
        return ok(ApiStatus.SUCCESS_MESSAGE, null);
    }

    public static <T> ApiResult<T> ok(T data) {
        return ok(ApiStatus.SUCCESS_MESSAGE, data);
    }

    public static <T> ApiResult<T> ok(String msg, T data) {
        if (msg != null) {
            return new ApiResult<>(
                    ApiStatus.SUCCESS,
                    ApiStatus.SUCCESS_MESSAGE,
                    data,
                    LocalDateTime.now().format(TIME_FORMAT));
        }
        return null;
    }

    public static <T> ApiResult<T> fail(String msg, int code) {
        return new ApiResult<>(code, msg, null, LocalDateTime.now().format(TIME_FORMAT));
    }

    public boolean isFail() {
        return this.code != ApiStatus.SUCCESS;
    }

    public boolean isSuccess() {
        return this.code == ApiStatus.SUCCESS;
    }
}

