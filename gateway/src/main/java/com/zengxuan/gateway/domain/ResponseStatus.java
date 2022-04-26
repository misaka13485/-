package com.zengxuan.gateway.domain;

/**
 * 接口请求基本信息
 *
 * @author dongmingjun
 * @since 2021/3/30 
 */
public enum ResponseStatus {

    // 成功
    SUCCESS(0, "请求处理成功"),
    // 失败
    FAILURE(101, "请求处理失败"),
    // 接口不存在
    BAD_REQUEST(404, "请求参数异常"),
    // 服务内部错误
    INTERNAL_SERVER_ERROR(500, "服务器异常"),
    // 数据库出错
    SQL_FAILURE_MESSAGE(501, "数据库出错"),
    // 导表出错
    EXPORT_ERROE(502, "导表出错");

    private final Integer DEFAULT_LEVEL = 400;

    private Integer code;

    private String msg;

    private Integer level;

    ResponseStatus(Integer code, String msg){
        this.code = code;
        this.msg = msg;
        this.level = DEFAULT_LEVEL;
    }

    ResponseStatus(Integer code, String msg, Integer level){
        this.code = code;
        this.msg = msg;
        this.level = level;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getLevel() {
        return level;
    }
}