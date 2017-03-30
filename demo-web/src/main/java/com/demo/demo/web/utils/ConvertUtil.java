package com.demo.demo.web.utils;

import com.demo.demo.core.entity.UserMail;
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
    public static UserMail registerVO_UserToMail(UserRegisterVO vo){
        UserMail userToMail = new UserMail();
        userToMail.setMail(vo.getEmail());
        userToMail.setPwd(vo.getPwd());
        return userToMail;
    }



}
