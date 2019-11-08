package cn.ngmc.service.impl;

import cn.ngmc.dao.UserMapper;
import cn.ngmc.entity.User;
import cn.ngmc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public int regiter(User user) {
        return userMapper.insert(user);
    }

    public User getUser(Long uid) {
        return userMapper.selectById(uid);
    }

    public int editUser(User user) {
        return userMapper.updateById(user);
    }
}
