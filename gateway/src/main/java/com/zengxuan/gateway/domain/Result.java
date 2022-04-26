package com.zengxuan.gateway.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * 通用协议基础类
 *
 * @author dongmingjun
 * @since 2021/3/24 
 */

public class Result<T> {

    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }

    private Integer code;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer level;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.code = ResponseStatus.SUCCESS.getCode();
        this.message = ResponseStatus.SUCCESS.getMsg();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toJsonString() {
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 返回成功.
     * @param body 数据结果集.
     * @param <T> 指定的body
     * @return Result<body>
     */
    public static <T> Result<T> success(T body) {
        Result<T> result = new Result<T>();
        result.setCode(ResponseStatus.SUCCESS.getCode());
        result.setMessage(ResponseStatus.SUCCESS.getMsg());
        result.setData(body);
        return result;
    }

    /**
     * 返回成功.
     * @param message msg
     * @param body 数据结果集.
     * @param <T> 指定的body
     * @return Result<body>
     */
    public static <T> Result<T> success(String message, T body) {
        Result<T> result = new Result<T>();
        result.setCode(ResponseStatus.SUCCESS.getCode());
        result.setMessage(message);
        result.setData(body);
        return result;
    }

    /**
     * 返回成功.
     * @return Result<body>
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.setCode(ResponseStatus.SUCCESS.getCode());
        result.setMessage(ResponseStatus.SUCCESS.getMsg());
        return result;
    }

    /**
     * 返回错误.
     * @param code 错误码.
     * @param message 提示消息.
     * @return Result<body>
     */
    public static <T> Result<T> fail(Integer code, String message) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setMessage(message);
        result.setLevel(ResponseStatus.FAILURE.getLevel());
        return result;
    }

    /**
     * 返回错误.
     * @param responseStatus 错误码.
     * @return Result<body>
     */
    public static <T> Result<T> fail(ResponseStatus responseStatus) {
        Result<T> result = new Result<T>();
        result.setCode(responseStatus.getCode());
        result.setMessage(responseStatus.getMsg());
        result.setLevel(responseStatus.getLevel());
        return result;
    }

}