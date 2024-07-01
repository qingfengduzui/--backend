package org.example.test_second.pojo;

public class ResultTest<T> {
    private int code; // 状态码，例如：200表示成功，500表示服务器内部错误
    private String message; // 响应消息
    private T data; // 响应中的数据

    // 构造函数
    private ResultTest(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 快速创建Result对象的静态方法
    public static <T> ResultTest<T> success(T data) {
        return new ResultTest<>(200, "操作成功", data);
    }

    public static <T> ResultTest<T> success() {
        return new ResultTest<>(200, "操作成功", null);
    }

    public static <T> ResultTest<T> error(int code, String message) {
        return new ResultTest<>(code, message, null);
    }

    // Getter和Setter
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
}