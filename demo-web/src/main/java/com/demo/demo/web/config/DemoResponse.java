package com.demo.demo.web.config;

import com.demo.demo.core.exception.ErrorEnum;
import lombok.Data;

/**
 * Created by cb on 2017/3/23.
 * 统一response
 */
@Data
public class DemoResponse {
    private int code = ErrorEnum.SUCCESS.code();
    private String message = ErrorEnum.SUCCESS.message();

    private Object data;

    public DemoResponse() {
    }

    public DemoResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public DemoResponse(Object data) {
        this.data = data;
    }
}
