package com.zb.service.Impl;

import com.zb.dto.Dto;
import com.zb.dto.DtoUtil;
import com.zb.entity.User;
import com.zb.mapper.UserMapper;
import com.zb.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Dto login(String phone, String pwd) {

        User user = userMapper.getUserByPhone(phone);
        if (user == null) {
            return DtoUtil.returnFail("用户名或密码错误", "8002");
        }
        if (pwd != null && pwd.equals(user.getUserpwd())) {
        }

        return null;
    }
}
