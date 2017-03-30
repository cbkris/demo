package com.demo.demo.web.config;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by cb on 2017/3/30.
 * 统一控制器的返回值为DemoResponse
 */
@Component
public class DemoHttpMessageConverters extends MappingJackson2HttpMessageConverter {
    /**
     * 如果是自定义响应,直接序列化,如果不是的话,就包装成自定义的DemoResponse,然后序列化
     * @param object
     * @param type
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if (!(object instanceof DemoResponse)){
            DemoResponse response = new DemoResponse();
            //将对应的返回值放入自定义的响应中
            response.setData(object);
            object = response;
        }

        super.writeInternal(object, type, outputMessage);
    }
}







