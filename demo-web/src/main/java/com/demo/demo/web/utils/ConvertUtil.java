package com.demo.demo.web.utils;

import com.demo.demo.core.entity.UserMail;
import com.demo.demo.web.login.vo.UserRegisterVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

/**
 * Created by cb on 2017/3/30.
 * VO和entity转换工具
 */
public class ConvertUtil {
    /**
     * 将注册的VO对象转换为USer对象
     *
     * @param vo
     * @return
     */
    public static UserMail registerVO_UserToMail(UserRegisterVO vo) {
        UserMail userMail = new UserMail();
        copyNotNull(vo, userMail);
        return userMail;
    }


    /**
     * 获取传入的VO对象中是null的属性
     *
     * @param source
     * @return
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null
                        || "".equals(wrappedSource.getPropertyValue(propertyName)))
                .toArray(String[]::new);
    }

    /**
     * 将不是Null的属性copy给原来的属性
     *
     * @param source
     * @param target
     */
    public static void copyNotNull(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }
}
