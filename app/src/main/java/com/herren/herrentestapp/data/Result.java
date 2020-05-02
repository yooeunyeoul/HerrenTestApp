package com.herren.herrentestapp.data;

public class Result<T> {

    Result(Status status, T data, String message) {

    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(Status.SUCCESS, data, null);
    }

    public static <T> Result<T> error(T data, String message) {
        return new Result<T>(Status.ERROR, data, message);
    }

    public static <T> Result<T> loading(T data) {
        return new Result<T>(Status.LOADING, data, null);
    }

    enum Status {
        SUCCESS,
        ERROR,
        LOADING
    }


}
