package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用结果对象
 * @param code 结果编码
 * @param message 结果信息
 * @param data 返回数据
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    private int code;
    private String message;
    private Object data;

}
