//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.lant.springboot_basic_use.vo;

import com.lant.springboot_basic_use.enums.ResultCode;

import java.io.Serializable;

public class ResultVo implements Serializable {
    private static final long serialVersionUID = 5063776667672736098L;
    private Integer code;
    private String message;
    private Object data;
    private long timestamp;

    public ResultVo() {
        this.code = ResultCode.RESULT_SUCCESS;
        this.message = "成功";
        this.timestamp = System.currentTimeMillis();
    }

    public ResultVo(Integer code, String message, Object data) {
        this.code = ResultCode.RESULT_SUCCESS;
        this.message = "成功";
        this.timestamp = System.currentTimeMillis();
        this.message = message;
        this.data = data;
        this.code = code;
    }

    public ResultVo(String message, Object data) {
        this.code = ResultCode.RESULT_SUCCESS;
        this.message = "成功";
        this.timestamp = System.currentTimeMillis();
        this.message = message;
        this.data = data;
    }

    public ResultVo(Object data) {
        this.code = ResultCode.RESULT_SUCCESS;
        this.message = "成功";
        this.timestamp = System.currentTimeMillis();
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
