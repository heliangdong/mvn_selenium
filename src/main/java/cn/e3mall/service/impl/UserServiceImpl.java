package cn.e3mall.service.impl;

import cn.e3mall.mapper.UserMapper;
import cn.e3mall.pojo.User;
import cn.e3mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public void save(User user) {
        userMapper.save(user);
    }
}
