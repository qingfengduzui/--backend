package org.example.test_second.dto;

public class ApiStatus {
    public static final int SUCCESS = 200;
    public static final String SUCCESS_MESSAGE = "Success";

    public static final int BAD_REQUEST = 400;
    public static final String BAD_REQUEST_MESSAGE = "Bad Request";

    public static final int UNAUTHORIZED = 401;
    public static final String UNAUTHORIZED_MESSAGE = "Unauthorized";

    public static final int FORBIDDEN = 403;
    public static final String FORBIDDEN_MESSAGE = "Forbidden";

    public static final int NOT_FOUND = 404;
    public static final String NOT_FOUND_MESSAGE = "Not Found";

    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final String INTERNAL_SERVER_ERROR_MESSAGE = "Internal Server Error";
}
