package com.demo.demo.web.error;

import com.demo.demo.core.exception.ErrorEnum;
import com.demo.demo.web.config.DemoResponse;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cb on 2017/3/23.
 * 错误controller
 */
@RestController
public class DemoErrController implements ErrorController {

    @RequestMapping("/error")
    public DemoResponse handleError() {
        return new DemoResponse(ErrorEnum.FAILED.code(), ErrorEnum.FAILED.message());
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
