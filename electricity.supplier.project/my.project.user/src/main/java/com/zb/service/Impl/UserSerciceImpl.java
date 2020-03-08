package com.zb.service.Impl;

import com.zb.dto.Dto;
import com.zb.dto.DtoUtil;
import com.zb.entity.User;
import com.zb.mapper.UserMapper;
import com.zb.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSerciceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Dto UpdateUserInfo(User newUser) {

        ///lolwwwww 有了认证服务之后 改成根据id修改
        Integer result = userMapper.updateUserInfoByPhone(newUser);
        if (result == 1) {
            return DtoUtil.returnSuccess("修改成功");
        }


        return DtoUtil.returnFail("修改失败", "8005");
    }

    @Override
    public Integer updatePirSrc(String src, String id) {
        return userMapper.updatePirSrc(src, id);
    }
}
