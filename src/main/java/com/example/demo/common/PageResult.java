package com.example.demo.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by huage on 2018/8/23.
 */
@Data
public class PageResult<T> implements Serializable{
    /**
     * 返回消息提示
     */
    private String msg;
    /**
     * 返回消息编码
     */
    private Integer code;

    /**
     * 具体数据对象
     */
    private T data;
    /**
     * 如果是列表,返回总条数
     */
    private int totalRecord;

    /**
     * 页码
     */
    private int pageNo;

    /**
     * 单页大小
     */
    private int pageSize;

    /**
     * 创建一个result
     */
    public PageResult() {
    }

    public PageResult(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.code == 0;
    }

    public void value(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
