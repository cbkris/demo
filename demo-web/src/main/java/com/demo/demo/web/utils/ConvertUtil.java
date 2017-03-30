package com.demo.demo.web.utils;

import com.demo.demo.core.entity.UserToMail;
import com.demo.demo.web.login.vo.UserRegisterVO;

/**
 * Created by cb on 2017/3/30.
 * VO和entity转换工具
 */
public class ConvertUtil {
    /**
     * 将注册的VO对象转换为USer对象
     * @param vo
     * @return
     */
    public static UserToMail registerVO_UserToMail(UserRegisterVO vo){
        UserToMail userToMail = new UserToMail();
        userToMail.setMail(vo.getEmail());
        userToMail.setPwd(vo.getPwd());
        return userToMail;
    }



}
